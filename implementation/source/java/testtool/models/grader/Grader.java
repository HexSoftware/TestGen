package testtool.models.grader;
import testtool.models.testdb.Test;
import testtool.models.userdb.Student;


public class Grader {
	int permissionLevel;
	
	public Grader() {
		System.out.println("In grader.Constructor.");
	}	
	
    public void releaseTest(Test test, Grader options) {
		System.out.println("In grader.releaseTest.");
	}
	
	public void grade(Test test) {
		System.out.println("In grader.grade.");
	}
	
	public void selectStudent(Student student){
		System.out.println("In grader.selectStudent.");
	}
	
	public void saveProgress(Test test) {
		System.out.println("In grader.saveProgress.");
	}
	
	public void finishGrading(Test test) {
		System.out.println("In grader.finishGrading.");
	}
}
