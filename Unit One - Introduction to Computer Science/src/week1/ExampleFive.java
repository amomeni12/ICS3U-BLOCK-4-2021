package week1;

public class ExampleFive {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87;

        double avg = (markOne + markTwo + markThree)/3.0;

        System.out.println("The Average Is: " + avg);

        System.out.println(4/5); //0
        System.out.println(4.0 / 5); //0.8
        System.out.println(5 / 4); //1
        System.out.println(5/4.0); //1.25

        // Modulus operator
        System.out.print(13 % 3); //13 mod 3 //1
    }
}
