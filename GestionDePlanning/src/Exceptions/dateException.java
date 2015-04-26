package Exceptions;

public class dateException extends Exception{
	public dateException(String message){
	    super(message);
	    System.out.println(message);
	}
}