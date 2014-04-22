package testtool.models.testdb;
import java.util.Collection;

import testtool.models.courses.Course;
import testtool.models.questiondb.Question;
import testtool.models.userdb.TestSettings;

public class Test {
	boolean published;
	boolean opened;
	boolean graded;
	Collection<Question> questions;
	String testTitle;
	String author;
	String lastUsed;
	int totalQuestions;
	int totalPoints;
	int totalTime;
	int avgDifficulty;
	TestSettings ts;
	Course course;
	
	public Test(boolean p, boolean o, boolean g, 
			String lU, int points, int time, int diff, TestSettings setting,Course c){
		this.published = p;
		this.opened =o;
		this.graded = g;
		this.lastUsed = lU;
		this.totalPoints = points; 
		this.totalTime = time;
		this.avgDifficulty = diff;
		this.ts = setting;
		this.course = c;
	}
	public boolean getPublished(){
		return this.published;
	}
	public boolean getOpen(){
		return this.opened;
	}
	public boolean getGraded(){
		return this.graded;
	}
	public String getlastUsed(){
		return this.lastUsed;
	}
	public int getPoints(){
		return this.totalPoints;
	}
	public int getTime(){
		return this.totalTime;
	}
	public int getDiff(){
		return this.avgDifficulty;
	}
	public Course getCourse(){
		return this.course;
	}
	public TestSettings getSetting(){
		return ts;
	}
	public void setSettings(TestSettings t){
		this.ts = t;
	}
	public void setPublished(boolean p){
		this.published = p;
	}
	public void setOpen(boolean o){
		this.opened = o;
	}
	public void setGraded(boolean g){
		this.graded = g;
	}
	public void setlastUsed(String date){
		this.lastUsed = date;
	}
	public void setPoints(int p){
		this.totalPoints = p;
	}
	public void getTime( int t){
		this.totalTime = t;
	}
	public void setDiff(int diff){
		 this.avgDifficulty = diff;
	}
	public void setCourse(Course c){
		 this.course = c;
	}
}
