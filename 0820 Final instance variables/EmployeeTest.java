/*
 * In Fig. 8.8, class Employee's instance variables are never modified after they're initialized.  Any such instance variable should be declared final.  Modify class Employee accordingly, then compile and run the program again to demonstrate that it produces the same results.
 */

public class EmployeeTest {
   public static void main(String[] args) {
      Date birth = new Date(7, 24, 1949);
      Date hire = new Date(3, 12, 1988);
      Employee employee = new Employee("Bob", "Blue", birth, hire);

      System.out.println(employee);
   } 
} 