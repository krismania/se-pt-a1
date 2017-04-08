package main;

import java.util.ArrayList;


public interface DBInterface
{
	
	//***PUBLIC API***
	/**
	 * addAccount will instantiate a user's details into the database.
	 * @param account
	 * @param password - As account does not store password. Directly pass to DB.
	 * @author James
	 */
	boolean addAccount(Account account, String password);
	
	
	/**
	 * Generates a new empty employee object with the next valid ID.
	 * @author krismania
	 */
	Employee buildEmployee();
	
	
	/**
	 * addEmployee will instantiate an employee into the database.
	 * @param employee
	 * @author James
	 */
	boolean addEmployee(Employee employee);
	
	
	/**
	 * Generates a new Shift object with the next valid ID and the supplied
	 * Employee ID.
	 * @author krismania
	 */
	Shift buildShift(int employeeID);
	
	
	/**
	 * addShift will instantiate a shift into the database, which
	 * is connected to an employee.
	 * @param shift
	 * @author James
	 */
	boolean addShift(Shift shift);
	
	
	/**
	 * Returns true if a user with the specified username exists in the database
	 * @author krismania
	 */
	boolean accountExists(String username);
	
	
	/**
	 * Returns the account specified by the given username, or null if none
	 * is found.
	 * @author krismania
	 */
	Account getAccount(String username);
	
	
	/**
	 * Returns the employee specified by the given ID, or null if none is found.
	 * @author krismania
	 */
	Employee getEmployee(int id);
	
	
	/**
	 * Returns all employees that have been registered, otherwise returns null.
	 * @author James
	 */
	ArrayList<Employee> getAllEmployees();
	
	
	Shift getShift(int shiftID);
	
	
	// TODO: return array of Shifts
	ArrayList<Shift> getShifts(int EmpID);
	
	
	ArrayList<Shift> getShiftsNotBooked();
	
	
	/**
	 * Attempt to log into an account with the provided credentials. If the login
	 * is successful, a Customer or BusinessOwner object will be returned, otherwise
	 * the return value is null.
	 * @author krismania
	 */
	Account login(String username, String password);
	
	
	
	
	
	
}
