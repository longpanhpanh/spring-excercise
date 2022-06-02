package vn.techmaster.jpa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.jpa1.model.Employee;
import vn.techmaster.jpa1.repository.EmployeeRepository;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getEmployeesPagingAndSorting() {

        List<Employee> sortingByLastName =  employeeRepository.findAll(Sort.by("lastName"));
        List<Employee> paging = employeeRepository.findAll(PageRequest.of(0, 3)).toList();
        return paging;
    }
}
