package week8;

public class DieGame {
   public static void main(String[] args) {
        Die die1 = new Die(); //Special method - purpose to create an instance of the die and return it 
        Die die2 = new Die(); 

        int countPairs = 0; 

        for(int i = 0; i < 100; i++){
            die1.roll(); 
            die2.roll(); 

            System.out.println(die1 + " " + die2);

            if(die1.equals(die2)){
                countPairs++; 
            }
            System.out.print("Pairs: " + countPairs);
        }
   }

}
