package week9;

public class Box extends Rectangle {

   private double height;

   public Box(double l, double w, double h) {

    //first statement of a constructor MUST be a call to the classes parent constructor 
    //(If you do not explicitly do it then Java will implicitly do it calling the no-arg parent constructor)
      super(l, w); 
      height = h;
   }

   public Box(double side) {
      super(side);
      height = side;
   }

   public double getVolume() {
      return super.getArea() * height;
   }

   public double getArea() {
      return 2 * super.getArea() + height * getLength() * 2 + height * getWidth() * 2;
   }

   public double getPerimeter(){
      return 2 * super.getPerimeter() + 4 * height; 
   }

   public boolean equals(Object obj){
      if(super.equals(obj)){
         if(obj instanceof Box){
            return height == ((Box) obj).height; 
         }
      }
      return false; 
   }

   public boolean isCube() {
      return isSquare() && height == getLength();
   }
}