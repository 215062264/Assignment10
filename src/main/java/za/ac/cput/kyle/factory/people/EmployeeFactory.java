package za.ac.cput.kyle.factory.people;

import za.ac.cput.kyle.domain.people.Employee;
import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.domain.info.Race;
import za.ac.cput.kyle.util.Misc;

public class EmployeeFactory {

    public static Employee getEmployee(String firstName, String lastName, Gender gender, Race race) {
        return new Employee.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .race(race)
                .employeeId(Misc.generateId())
                .build();
    }

}
