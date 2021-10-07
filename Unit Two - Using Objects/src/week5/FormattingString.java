package week5;

public class FormattingString {
    public static void main(String[] args) {
        // 5:7.345
        // 5:07.345

        int minutes = 5;
        double seconds = 7.5;

        //System.out.println(minutes + ":" + seconds); 

        //placeholder 
        //%d -> placeholder for integers 
        //%s -> placeholder for integers 
        //%f -> placeholder for doubles 

        System.out.printf("%d:%06.3f", minutes, seconds);
    }
}
