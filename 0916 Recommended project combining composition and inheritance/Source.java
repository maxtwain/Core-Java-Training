/*
 * In this chapter, we created the CommissionEmployee-BasePlusCommissionEmployee inheritance hierarchy to model the relationship between two types of employees and how to calculate the earnings for each.  Another way to look at the problem is that CommissionEmlpoyees and BasePlusCommissionEmlpoyees are each Employees and that each has a different CompensationModel object.
 * A CompensationModel would provide an earnings method.  Subclasses of CompensationModel would contain the details of a particular Employee's compensation:
 * 
 * A) CommissionCompensationModel - For Employees who are paid by commission, this CompensationModel subclass would contain grossSales and commissionRate instance variables, and would define earnings to return grossSales * commissionRate.
 * 
 * B) BasePlusCommissionCompensationModel - For Employees who are paid a base salary and commission, this CompensationModel subclass would contain instance variables grossSales, commissionRate, and baseSalary, and would define earnings to return baseSalary + grossSales * commissionRate.
 * 
 * Class Employee's earnings method would simply call the composed CompensationModel's earnings method and return its result.
 * This approach is more flexible than our original hierarchy.  For example, consider and Employee who gets promoted.  With the approach described here, you can simply change that Employee's CompensationModel by assigning the composed CompensationModel reference an appropriate subclass object.  With the CommissionEmployee - BasePlusCommissionEmployee hierarchy, you'd need to change the employee's type by creating a new object of the appropriate class and moving data from the old object into the new one.
 * 
 * Implement the Employee class and CompensationModel hierarchy discussed in this exercise.  In addition to the firstName, lastName, socialSecurityNumber, and CompensationModel instance variables, class Employee should provide:
 * 
 * A) A constructor that receives three Strings and a CompensationModel to initialized the instance variables.
 * 
 * B) A set method that allows the client code to change an Employee's CompensationModel.
 * 
 * C) An earnings method that calls the CompensationModel's earnings method and returns its result.
 * 
 * When you invoke method earnings via the superclass CompensationModel reference to a subclass object (of type CommissionCompensationModel or BasePlusCommissionCompensationModel), you might expect superclass CompensationModel's earnings method to execute.  What actually happens?  The subclass object's earnings method executes.  This is called polymorphic behavior, which we explore in Chapter 10.
 * In your test application, create two Employee objects - one with a CommissionCompensationModel, and one with a BasePlusCommissionCompensationModel - then display each Employee's earnings.  Next, change each Employee's CompensationModel dynamically and redisplay each Employee's earnings.  In Chapter 10's exercises, we'll examine how to implement CompensationModel as an interface rather than a class.
 * 
 * 
 * 
 * My notes:
 * I don't really understand what it means to assign a variable to denote what kind of CompensationModel to use.  From what the exercise says, this is all stuff that I will be learning in the next chapter.  I really wish the book would stick to a linear lesson plan.
 * I wrote what I could, but I will have to learn the next chapter before I can do this kind of thing.  
 */

public class Source{
	public static void main(String[] args) {
		
	}
}