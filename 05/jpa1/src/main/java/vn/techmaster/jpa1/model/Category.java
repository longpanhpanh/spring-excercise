package vn.techmaster.jpa1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="category")
@Table(name="category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "category", orphanRemoval = false)
    private Set<Product> products;
}
