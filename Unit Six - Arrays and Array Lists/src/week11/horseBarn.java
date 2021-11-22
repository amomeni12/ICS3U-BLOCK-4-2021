package week11;

public class horseBarn {
   /**
    * The spaces in the barn. Each array element holds a reference to the horse
    * that is currently occupying the space. A null value indicates an empty space.
    */
   private horse[] spaces;

   public horseBarn(int numHorses) {
      spaces = new horse[numHorses];
      for (int i = 0; i < spaces.length; i++) {
         spaces[i] = new horse();
      }

      spaces[1] = null;
      spaces[2] = null;
      spaces[6] = null;
   }

   /**
    * Returns the index of the space that contains the horse with the specified
    * name. Precondition: No two horses in the barn have the same name.
    * 
    * @param name the name of the horse to find
    * @return the index of the space containing the horse with the specified name;
    *         -1 if no horse with the specified name is in the barn.
    */
   public int findHorseSpace(String name) {
      for (int i = 0; i < spaces.length; i++) {
        horse h = spaces[i];
        if (h != null && h.getName().equals(name)){
            return i;
        } 
      }
      return -1;
   }

   /**
    * Consolidates the barn by moving horses so that the horses are in adjacent
    * spaces, starting at index 0, with no empty space between any two horses.
    * Postcondition: The order of the horses is the same as before the
    * consolidation.
    */
   public void consolidate() {
      int numHorses = 0;

      for (int i = 1; i < spaces.length; i++) {
         if (spaces[i] != null)
            numHorses++;
      }

      horse[] temp = new horse[numHorses];
      int i = 0;

      for (horse horse : spaces) {
         if (horse != null) {
            temp[i] = horse;
            i++;
         }
      }

      spaces = temp;
   }
   // There may be instance variables, constructors, and methods that are not
   // shown.
}