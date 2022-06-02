package vn.techmaster.jpa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.jpa1.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
