package models;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
@Builder
public class User {
    private String email;
    private String password;
    private int UUID;
}
