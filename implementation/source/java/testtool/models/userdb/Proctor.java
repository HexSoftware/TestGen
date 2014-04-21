package testtool.models.userdb;

/**
 * Class defines a Proctor user
 * @author Yuliya Levitskaya
 */
public class Proctor {
	static int permission = 2;
	public Proctor(){
		
	}

	public void options(){
		System.out.println("In Proctor.options.");
	}
	public void listOfTests(){
		System.out.println("In Proctor.ListOfTests.");
	}
	public void grades(){
		System.out.println("In Proctor.grades.");
	}
}
