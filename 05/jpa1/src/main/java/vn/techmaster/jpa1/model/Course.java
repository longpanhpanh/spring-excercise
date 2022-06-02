package vn.techmaster.jpa1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name="course")
@Table(name="course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> scores;
}