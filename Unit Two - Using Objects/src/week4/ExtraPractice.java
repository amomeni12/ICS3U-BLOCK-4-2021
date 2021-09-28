package week4;

public class ExtraPractice {
    public static void main(String[] args) {
        
        System.out.print(Question10("Hello"));
    }

    private static String Question10(String str) {
        int ran = (int) (Math.random() * str.length()); 
        String newStr = str.substring(0, ran) + str.substring(ran + 1);
        return newStr;
    }

    private static Double Question9(int rad, int h) {
        final double pi = 3.1415; 
        double vol = rad*rad*pi; 
        vol *= h; 
        return vol; 
    }

    private static String Question8(int x1, int y1, int x2, int y2) {
        int top = y2-y1; 
        int bottom = x2-x1; 
        String slope =  "The slope is " + top + "/" + bottom;
        return slope; 
    }

    private static Integer Question7(String string, String string2) {
        return string.length() + string2.length();
    }

    private static String Question6(String str, String sub) {
        int index = str.indexOf(sub); 
        return str.substring(0, index) + str.substring(index + sub.length());
    }

    private static String Question5(String str) {
        int index = str.indexOf("e"); 
        return str.substring(0, index) + str.substring(index + 1);
    }

    private static Integer Question4(int min, int max) {
        int rand = (int) (Math.random() * (max - min + 1)) + min;
        return rand;

    }

    private static Integer Question3() {
        return (int) (Math.random() * 6) + 1;
    }


    private static Integer Question2() {
        int max = 50;
        int min = -50; 
        int rand = (int) (Math.random() * (max - min + 1)) + min; 
        return rand; 
    }

    private static Integer Question1() {
        int r = (int) (Math.random() * 100) + 1; 
        return r; 
    }

    
}
