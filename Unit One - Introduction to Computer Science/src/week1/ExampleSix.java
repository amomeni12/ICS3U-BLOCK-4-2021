package week1;

public class ExampleSix {
    public static void main(String[] args) {
        int x = 1;
        int y = 3;
        double z = 1;
    
        x = x + 1;// add 1 to x and then assign that value to x
        y = y - 1;
        x = x + 3;
    
        x += 1; //x = x + 1;
        y -= 1; //y = y - 1;
        x += 3; //x = x + 3;
    
        y = y / 2; //y /= 2;
        z = z * 2; //z *= 2;
    
        x++; // increase by 1
        y--; // decrease by 1

        System.out.println(13 % 3); 
        y = y % 2; 

        int s = 5; 
        s++; 
        ++s; 
        s--; 
        --s; 

        int g = 3; 
        int f = 3; 

        int test_1 = 2 * g++; 
        int test_2 = 2 * ++f; 
    }
}
