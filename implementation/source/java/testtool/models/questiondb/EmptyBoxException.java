package testtool.models.questiondb;

/**
 * 
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 27apr14
 *
 */

@SuppressWarnings("serial")
public class EmptyBoxException extends Exception {
	public EmptyBoxException() {super();}
	public EmptyBoxException(String message) { super(message); }
	public EmptyBoxException(String message, Throwable cause) { super(message, cause); }
	public EmptyBoxException(Throwable cause) { super(cause); }
}
