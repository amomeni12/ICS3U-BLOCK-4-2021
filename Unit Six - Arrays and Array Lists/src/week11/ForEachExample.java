package week11;

import java.util.concurrent.ForkJoinPool;

public class ForEachExample {
    public static void main(String[] args) {
        int[] arr = {80, 95, 10, 60, 35, 10, 25};

        for(int el : arr){
            //System.out.println(el);
        }

        String[] names = {"Brad", "Chad", "Ave", "Kayhan", "MathMan", "Trigarosa", "UnitCircle"}; 
        
        int numVowels = 0; 
        String vowels = "aeiourAEIOU"; 
        for(String name : names){
            for (int i = 0; i < name.length(); i++) {
                String letter = name.substring(i, i+1);
                if(vowels.indexOf(letter) >= 0){
                    numVowels++; 
                }
            }
        }
        //System.out.println(numVowels);
    }
}
