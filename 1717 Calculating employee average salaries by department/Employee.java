public class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    private String department;

    Employee(String firstName, String lastName, double salary, String department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    String getFirstName(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }

    double getSalary(){
        return salary;
    }

    String getDepartment(){
        return department;
    }

    String getName(){
        return String.format("%s %s", getFirstName(), getLastName());
    }

    @Override
    public String toString(){
        return String.format("%-8s %-8s %8.2f   %s", getFirstName(), getLastName(), getSalary(), getDepartment());
    }
}
