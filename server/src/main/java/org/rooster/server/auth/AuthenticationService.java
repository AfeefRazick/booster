package org.rooster.server.auth;

import lombok.RequiredArgsConstructor;
import org.rooster.server.config.JwtService;
import org.rooster.server.user.Role;
import org.rooster.server.user.User;
import org.rooster.server.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseBody register(RegisterRequestBody body) {
        if (userRepository.findByUsername(body.getUsername()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        User user = User.builder()
                .displayName(body.getDisplayName())
                .username(body.getUsername())
                .password(passwordEncoder.encode(body.getPassword()))
                .role(body.getRole())
                .build();
        User savedUser = userRepository.save(user);
        String accessToken = jwtService.generateAccessToken(savedUser);
        String refreshToken = jwtService.generateRefreshToken(savedUser);

        // in ali bouali guide his approach is to have a token repository, that is a bit too much so i resort to a refreshToken field in User model
        // however there are benefits to his approach, like multiple token types, multiple tokens per user,
        // also security, since when the user object is being manipulated in business logic it is unsafe to have the refreshToken exposed.
        savedUser.setRefreshToken(refreshToken);
        userRepository.save(savedUser);
        return AuthenticationResponseBody.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponseBody login(LoginRequestBody body) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        body.getUsername(),
                        body.getPassword()
                )
        );
        // in ali bouali guide he uses the user repository to get user object after "authenticationManager.authenticate"
        // but the above authenticate method already uses DAOAuthProvider and userDetailsService to call the db and get the user object
        // this means there is a double call for the same user object, this is the wrong approach
        // instead we can reuse this by getting access to the authentication object of type UsernamePasswordAuthenticationToken,
        // and using the getPrincipal method. With no configuration to DAOAut... the principal is username,
        // that can be changed by overriding "createSuccessAuthentication" method.

        // user from db
        User user = (User) authentication.getPrincipal();
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        user.setRefreshToken(refreshToken);
        userRepository.save(user);
        return AuthenticationResponseBody.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponseBody refreshAccessToken(String refreshToken) {
        if (jwtService.isExpired(refreshToken)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        String username = jwtService.extractUsername(refreshToken);

        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN));

        String accessToken = jwtService.generateAccessToken(user);

        return AuthenticationResponseBody.builder()
                .accessToken(accessToken)
                .build();
    }
}