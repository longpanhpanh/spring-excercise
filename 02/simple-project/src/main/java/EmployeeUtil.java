import vn.techmaster.simpleproject.Employee.Employee;

public class EmployeeUtil {
    public static Employee getEmployeeBean() {
        return ApplicationContextUtils.getBean(Employee.class);
    }
}
