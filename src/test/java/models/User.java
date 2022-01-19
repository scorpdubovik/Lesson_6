package models;

import lombok.*;

//@Getter
//@Setter
//@ToStringd
//@EqualsAndHashCode
@Data
@Builder
public class User {
    private String email;
    private String password;
    private int UUID;
}
