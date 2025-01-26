/*
 Marla Peraza Ravelo
 CEN 3024C - Software Development 1
 January 24, 2025
 OverdueRangeException.java
 This class creates an OverdueRangeException which displays a message when it is thrown. It is used to
 make sure overdueFine stays between $0.00 and $250.00
  */
public class OverdueRangeException extends Exception{
    /*
     method: OverdueRangeException
     parameters: message(String)
     return: -
     purpose: Constructor method, creates an OverdueRangeException
    */
    public OverdueRangeException(String message){
        super(message);
    }

}
