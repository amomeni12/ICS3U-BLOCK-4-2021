package week5;

import java.util.Scanner;

public class CrossCountry {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      processRunner(in);
      processRunner(in);
      processRunner(in);
      in.close();
   }

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
    * 
    * @param endTime
    * @param startTime
    * @return
    */
   private static String subtractTime(String endTime, String startTime) {
      double endTimeInSeconds = convertToSeconds(endTime);
      double startTimeInSeconds = convertToSeconds(startTime);

      double diffInSeconds = endTimeInSeconds - startTimeInSeconds;

      return convertToTime(diffInSeconds);

   }

   private static String convertToTime(double timeInSeconds) {
      int minutes = (int)(timeInSeconds/60);
      double seconds = (timeInSeconds%60); 

      return String.format("%d:%06.3f", minutes, seconds);
   }

   private static double convertToSeconds(String time) {  
    int index = time.indexOf(":"); 
    String untilIndex = time.substring(0, index); 
    String afterIndex = time.substring(index + 1); 
    
    int front = Integer.parseInt(untilIndex); 
    front *= 60; 
    Double back = Double.parseDouble(afterIndex); 
    
    return front + back;
   }
   

}
