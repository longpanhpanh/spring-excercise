//package vn.techmaster.jpa1.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import vn.techmaster.jpa1.model.Employee;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class EmployeRepositoryImpl implements EmployeRepositoryCustom {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Override
//    public Map<String, List<Employee>> groupEmployeeByFirstname() {
//        return employeeRepository
//                .findAll()
//                .stream()
//                .collect(Collectors.groupingBy(Employee::getFirstName, HashMap::new, Collectors.toList()));
//    }
//}
