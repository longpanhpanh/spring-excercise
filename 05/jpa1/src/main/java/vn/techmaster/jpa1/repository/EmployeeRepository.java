package vn.techmaster.jpa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.jpa1.model.Employee;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmailAddressAndFirstName(String emailAddress, String firstName);

    List<Employee> findDistinctByFirstNameOrLastName(String firstName, String lastName);

    List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);

    List<Employee> findByFirstNameLike(String firstName);

//    List<Employee> findAllByLastName(String LastName, Pageable page);
}
