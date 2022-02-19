package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private String email;
    private String password;
    private boolean isActive;
    private int roleId;
    private String role;
}
