package org.rooster.server.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService service;

    @GetMapping("/reet")
    public ResponseEntity<String> reet() {
        return ResponseEntity.ok("works");
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseBody> register(@RequestBody RegisterRequestBody requestBody) {
        log.info("received register request");

        AuthenticationResponseBody responseBody = service.register(requestBody);
        String refreshToken = responseBody.getAccessToken();
        responseBody.setRefreshToken(null);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, refreshToken)
                .body(responseBody);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseBody> login(@RequestBody LoginRequestBody requestBody) {
        AuthenticationResponseBody responseBody = service.login(requestBody);
        String refreshToken = responseBody.getAccessToken();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, "refresh-token=" + refreshToken)
                .body(responseBody);
    }

    @GetMapping("/refresh")
    public ResponseEntity<AuthenticationResponseBody> refresh(@CookieValue("refresh-token") String refreshToken) {
        AuthenticationResponseBody responseBody = service.refreshAccessToken(refreshToken);

        return ResponseEntity
                .ok()
                .body(responseBody);
    }
}