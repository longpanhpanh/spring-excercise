package vn.techmaster.jpa1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="product")
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private Set<Tag> tags;
}
