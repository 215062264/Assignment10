package za.ac.cput.kyle.service.people;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.kyle.domain.people.Employee;
import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.factory.people.EmployeeFactory;
import za.ac.cput.kyle.factory.info.GenderFactory;
import za.ac.cput.kyle.factory.info.RaceFactory;
import za.ac.cput.kyle.repository.people.EmployeeRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {

    private EmployeeRepositoryImpl repository;
    private Employee employee;

    private Employee getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {

        String genderID = "1";
        String genderDesc = "Male";
        String raceNum = "1";
        String raceDesc = "Arab";

        Gender g = GenderFactory.getGender(genderID,genderDesc);
        Race r = RaceFactory.getRace(raceNum,raceDesc);

        this.repository = (EmployeeRepositoryImpl) EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.getEmployee("Carly","Josias",g,r);
    }

    @Test
    public void a_create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void c_update() {

        String fname = "Peter";
        String lname = "Parker";
        String genderID = "1";
        String genderDesc = "Male";
        String raceNum = "1";
        String raceDesc = "Arab";

        Gender g = GenderFactory.getGender(genderID,genderDesc);
        Race r = RaceFactory.getRace(raceNum,raceDesc);


        Employee updated = new Employee.Builder().copy(getSaved()).firstName(fname)
                .lastName(lname)
                .gender(g)
                .race(r)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(fname, updated.getFirstName());
    }

    @Test
    public void d_delete() {
        Employee saved = getSaved();
        this.repository.delete(saved.getEmployeeId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Employee saved = getSaved();
        Employee read = this.repository.read(saved.getEmployeeId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Employee> employees = this.repository.getAll();
        System.out.println("In get all, all = " + employees);
    }

}
