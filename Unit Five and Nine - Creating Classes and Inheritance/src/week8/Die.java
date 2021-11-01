package week8;

public class Die {
    //attributes define the state of an instance of the class and any particular time 
    private int numSides; //private only accessible (visible in the class)
    private int topSide;

/**
 * Has the same names as the class
 * Initializes the state of the class (attributes)
 * returns the object although we don't say return 
 */

 /**
  * If we do not EXPLICITLY our constructor JAVA will supply a NO ARGUMENT constructor that DOES NOT initialize the state of the class
  */
    public Die(){
        numSides = 6; 
        roll(); 
    }

    public Die(int numSides){
        this.numSides = numSides; 
        roll(); 
    }

    public int getTopSide(){
        return topSide;
    }

    public void roll(){
        topSide = (int)(Math.random() * numSides) + 1; 
    }

    public boolean equals(Object obj) {
        if (obj instanceof Die){
            return this.topSide == ((Die)obj).topSide; 
        }
        else{
            return false; 
        }
    }

    public String toString(){
        return "" + topSide; 
    }

}
