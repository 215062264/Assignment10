package za.ac.cput.kyle.factory.people;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.kyle.domain.people.Employee;
import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.factory.info.GenderFactory;
import za.ac.cput.kyle.factory.info.RaceFactory;
import za.ac.cput.kyle.factory.people.EmployeeFactory;

public class EmployeeFactoryTest {

    @Test
    public void getEmployee() {

        String fname = "Kyle";
        String lname = "Josias";
        String genderID = "1" ;
        String genderDe = "Male" ;
        String raceNum = "1" ;
        String raceDesc = "Coloured" ;

        Gender gender = GenderFactory.getGender(genderID, genderDe);
        Race race = RaceFactory.getRace(raceNum,raceDesc);

        Employee employee = EmployeeFactory.getEmployee(fname, lname, gender, race);
        System.out.println(employee);
        Assert.assertNotNull(employee.getFirstName() + "\n" + employee.getLastName() + "\n" + employee.getGender() + "\n" + employee.getRace());

    }


}
