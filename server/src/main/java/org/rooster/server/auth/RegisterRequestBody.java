package org.rooster.server.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.rooster.server.user.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestBody {
    private String displayName;
    private String username;
    private String password;
    private Role role;
}
