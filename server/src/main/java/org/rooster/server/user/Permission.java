package org.rooster.server.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Getter
public enum Permission {
    EMPLOYEE_READ("management:read"),
    EMPLOYEE_UPDATE("management:update"),
    EMPLOYEE_CREATE("management:create"),
    EMPLOYEE_DELETE("management:delete"),
    
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
