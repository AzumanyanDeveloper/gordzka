package am.gordzka.gordzka.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column(name = "parent_id")
    private Integer parentId;
}
