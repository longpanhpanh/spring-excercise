package vn.techmaster.simpleproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.simpleproject.Employee.Employee;

@RestController
public class CompanyController {

    @GetMapping("/")
    public String getEmployee() {

        return "company controller employee: " + employee;
    }
}
