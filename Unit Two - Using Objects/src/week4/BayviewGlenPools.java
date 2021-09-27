package week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 20; 
        final int width = 8; 
        final int shallowLength = 5; 
        final int transition = 7; 
        final int shallowHeight = 3; 
        final int deepHeight = 8; 
        final int linerCost = 2; 

        double volume = getVolume(length, width, shallowHeight, shallowLength, transition, deepHeight);
        double surfaceArea = getSurfaceArea(length, width, shallowHeight, shallowLength, transition, deepHeight); 
        
        System.out.println(volume);
        System.out.println(surfaceArea);
        
    }

    private static double getSurfaceArea(int length, int width, int shallowHeight, int shallowLength, int transition,
            int deepHeight) {
                double tLength = Math.sqrt(Math.pow(transition, 2) - Math.pow(deepHeight - shallowHeight, 2));
                double deepLength = length - shallowLength - tLength; 


        return 0; 
    }

    private static double getVolume(int length, int width, int shallowHeight, int shallowLength, int transition,
            int deepHeight) {
                double tLength = Math.sqrt(Math.pow(transition, 2) - Math.pow(deepHeight - shallowHeight, 2));
                double deepLength = length - tLength - shallowLength; 
                double sVolume = shallowLength * shallowHeight * width;
                double dVolume = deepLength * deepHeight * width;
                double tVolume = ((deepHeight - shallowHeight) * tLength / 2)*width;
                tVolume += shallowHeight * tLength * width; 
        return sVolume + dVolume + tVolume;
    }

    
}
