package testtool.models.questiondb;

/**
 * This is an Custom Exception class that is used when adding a question and
 * the user leaves a box empty that should be filled.
 * 
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 28apr14
 * 
 */

@SuppressWarnings("serial")
public class EmptyBoxException extends Exception {
	public EmptyBoxException() {super();}
	public EmptyBoxException(String message) { super(message); }
	public EmptyBoxException(String message, Throwable cause) { super(message, cause); }
	public EmptyBoxException(Throwable cause) { super(cause); }
}
