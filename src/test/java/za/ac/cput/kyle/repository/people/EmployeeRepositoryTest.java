package za.ac.cput.kyle.repository.people;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.kyle.domain.people.Employee;
import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.factory.info.GenderFactory;
import za.ac.cput.kyle.factory.info.RaceFactory;
import za.ac.cput.kyle.factory.people.EmployeeFactory;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryTest {

    private EmployeeRepository repository;
    private Employee employee;

    private Employee getSavedEmployee() {
        Set<Employee> savedEmployees = this.repository.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception {

        String genderID = "1";
        String genderDesc = "Male";
        String raceNum = "1";
        String raceDesc = "Arab";

        Gender g = GenderFactory.getGender(genderID,genderDesc);
        Race r = RaceFactory.getRace(raceNum,raceDesc);


        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.getEmployee("Kyle","Josias",g,r);
    }

    @Test
    public void a_create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void b_read() {
        Employee savedEmployee = getSavedEmployee();
        System.out.println("In read, employeeId = "+ savedEmployee.getEmployeeId());
        Employee read = this.repository.read(savedEmployee.getEmployeeId());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedEmployee, read);
    }

    @Test
    public void d_delete() {
        Employee savedCourse = getSavedEmployee();
        this.repository.delete(savedCourse.getEmployeeId());
        getAll();
    }

    @Test
    public void c_update() {
        String fname = "John";
        String lname = "Doe";
        String genderID = "1";
        String genderDesc = "Male";
        String raceNum = "1";
        String raceDesc = "Asian";

        Gender g = GenderFactory.getGender(genderID,genderDesc);
        Race r = RaceFactory.getRace(raceNum,raceDesc);

        Employee updated = new Employee.Builder().copy(getSavedEmployee()).firstName(fname)
                .lastName(lname)
                .gender(g)
                .race(r)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(fname, updated.getFirstName());
    }

    @Test
    public void getAll() {
        Set<Employee> all = this.repository.getAll();
        System.out.println("In get All, all = " + all);

    }

}
