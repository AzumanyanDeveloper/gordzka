package am.gordzka.gordzka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="task")
@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private  String name;

    @Column
    private Date createDate;

    @Column
    private String description;

    @Column
    private Date deadline;

    @Column
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;


    @Enumerated(value = EnumType.STRING)
    @Column
    private Type type;
    @Enumerated(value = EnumType.STRING)

    @Column
    private Status status;

}
