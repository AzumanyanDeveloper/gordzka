package am.gordzka.gordzka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int age;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Enumerated(EnumType.STRING)

    @Column(name = "type")
    private UserType userType;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    @Column(name = "location_id")
    private int locationId;

    @Column(name = "img_path")
    private String imgPath;

    @Column(name = "aboutme")
    private String aboutMe;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Task> tasks;


}
