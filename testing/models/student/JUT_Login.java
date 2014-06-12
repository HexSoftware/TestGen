package testtool.models.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import junit.framework.TestCase;
import testtool.models.student.Login;

/**
 * @author Alvin Lam
 * @version 11may14
 * Tests the login method with various usernames
 * First Checks for existing studentDB, and if found checks existing user login.
 * Second Checks invalid user login
 * Third checks Invalid User
 * Fourth checks Valid users.
 */
public class JUT_Login extends TestCase {
	Login LoginModel = new Login();

	public JUT_Login(String name) {
		super(name);
	}
	
	public void testStudentFileCheck() {
		try {
			File file = new File("StudentDB.txt");
		    Scanner inFile = new Scanner(file);
		    assertTrue(LoginModel.login("aqlam", "password"));
		} catch (FileNotFoundException e) {
			
		}
	}
	
	public void testEmptyUser() {
		try {
			assertFalse(LoginModel.login("", "password"));
		} catch (FileNotFoundException e) {
			
		}
	}
	
	public void testInvalidUser() {
		try {
			assertFalse(LoginModel.login("Slenderman", "password"));
		} catch (FileNotFoundException e) {
			
		}
	}
	
	public void testValidUser() {
		try {
			assertTrue(LoginModel.login("aqlam", "password"));
			assertTrue(LoginModel.login("nrnord", "password"));
			assertTrue(LoginModel.login("rjalmada", "password"));
			assertTrue(LoginModel.login("gfisher", "password"));
		} catch (FileNotFoundException e) {
			
		}
	}
}
