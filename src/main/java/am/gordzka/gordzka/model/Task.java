package am.gordzka.gordzka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @Column
    private int categoryId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private User user;

    @Column
    private int locationId;
    @Enumerated(value = EnumType.STRING)

    @Column
    private Type type;
    @Enumerated(value = EnumType.STRING)

    @Column
    private Status status;

}
