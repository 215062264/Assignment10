package za.ac.cput.kyle.service.people;

import za.ac.cput.kyle.domain.people.Employee;
import za.ac.cput.kyle.service.IService;

import java.util.Set;

public interface EmployeeService  extends IService<Employee,String> {

    Set<Employee> getAll();
}
