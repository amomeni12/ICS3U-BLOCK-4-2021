package week2;

/**
 * final modifier -- it makes it so that we cannot modify the value of the variable once it's set
 */

public class ExampleSeven {
    public static void main(String[] args) {
        final int x = 7;
        //x = 9; cannot reassing a value to a final variable 

        final int y; 
        y = 8; 
        //y++; //cannot modify the 'final' variable if it is constant

        final int NUM_STUDENTS = 18;
        //constant for (FINAL VARIABLE) 
        //Use _ for space (JAVA will not recognize/allow ' ')
    }
}
