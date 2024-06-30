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
    private String email;
    private String password;
    private String company;
    private String phone;
    private Role role;
}
