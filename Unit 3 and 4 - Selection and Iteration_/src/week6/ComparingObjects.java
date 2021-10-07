package week6; 

public class ComparingObjects {
    public static void main(String[] args) {
        //when we compare Strings we NEVER EVER EVER use == in Java

        //if we dont instantiate an object then the variable stores NULL
        //otherwise the variable stores the address of the actual object 

        //Why? 
        //When you use == you are comparing what is stored in the variable 
        //Two objects can have the same attributes but they're addresses will be different
        //== compares addresses when it comes to objects 

        String s1 = new String("hello"); 
        Strign s2 = new String("hello"); 

        System.out.println(s1.equals(s2)); 

        String str1 = "ABCD"; 
        String str2 = "BCD"; 

        //System.out.println(str1.compareTo(str2)); 
        System.out.println("A".compareTo("a")); 

    }
}