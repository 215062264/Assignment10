package za.ac.cput.kyle.domain.people;

import za.ac.cput.kyle.domain.info.Gender;
import za.ac.cput.kyle.domain.info.Race;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private Gender gender;
    private Race race;
    private String employeeId;

    public Employee(){}

    private Employee(Employee.Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.race = builder.race;
        this.employeeId = builder.employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private Gender gender;
        private Race race;
        private String employeeId;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder gender(Gender gender){
            this.gender = gender;
            return this;
        }

        public Builder race(Race race){
            this.race = race;
            return this;
        }

        public Builder copy(Employee employee){
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.gender = employee.gender;
            this.race = employee.race;
            this.employeeId = employee.employeeId;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", race=" + race +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }


}
