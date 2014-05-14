package testtool.models.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import testtool.models.userdb.Student;

public class Login {

		/**
	    * Checks username and password to login student
	    * @param username - user's calpoly username
	    * @param password - user's password
	   */
	   /*@
	    requires
	    //
	    // The username must exist in the user database and cannot be null..
	    //
	    (\exists String username; userdb.calpolyID.contains(username))
	
	    ensures
	    //
	    // A boolean is in the output, true if the inputted password matches the password of the user
	    // false otherwise. Sets Student user to equal username
	    //
	    result password.equals(user.password)
	  @*/
	   public boolean login (String username, String password) {
	   	if (username.equals("")) {
	   		return false;
	   	}
	   	
	   	MyCourses courseClass = new MyCourses();
	   	Student curStudent = new Student();
		   
			try {
				File file = new File("StudentDB.txt");
			   Scanner inFile = new Scanner(file);
				
				while (inFile.hasNextLine()) {
				   curStudent.setStudentUsername(inFile.nextLine());
				   
				   if (curStudent.getStudentUsername().equals(username)) {
				   	System.out.println("User exists");
				   	curStudent.setStudentName(inFile.nextLine());
				   	inFile.next();
				   	int i = inFile.nextInt();
				   	System.out.println(i);
				   	for (inFile.nextLine(); i > 0; i--) {
				   		curStudent.addCourse(inFile.nextLine());
				   	}
				   	inFile.close();
				   	
				   	courseClass.viewCourses(curStudent);
				   	return true;
				   }
				   else {
				   	System.out.println(inFile.nextLine());
				   	System.out.println(inFile.next());
				   	for (int i = inFile.nextInt(); i >= 0; i--) {
				   		System.out.println(inFile.nextLine());
				   	}
				   	System.out.println(inFile.nextLine());
				   }
			   }
				
				inFile.close();
				return false;
			} catch (FileNotFoundException e) {
				System.out.println("StudentDB not found");
			}
	      return false;
	   }
}