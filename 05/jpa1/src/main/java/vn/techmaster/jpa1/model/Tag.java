package vn.techmaster.jpa1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="tag")
@Table(name="tag")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
}
