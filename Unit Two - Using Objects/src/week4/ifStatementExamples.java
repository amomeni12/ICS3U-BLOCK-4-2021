package week4;

public class ifStatementExamples {
    public static void main(String[] args) {
        exampleOne();
        String letterGrade = getLetterGrade(78);
        exampleThree();
    }

    private static void exampleThree() {
        /**
         * >
         * <
         * >=
         * <=
         * !=
         * ||
         * &&
         * ! Not 
         */
    }

    private static String getLetterGrade(int mark) {
        String let = ""; 
        if(mark >= 90){
            let = "A+";
        }
        else if(mark >= 80){
            let = "A";
        }
        else if(mark >= 70){
            let = "B";
        }
        else if(mark >= 60){
            let = "C";
        }
        else if(mark >= 50){
            let = "D";
        }
        else{
            let = "F";
        }
        return let; 
        
    }

    private static void exampleOne() {
        int x = 8; 
        
        if (x%2==0){
            System.out.println(x + " is Even.");
        }
        else{
            System.out.println(x + " is Odd.");
        }

    }
    
}
