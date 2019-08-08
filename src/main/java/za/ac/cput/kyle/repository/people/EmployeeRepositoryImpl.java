package za.ac.cput.kyle.repository.people;

import za.ac.cput.kyle.domain.people.Employee;

import java.util.*;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    private static EmployeeRepositoryImpl repository = null;
    private Map<String, Employee> employee;

    private EmployeeRepositoryImpl() {
        this.employee = new HashMap<>();
    }

    public static EmployeeRepository getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee create(Employee employee){
        this.employee.put(employee.getEmployeeId(),employee);
        return employee;
    }

    public Employee read(String employeeId){
        return this.employee.get(employeeId);
    }

    public Employee update(Employee employee) {
        this.employee.replace(employee.getEmployeeId(),employee);
        return this.employee.get(employee.getEmployeeId());
    }

    public void delete(String employeeId) {
        this.employee.remove(employeeId);
    }

    public Set<Employee> getAll(){
        Collection<Employee> employee = this.employee.values();
        Set<Employee> set = new HashSet<>();
        set.addAll(employee);
        return set;
    }

}
