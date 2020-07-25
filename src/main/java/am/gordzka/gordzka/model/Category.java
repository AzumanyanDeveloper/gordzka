package am.gordzka.gordzka.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "category")
public class Category{


    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;
   // @Column
    //private int parentId;
    @Column
    private int count;

}
