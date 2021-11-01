package week7;

//Final 

//Importing scanner class
import java.util.Scanner;

public class CrazyEights {
    //declaring all the global variables
    private static final int NUM_SUITS = 4;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final int CARDS_PER_SUIT = 13;
    private static final String ACE = "A";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";

    /**
     * creates a new Scanner 
     * sets all the points to 0
     * while the game is NOT over (using gameOver method explained below) (no one has reached 100 points yet) it calls the playRound method (explained below) 
     * Seperates the string returned by playRound and adds the points to the player and the two computers 
     * if a player passes 100 points main will declare the player with the least number of points the winner 
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int playerPoints = 0; 
        int c1Points = 0; 
        int c2Points = 0; 
        
        while(!gameOver(playerPoints, c1Points, c2Points)){
            String result = playRound(in); 
            int firstDash = result.indexOf("-");
            int secondDash = result.lastIndexOf("-");
            playerPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));

            System.out.println("End of round! Your points: " + playerPoints + " " + "C1 Points: " + c1Points + " " + "C2 Points: " + c2Points); 
        }
        if(gameOver(playerPoints, c1Points, c2Points)){
            if(playerPoints < c1Points && playerPoints < c2Points){
                System.out.println("You Win The Game!"); 
            }
            else if(c1Points < playerPoints && c1Points < c2Points){
                System.out.println("C1 Wins The Game :("); 
            }
            else{
                System.out.println("C2 Wins The Game :("); 
            }
        }

    }

    /**
     * sets all the hands to a blank string and sets the top card to a blank string as it is a new round 
     * using a for loop it will add 5 cards to each players hand
     * it will then trim all the hands, which gets rid of all the extra spaces at the beggining and end of the hands
     * prints out the players hand and prints out the computer hands as X's
     * gets a random card as the top card but uses a while loop to make sure that the top card is not an 8 (follow the rules)
     * while all of the hands are not empty the round will be played 
     * calls processPlayer method (explained below) and proccessComputer method (explained below)
     * calls processComputer method twice once for both computers (has different paramaters each time)
     * @param in the methods only imput is the scanner
     * @return the scores of all three player as a String (main will seperate the string and add the points to each player)
     */
    private static String playRound(Scanner in) {
        String playerHand = "";
        
        String c1Hand = "";
    
        String c2Hand = "";

        String topCard = "";


        for(int i = 0; i < 5; i++){
            playerHand += getCard() + " ";
            c1Hand += getCard() + " ";
            c2Hand += getCard() + " ";
        }

        playerHand = playerHand.trim();
        c1Hand = c1Hand.trim();
        c2Hand = c2Hand.trim();

        System.out.println("Your Hand: " + playerHand); 
        System.out.println("C1 Hand: XX XX XX XX XX");
        System.out.println("C2 Hand: XX XX XX XX XX");

        topCard += getCard(); 
        while(topCard.indexOf("8") != -1){
            topCard += getCard(); 
        }
        System.out.println("Current top card: " + topCard);

        while(playerHand.length() > 1 && c1Hand.length() > 1 && c2Hand.length() > 1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            String temp = processPlayer(playerHand, topCard, in);
            playerHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1); 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            if(playerHand.length() == 0){
                break; 
            }
            temp = processComputer(c1Hand, topCard, playerHand, c2Hand, in, 1); 
            c1Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1); 
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            if(c1Hand.length() == 0){ 
                break; 
            }
            temp = processComputer(c2Hand, topCard, playerHand, c1Hand, in, 2);
            c2Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1); 
            System.out.println("Your hand: " + playerHand); 
        }
        
        return countScore(playerHand) + "-" + countScore(c1Hand) + "-" + countScore(c2Hand);
    }

    /**
     * counts the score of a hand
     * @param hand is the hand that has been given to the function (this function is called three times once for each hand)
     * if the player/computer has an 8 50 points is added to the score 
     * if the player/computer has an ACE 1 point is added to the score 
     * if the player/computer has a card 10 through K 10 points is added to the score 
     * if the player/computer has a card 2 through 9 but not an 8 that cards face value is added to the score 
     * @return the tallied score for that hand 
     */
    private static int countScore(String hand) {
        int score = 0;
        for(int i = 0; i < hand.length(); i++){
            String current = hand.substring(i, i + 1); 
            if(current.indexOf("8") == 0){
                score += 50;
            }
            if(current.indexOf("A") == 0){
                score += 1; 
            }
            if(current.indexOf("1") == 0 || current.indexOf("J") == 0 || current.indexOf("Q") == 0 || current.indexOf("K") == 0){
                score += 10; 
            }
            if(current.indexOf("2") == 0 || current.indexOf("3") == 0 || current.indexOf("4") == 0 || current.indexOf("5") == 0 || current.indexOf("6") == 0 || current.indexOf("7") == 0 || current.indexOf("9") == 0){
                score += Integer.parseInt(current); 
            }
        }
        return score; 
    }

    /**
     * @param playerHand the player's hand of cards 
     * @param topCard the current card that is on the top 
     * @param in the scanner 
     * checks if the player can play (canPlay method) - while the player cannot play it will draw a card for the player to a maximum of 5 cards
     * It will ask the player what card they want to play and will make sure that the player has chosen a valid card
     * It will get rid of the card they have chosen from their hand (using replaceFirst)
     * If the player chose an eight it will use the newSuit method to prompt the player to pick a new suit
     * If the player has no cards left they have won the round and return the playerHand (empty) and topCard with a dash in the middle 
     * Otherwise it will print out the current top card 
     * @return the player's hand and the top card with a dash in the middle 
     */
    private static String processPlayer(String playerHand, String topCard, Scanner in) {
        System.out.println("Your turn!");
        int numDrawn = 0;
        while(!canPlay(playerHand, topCard) && numDrawn < 5){
            numDrawn++; 
            playerHand = playerHand + " " + getCard(); 
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
            System.out.println("You must draw!"); 
            System.out.println("New hand: " + playerHand); 
            System.out.println("Current Top card: " + topCard); 
        }
        if(numDrawn == 4){
            System.out.println("You can no longer play this turn - next player's turn");
            System.out.println("Top Card Stays As: " + topCard); 
            return playerHand.trim().replace("  ", " ") + "-" + topCard.trim();  
        }
        if(canPlay(playerHand, topCard)){
            System.out.print("Which card would you like to play: ");
            String chosen = in.nextLine().toUpperCase(); 
            while(playerHand.indexOf(chosen) == -1 && (chosen.indexOf(findSuit(topCard)) == -1 || chosen.indexOf(findRank(topCard)) == -1 || chosen.indexOf("8") == -1)){
                System.out.print("You cannot play this card. Please choose again: "); 
                chosen = in.nextLine().toUpperCase(); 
            }
            playerHand = playerHand.replaceFirst(chosen, ""); 
            if(chosen.indexOf("8") >= 0){
                topCard = newSuit(in); 
            }
            else{
                topCard = chosen;
            }
            if(playerHand.length() < 2){
                System.out.println("You Win the Round!"); 
                return playerHand.trim().replace("  ", " ") + "-" + topCard.trim(); 
            }
            System.out.println("Current top card: " + topCard); 
        }       
        return playerHand.trim().replace("  ", " ") + "-" + topCard.trim();    
    }

    /**
     * finds the card's suit using a substring 
     * @param card needs card if it wants to find the suit 
     * @return the suit 
     */
    private static String findSuit(String card){
        String suit = card.substring(card.length() - 1); 
        return suit; 
    } 

    /**
     * finds the card's rank using a substring 
     * @param card needs card if it wants to find the rank 
     * @return the rank 
     */
    private static String findRank(String card){
        String suit = card.substring(0, card.length() - 1); 
        return suit; 
    }

    /**
     * checks if the player can play
     * @param hand uses it to check if the suit or rank of the top card are in the hand 
     * @param topCard uses the top card so it can compare it to the hand 
     * @return a boolean (true or false) if true the player can play if false they cannot 
     */
    private static boolean canPlay(String hand, String topCard) {
        boolean playable = hand.indexOf(findSuit(topCard)) >= 0 || hand.indexOf(findRank(topCard)) >= 0 || hand.indexOf("8") >= 0;
        return playable; 
    }

    /**
     * used when the player plays an 8 
     * prompts user for a new suit 
     * takes the first letter of the suit they have prompted, but makes sure that it is a valid suit 
     * @param in scanner
     * @return an 8 plus the chosen suit
     */
    private static String newSuit(Scanner in) {
        System.out.print("Pick a suit: ");
        String suit = in.nextLine().toUpperCase();
        while(!suit.substring(0, 1).equals("H") && !suit.substring(0, 1).equals("S") && !suit.substring(0, 1).equals("D") && !suit.substring(0, 1).equals("C")){
            System.out.print("Not a valid suit! Pick again: "); 
            suit = in.nextLine().toUpperCase();
        }
        return "8" + suit.substring(0, 1); 
    }

    /**
     * method for how the computer is going to play
     * @param currentHand the current computer hand 
     * @param topCard the current top card
     * @param playerHand the user/player's hand
     * @param compHand the other computer's hand 
     * @param in the scanner
     * @param num which computer is playing (1 or 2)
     * if the computer cannot play (using canplay method) it will draw a card to a maximum of five cards
     * if they can play (explained below)
     * if the computer has a card with the same suit as the top card and their card is not an 8 they will place it 
     * else if they have a card with the same rank as the top card and that card is not an 8 they will place it 
     * else if they have an 8 they will place it and change the suit to a suit they have in their hand 
     * if their hand is empty after placing that card they have won the game and we return their hand and the top card with a dash in between  
     * if either the user or the other computer have only 1 card left rule4Eight and rule4Rank (explained later) will be called depending on whether the current computer has an eight or not 
     * these methods try to change the suit to a suit that the player with one card doesn't have, making them draw 
     * next we loop through the current hand and replace all the ranks and suits with X's
     * @return the current computer's hand and the top card with a dash in between 
     */
    private static String processComputer(String currentHand, String topCard, String playerHand, String compHand, Scanner in, int num) {
        System.out.println("Computer " + num + "'s turn"); 

        //System.out.println("Computer " + num + " Hand: " + currentHand); //Comment out to see computer's hand while playing - was used for testing 

        int numDrawn = 0;
        currentHand += " "; 
        while(!canPlay(currentHand, topCard) && numDrawn < 5){
            currentHand += getCard() + " "; 
            numDrawn++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            } 
            System.out.println("Computer " + num + " must draw");  
        }

        //System.out.println("Computer " + num + " Hand: " + currentHand); //Comment out to see computer's hand after drawing - was used for testing 

        if(numDrawn > 4){
            System.out.println("Computer " + num + " can no longer play this turn - next player's turn");
            System.out.println("Top Card Stays As: " + topCard);
            return currentHand.trim().replace("  ", " ") + "-" + topCard.trim(); 
        }

        compHand = compHand.trim(); 
        playerHand = playerHand.trim(); 
        topCard = topCard.trim();

        if(playerHand.length() <= 3 && playerHand.length() > 0){
            String suit = findSuit(playerHand); 
            String rank = findRank(playerHand); 
            if(currentHand.indexOf("8") >= 0){
                topCard = rule4Eight(suit, num); 
            }
            else{
                topCard = rule4Rank(currentHand, rank, suit, topCard); 
            }
            if(!topCard.equals("")){
                currentHand = currentHand.trim().replaceFirst(topCard, ""); 
                currentHand = currentHand.trim();
                displayCards(currentHand);
                System.out.println("Computer " + num + " placed a " + topCard); 
                System.out.println("Current top card: " + topCard);
                return currentHand.trim().replace("  ", " ") + "-" + topCard.trim(); 
            }
        }

        else if(compHand.length() <= 3 && compHand.length() > 0){
            String suit = findSuit(compHand); 
            String rank = findRank(compHand); 
            if(currentHand.indexOf("8") >= 0){
                topCard = rule4Eight(suit, num); 
            }
            else{
                topCard = rule4Rank(currentHand, rank, suit, topCard); 
            }
            if(!topCard.equals("")){
                currentHand = currentHand.trim().replaceFirst(topCard, ""); 
                currentHand = currentHand.trim();
                displayCards(currentHand);
                System.out.println("Computer " + num + " placed a " + topCard); 
                System.out.println("Current top card: " + topCard);
                return currentHand.trim().replace("  ", " ") + "-" + topCard.trim(); 
            }
        }

        if(currentHand.indexOf(findSuit(topCard)) >= 0 && !(currentHand.substring(currentHand.indexOf(findSuit(topCard)) - 1, currentHand.indexOf(findSuit(topCard))).equals("8"))){
            int index = currentHand.indexOf(findSuit(topCard)); 
            topCard = currentHand.substring(index - 1, index + 1);
            topCard = topCard.trim();
            if(topCard.substring(0, 1).equals("0")){
                topCard = "1" + topCard; 
            }
        }
        else if(currentHand.indexOf(findRank(topCard)) >= 0 && !(currentHand.substring(currentHand.indexOf(findRank(topCard)), currentHand.indexOf(findRank(topCard)) + 1).equals("8"))){
            topCard = currentHand.substring(currentHand.indexOf(findRank(topCard)), currentHand.indexOf(findRank(topCard)) + 2);
            topCard = topCard.trim();
            if(topCard.substring(0, 1).equals("0")){
                topCard = "1" + topCard; 
            }
        }
        else if(currentHand.indexOf("8") >= 0){ //Backup add-on -> && !(currentHand.indexOf(findRank(topCard)) >= 0 && currentHand.indexOf(findSuit(topCard)) >= 0)
            topCard = currentHand.substring(currentHand.indexOf("8"), currentHand.indexOf("8") + 2);       
            if(currentHand.indexOf("H") >= 0){
                topCard = "8H";
                System.out.println("Computer " + num + " placed an 8 - changing the suit to hearts");   
            }
            else if(currentHand.indexOf("S") >= 0){
                topCard = "8S"; 
                System.out.println("Computer " + num + " placed an 8 - changing the suit to spades");  
            }
            else if(currentHand.indexOf("C") >= 0){
                topCard = "8C"; 
                System.out.println("Computer " + num + " placed an 8 - changing the suit to clubs");  
            }
            else{
                topCard = "8D"; 
                System.out.println("Computer " + num + " placed an 8 - changing the suit to diamonds");  
            }
        }

        
        if(currentHand.trim().replaceFirst(topCard, "").length() < 2){
            System.out.println("Computer " + num + " placed a " + topCard); 
            System.out.println("Computer " + num + " Wins The Round!"); 
            return currentHand.trim().replace("  ", " ") + "-" + topCard.trim(); 
        }

        currentHand = currentHand.trim().replaceFirst(topCard, ""); 
        currentHand = currentHand.trim();
        displayCards(currentHand); 
        System.out.println("Computer " + num + " placed a " + topCard); 
        System.out.println("Current top card: " + topCard);
        return currentHand.trim().replace("  ", " ") + "-" + topCard.trim(); 
    }

    private static void displayCards(String currentHand) {
        String displayedHand = "";
        for(int i = 0; i < currentHand.length(); i++){
            String current = currentHand.substring(i, i + 1); 
            if(current.equals(" ")){
                displayedHand += "  "; 
            }
            else if(current.equals("1")){
                displayedHand += ""; 
            }
            else{
                displayedHand += "X"; 
            }
        }
        System.out.println(displayedHand.trim().replace("  ", " ")); 
    }

    /**
     * using a card with the same method this method attempts to change the suit to a suit that the player with one card left does not have
     * @param currentHand the hand of the computer that is playing - used to search for ranks
     * @param rank the rank of the remaining card for the player with one card
     * @param suit the suit of the remaining card for the player with one card
     * @param topCard the current top card
     * if the rank is a 10 we use a different code since 10 is a longer string than the other faces
     * the codes do the same thing but use slightly different numbers
     * uses a for loop to loop through the current computer's hand 
     * sets the string current to the current character (in the case of a 10 the current 2 characters)
     * checks if the current char is the same as the rank and if the suit attatched to the rank is not the same as the suit of the remaining card it will change the top card to the card with the same rank but not suit 
     * otherwise it will just return the top card that was already selected in process computer
     * @return
     */
    private static String rule4Rank(String currentHand, String rank, String suit, String topCard) {
        if(rank.equals("10")){
            for(int i = 0; i < currentHand.length() - 2; i++){
                String current = (currentHand.substring(i, i + 2)); 
                if(current.equals("10")){
                    try {
                        if(!currentHand.substring(i + 2, i + 3).equals(suit)){
                            topCard = currentHand.substring(i, i + 3); 
                            return topCard; 
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        if(!currentHand.substring(i + 2).equals(suit)){
                            topCard = currentHand.substring(i); 
                            return topCard; 
                        }
                    }
                }
            }
            return ""; 
        }
        else{
            for(int i = 0; i < currentHand.length() - 1; i++){
                String current = (currentHand.substring(i, i + 1)); 
                if(current.equals(rank)){
                    try {
                        if(!currentHand.substring(i + 1, i + 2).equals(suit)){
                            topCard = currentHand.substring(i, i + 2); 
                            return topCard; 
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        if(!currentHand.substring(i + 1).equals(suit)){
                            topCard = currentHand.substring(i); 
                            return topCard; 
                        }
                    }
                }
            }
            return ""; 
        }
            
    }

    /**
     * using an eight this method changes the suit to a suit that the player with one card left does not have
     * @param suit needs suit of the hand with one card left 
     * @param num the computer which is playing right now (1 or 2)
     * uses a while loop to make sure that the suit it choses is not the suit that the player with one card has
     * makes this the new top card
     * @return the new top card
     */
    private static String rule4Eight(String suit, int num) {
        String topCard = getSuit(); 
        while(topCard.equals(suit)){
            topCard = getSuit(); 
        }
        topCard = "8" + topCard; 
        if(findSuit(topCard).equals("H")){
            System.out.println("Computer " + num + " placed an 8 - changing the suit to hearts");    
        }
        if(findSuit(topCard).equals("S")){
            System.out.println("Computer " + num + " placed an 8 - changing the suit to spades");  
        }
        if(findSuit(topCard).equals("C")){
            System.out.println("Computer " + num + " placed an 8 - changing the suit to clubs");  
        }
        if(findSuit(topCard).equals("D")){
            System.out.println("Computer " + num + " placed an 8 - changing the suit to diamonds");  
        }
        return topCard; 
    }

    /**
     * checks whether either the player's points, the computer 1's points, or the computer 2's points are greater than 100
     * @param playerPoints needs player points the see whether it is greater than 100 (same for c1Points and c2Points)
     * @param c1Points
     * @param c2Points
     * @return
     */
    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100; 
    }

    /**
     * combines the face/rank and suit together 
     * @return the card (combination of face and suit)
     */
    private static String getCard() {
        String card = getFace() + getSuit();
        return card;
    }

    /**
     * gets a random suit 
     * @return the suit it randomly chose 
     */
    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);
  
        if (suit == 0)
           return HEARTS;
        else if (suit == 1)
           return DIAMONDS;
        else if (suit == 2)
           return CLUBS;
        else
           return SPADES;
  
    }
    
    /**
     * gets a random face 
     * @return the face it randomly chose 
     */
    private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
            return suit + "";
        else if (suit == 1)
            return ACE;
        else if (suit == 11)
            return JACK;
        else if (suit == 12)
            return QUEEN;
        else
            return KING;
    }
}

  
     

