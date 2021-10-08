package week5;

import java.util.Scanner;

public class CrossCountry {
   /**
    * main method 
    * creates scanner object
    * calls processRunner method 3 times
    */
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      processRunner(in);
      processRunner(in);
      processRunner(in);
      in.close();
   }
   /**
    * Static method 
    * No return type - void method
    * @param in (Type Scanner) Takes user input, and assigns the user's input to a variable 
    * Declares variables (firstName, lastName, mileOne, mileTwo, finish, splitTwo, splitThree)
    * calculates splitTwo and splitThree by using the subtractTime method 
    * Prints out the user's information (Name, Mile one, Split two, Split three, 5km time)
   */
   private static void processRunner(Scanner in) {
      String firstName, lastName;
      String mileOne, mileTwo, finish;
      String splitTwo, splitThree;

      System.out.print("Please enter your first name: "); 
      firstName = in.nextLine(); 
      System.out.print("Please enter your last name: "); 
      lastName = in.nextLine(); 
      System.out.print("Please enter mile one time (mm:ss.sss): "); 
      mileOne = in.nextLine(); 
      System.out.print("Please enter mile two time (mm:ss.sss): "); 
      mileTwo = in.nextLine(); 
      System.out.print("Please enter 5km time (mm:ss.sss): "); 
      finish = in.nextLine(); 
      /**
       * get the first and last name of the runner get the mileOne, mileTwo and finish
       * times for the runner
       */

      splitTwo = subtractTime(mileTwo, mileOne);
      splitThree = subtractTime(finish, mileTwo);

      /**
       * Display a summary for the runner
       */
      System.out.println("Name: " + firstName + " " + lastName); 
      System.out.println("Mile one: " + mileOne); 
      System.out.println("Split two: " + splitTwo); 
      System.out.println("Split three: " + splitThree); 
      System.out.println("5km time: " + finish); 
   }

   /**
    * @param endTime (string) the first parameter that the method takes, indicates the end time of a certain race period
    * @param startTime (string) the second parameter that the method takes, indicates the start time of a certain race period
    * declares variables endTimeInSeconds and startTimeInSeconds - both are type double 
    * Sets these variables to the number of seconds in the parameter that was given to the method (uses convertToSeconds method)
    * Subtracts the number of seconds in startTime from endTime 
    * Converts the difference in seconds to the proper time format (mm:ss.sss) and returns it (uses convertToTime method)
    * @return return type is string, returns the difference in seconds between the starTime and the endTime (as a string - sequence of characters)
    */
   private static String subtractTime(String endTime, String startTime) {
      double endTimeInSeconds = convertToSeconds(endTime);
      double startTimeInSeconds = convertToSeconds(startTime);

      double diffInSeconds = endTimeInSeconds - startTimeInSeconds;

      return convertToTime(diffInSeconds);

   }

   /**
    * @param timeInSeconds takes a double value, which is a certain amount of time in seconds and milliseconds
    * turns from seconds into format (mm:ss.sss)
    * to get the minutes it gets the timeInSeconds divides it by 60 (60 seconds in a minute) and turns it into an integer value (cutting of the decimal)
    * to get the seconds it uses the modulus operator, which gives the remainder of dividing the two values
    * it does (timeInSeconds%60) and then stores the remainder/answer into the seconds variable (type double)
    * @return returns a string, which formats the minutes and seconds into the proper format (mm:ss.sss)
    */
   private static String convertToTime(double timeInSeconds) {
      int minutes = (int)(timeInSeconds/60);
      double seconds = (timeInSeconds%60); 

      return String.format("%d:%06.3f", minutes, seconds);
   }

   /**
    * @param time takes a string value (time) 
    * uses indexOf to find where ":" is in the string
    * declares two variables untilIndex (a substring from the beginning of the string until the ":") 
    * and afterIndex (a substring from after the ":" until the end of the string )
    * declares variable front (type Integer), which turns the untilIndex variable from a string to an integer
    * multiplies front by 60 so that it turns from minutes to seconds
    * declares variable back (type Double), which will turn the afterIndex variable from a string to a double 
    * @return returns front + back, which results in the total number of seconds in the original time that was given as a parameter 
    */
   private static double convertToSeconds(String time) {  
    int index = time.indexOf(":"); 
    String untilIndex = time.substring(0, index); 
    String afterIndex = time.substring(index + 1); 
    
    int front = Integer.parseInt(untilIndex); 
    front *= 60; 
    Double back = Double.parseDouble(afterIndex); 
    
    return front + back;
   }

   //final copy 
   

}
