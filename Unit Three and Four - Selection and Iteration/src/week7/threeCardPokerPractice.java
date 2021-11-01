package week7;

import java.util.Scanner;

public class threeCardPokerPractice {
   private static final int NUM_SUITS = 4;
   private static final String HEARTS = "H";
   private static final String DIAMONDS = "D";
   private static final String SPADES = "S";
   private static final String CLUBS = "C";
   private static final int NUM_CARDS_PER_SUIT = 13;
   private static final String ACE = "A";
   private static final String JACK = "J";
   private static final String KING = "K";
   private static final String QUEEN = "Q";

   public static void main(String[] args) {
      int wallet = 500;

      Scanner in = new Scanner(System.in);
      // int bet = getWager(in, 50, 100, wallet);

      String playerHand = ""; // = "5D AC KS";
      playerHand = getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      playerHand += getCard(playerHand) + " ";
      System.out.println(playerHand);

      playerHand = discard(in, playerHand);
      System.out.println(playerHand); 

   }

   private static String discard(Scanner in, String playerHand) {
      // prompt the user for a how many cards the want to discard (0-3) - validate
      // input

      // if 0 do nothing but return playerHand
      // if 3 playerHand = ""; get 3 cards (that have not already been used)
      // if 1 or 2 -> prompt for which cards and replace them
      // (2) => 3D JC validate their input.

      System.out.print("How many cards would you like to discard: ");
      try {
        int discard = Integer.parseInt(in.nextLine());

        if(discard == 0){
            return playerHand; 
        }
        else if(discard == 1){
            System.out.print("Which card would you like to replace (1 - 3): ");
            int replacer = Integer.parseInt(in.nextLine()); 
            if(replacer == 1){
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = getCard(playerHand + temp) + " ";
               playerHand += temp.substring(3); 
               return playerHand; 
            }
            else if(replacer == 2){
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = temp.substring(0, 3);
               playerHand += getCard(playerHand + temp) + " ";
               playerHand += temp.substring(6); 
               return playerHand; 
            }
            else{
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = temp.substring(0, 6);
               playerHand += getCard(playerHand + temp) + " "; 
               return playerHand; 
            }
         }
         else if(discard == 2){
            System.out.print("Which card would you like to replace 1st (1-3): ");
            int replacer = Integer.parseInt(in.nextLine()); 
            if(replacer == 1){
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = getCard(playerHand + temp) + " ";
               playerHand += temp.substring(3); 
            }
            else if(replacer == 2){
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = temp.substring(0, 3);
               playerHand += getCard(playerHand + temp) + " ";
               playerHand += temp.substring(6);  
            }
            else{
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = temp.substring(0, 6);
               playerHand += getCard(playerHand + temp) + " "; 
            }
            System.out.print("Which card would you like to replace Next (1-3): ");
            int replacer2 = Integer.parseInt(in.nextLine()); 
            while(replacer == replacer2){
               System.out.print("Can't change this card again! Choose another card: ");
               replacer2 = Integer.parseInt(in.nextLine()); 
            }
            
            if(replacer2 == 1){
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = getCard(playerHand + temp) + " ";
               playerHand += temp.substring(3); 
               return playerHand; 
            }
            else if(replacer2 == 2){
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = temp.substring(0, 3);
               playerHand += getCard(playerHand + temp) + " ";
               playerHand += temp.substring(6); 
               return playerHand; 
            }
            else{
               String temp = playerHand; 
               playerHand = ""; 
               playerHand = temp.substring(0, 6);
               playerHand += getCard(playerHand + temp) + " "; 
               return playerHand; 
            }
   
         }
         else if(discard == 3){
            String temp = playerHand;
            playerHand = getCard(playerHand + temp) + " ";
            playerHand += getCard(playerHand + temp) + " ";
            playerHand += getCard(playerHand + temp) + " ";
        }

       
     } catch (Exception ex) {
        System.out.println("Invalid Discard");
     }
     return playerHand; 
   }

   private static String getCard(String usedCards) {
      String card = getFace() + getSuit();

      while (usedCards.indexOf(card) >= 0) {
         card = getFace() + getSuit();
      }
      return card;
   }

   private static String getSuit() {
      int suit = (int) (Math.random() * NUM_SUITS);

      if (suit == 0)
         return HEARTS;
      else if (suit == 1)
         return DIAMONDS;
      else if (suit == 2)
         return SPADES;
      else
         return CLUBS;
   }

   private static String getFace() {
      int face = (int) (Math.random() * NUM_CARDS_PER_SUIT) + 1;

      if (face >= 2 && face <= 10)
         return "" + face;
      else if (face == 1)
         return ACE;
      else if (face == 11)
         return JACK;
      else if (face == 12)
         return QUEEN;
      else
         return KING;

   }

   private static int getWager(Scanner in, int minBet, int maxBet, int wallet) {
      boolean validInput = false;
      int bet = 0;

      while (!validInput) {
         System.out.print("Please enter a bet [$" + minBet + " - $" + maxBet + "]: ");
         try {
            bet = Integer.parseInt(in.nextLine());

            if (bet > wallet)
               System.out.println("You only have $" + wallet);
            else if (bet > maxBet || bet < minBet)
               System.out.println("Your bet must be between [$" + minBet + " - $" + maxBet + "]");
            else
               validInput = true;
         } catch (Exception ex) {
            System.out.println("Invalid Input!");
         }
      }

      return bet;
   }
}