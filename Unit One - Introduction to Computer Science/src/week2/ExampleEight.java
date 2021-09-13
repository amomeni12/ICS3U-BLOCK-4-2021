package week2;
/**
 * Type Casting 
 */
public class ExampleEight {
    public static void main(String[] args) {
        final int NUM_MARKS = 5; 

        int markOne = 78, markTwo = 87, markThree = 64, markFour = 95, markFive = 84;

        double avg = (markOne + markTwo + markThree + markFour + markFive) / (double)NUM_MARKS;

        System.out.println("The average is: " + avg);

        double y = 3.7;
        int x = (int) y;

        double z = (double)7; //explicit cast

        //int -> double -- widening conversion
        //double -> int -- narrowing conversion 

        //cannot turn boolean into int (doesn't work)

        
    }
}
