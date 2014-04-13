package userdb;
@author Yuliya Levitskaya

/**
 * Class defines a Proctor user
 */
public abstract class Proctor {
	static int permission = 2;

	abstract void Options(){
		System.out.println("In Proctor.options.");
	}
	abstract void ListOfTests(){
		System.out.println("In Proctor.ListOfTests.");
	}
	abstract void Grades(){
		System.out.println("In Proctor.grades.");
	}
}
