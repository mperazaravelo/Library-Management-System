/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  January 24, 2025
  InvalidIdException.java
  This class creates an InvalidIdException which displays a message when it is thrown. It is used to
  make sure the id entered has exactly 7 digits
  */
public class InvalidIdException extends Exception{
    /*
     method: InvalidIdException
     parameters: message(String)
     return: -
     purpose: Constructor method, creates an InvalidIdException
    */
public InvalidIdException(String message){
    super(message);
    }
}
