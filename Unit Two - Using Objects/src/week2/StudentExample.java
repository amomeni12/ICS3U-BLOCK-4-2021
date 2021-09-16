package week2;

public class StudentExample {
    public static void main(String[] args) {
        Student fred = new Student("Fred","654321", 10); 
        Student max = new Student("Max", "123456", 10);
        Student muriel = fred; 
        muriel.increaseGrade();
        fred = null; 
        //fred.displayName(); //java throws a NullPointerException 

        max.addTest(87);
        max.addTest(94); 
        max.addTest(98);
        max.addTest(67);
        max.displayAverage();
    }
}
