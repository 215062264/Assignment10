package za.ac.cput.kyle.repository.people;

import za.ac.cput.kyle.domain.people.Employee;
import za.ac.cput.kyle.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee,String> {

    Set<Employee> getAll();
}
