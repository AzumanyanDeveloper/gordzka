package am.gordzka.gordzka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue()
    private int id;
    private String name;
    private String surname;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String email;
    private String phoneNumber;
    private String password;
    private int locationId;
    private String imgPath;
    private String aboutMe;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks;


}
