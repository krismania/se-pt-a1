package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Controller;

public class ControllerTest
{
	public Controller controller;
	
	@Before
	public void setUp()
	{
		controller = Controller.getInstance();
	}
	
	//test validation on username -RK
	@Test
	public void testValidUserName()
	{
		assertTrue(controller.validateUserName("Richard"));
	}
	
	@Test
	public void testValidUserName2()
	{
		assertTrue(controller.validateUserName("Alex123"));
	}
	// boundary test. 14 characters
	@Test
	public void testValidUserName3()
	{
		assertTrue(controller.validateUserName("ABCDEFGH123456"));
	}
	// testing for null input
	@Test
	public void testInvalidUserName()
	{
		assertFalse(controller.validateUserName(""));
	}
	// testing for special characters
	@Test
	public void testInvalidUserName2()
	{
		assertFalse(controller.validateUserName("Abc12@"));
	}
	//testing for greater or equal to character limit 15
	@Test
	public void testInvalidUserName3()
	{
		assertFalse(controller.validateUserName("AbCdEfGh12345A1"));	
	}
	// testing for white space
	@Test
	public void testInvalidUserName4()
	{
		assertFalse(controller.validateUserName("Hello World"));	
	}
	
	// test static validator methods. -kg	
	@Test
	public void testValidName()
	{
		assertTrue(controller.validateName("John"));
	}
	
	@Test
	public void testInvalidName()
	{
		assertFalse(controller.validateName(""));
	}
	
	// test emails -RK
	
	@Test
	public void testValidEmail()
	{
		//characters mixed with -
		assertTrue(controller.validateEmail("some-email@gmail.com"));
	}
	
	@Test
	public void testValidEmail1()
	{
		// characters mixed with _
		assertTrue(controller.validateEmail("jay_n@hotmail.com"));
	}
	
	@Test
	public void testValidEmail2()
	{
		// characters mixed with .
		assertTrue(controller.validateEmail("amy.shh@hotmail.com"));
	}
	
	@Test
	public void testValidEmail3()
	{
		// characters mixed with numbers
		assertTrue(controller.validateEmail("hamroll22@hotmail.com"));
	}
	
	
	
	@Test
	public void testInvalidEmail1()
	{
		// no characters between @ and .
		assertFalse(controller.validateEmail("emailwithout@."));
	}
	
	@Test
	public void testInvalidEmail2()
	{
		// no @ symbol
		assertFalse(controller.validateEmail("myemail.website.com"));
	}
	
	@Test
	public void testInvalidEmail3()
	{
		// no . symbol
		assertFalse(controller.validateEmail("emailwithout@dots"));
	}
	
	@Test
	public void testInvalidEmail4()
	{
		// no . or @ symbols
		assertFalse(controller.validateEmail("thisisdefinitelynotanemail"));
	}
	
	// @author - RK
	@Test
	public void testInvalidEmail5()
	{
		// incorrect format. should be format characters@characters.characters
		assertFalse(controller.validateEmail("richard@kuoch@"));
	}
	
	//@author -RK
	@Test
	public void testPhoneNumber()
	{
		//null input
		assertFalse(controller.validatePhoneNumber(""));
	}
	
	@Test
	public void testPhoneNumber2()
	{
		//meets 10 numbers
		assertTrue(controller.validatePhoneNumber("0398029744"));
	}
	
	@Test
	public void testPhoneNumber3()
	{
		assertFalse(controller.validatePhoneNumber("042515267485516654951"));
	}
	
	@Test
	public void testPhoneNumber4()
	{
		assertFalse(controller.validatePhoneNumber("++61 412 123 456"));
	}
	
	@Test
	public void testPhoneNumber5()
	{
		// must be 10 numbers
		assertFalse(controller.validatePhoneNumber("1234567"));
	}
	
	@Test
	public void testPhoneNumber6()
	{
		assertTrue(controller.validatePhoneNumber("+61 400 123 456"));
	}
	
	@Test
	public void testPhoneNumber7()
	{
		assertTrue(controller.validatePhoneNumber("0418-1234"));
	}
	
	@Test
	public void testPhoneNumber8()
	{
		assertTrue(controller.validatePhoneNumber("1800.456.678"));
	}
	
	@Test
	public void testPhoneNumber9()
	{
		assertTrue(controller.validatePhoneNumber("(03) 9876 5432"));
	}
	
	// test valid passwords. -kg
	
	@Test
	public void testValidPassword1()
	{		
		String password = "SomePassword12";
		assertTrue(controller.passwordAccepted(password));
	}
	
	@Test
	public void testValidPassword3()
	{		
		String password = "1234aB";
		assertTrue(controller.passwordAccepted(password));
	}
	
	@Test
	public void testValidPassword4()
	{		
		String password = "Aaaaa9";
		assertTrue(controller.passwordAccepted(password));
	}
	
	@Test
	public void testValidPassword5()
	{		
		String password = "1111hhhhhXXXXX";
		assertTrue(controller.passwordAccepted(password));
	}
	
	
	// test passwords with invalid length. -kg
	
	@Test
	public void testInvalidLengthPassword1()
	{		
		String password = "2Shrt";
		assertFalse(controller.passwordAccepted(password));
	}
	
	@Test
	public void testInvalidLengthPassword2()
	{		
		String password = "aA1";
		assertFalse(controller.passwordAccepted(password));
	}

	@Test
	public void testInvalidLengthPassword3()
	{		
		String password = "1XYab";
		assertFalse(controller.passwordAccepted(password));
	}

	@Test
	public void testInvalidLengthPassword4()
	{		
		String password = "!@6Xg";
		assertFalse(controller.passwordAccepted(password));
	}

	@Test
	public void testInvalidLengthPassword5()
	{		
		String password = "b7*U";
		assertFalse(controller.passwordAccepted(password));
	}
	
	
	// test some specific cases. -kg
	
	@Test
	public void testPasswordNoNumbers()
	{		
		String password = "NoNumbersHere";
		assertFalse(controller.passwordAccepted(password));
	}
	
	@Test
	public void testPasswordNoUppercase()
	{		
		String password = "alllowercasepassword123";
		assertFalse(controller.passwordAccepted(password));
	}
	
	@Test
	public void testPasswordNoLowercase()
	{		
		String password = "111CAPSLOCK1SSTUCK";
		assertFalse(controller.passwordAccepted(password));
	}
	
	@Test
	public void testPasswordNoLetters()
	{		
		String password = "123456";
		assertFalse(controller.passwordAccepted(password));
	}
	
}
