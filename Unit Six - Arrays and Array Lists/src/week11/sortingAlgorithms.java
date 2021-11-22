package week11;

public class sortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {80, 95, 10, 60, 35, 10, 25};

        System.out.println(arr[arr.length - 1]);

        //selectionSort(arr); 
        insertionSort(arr); 
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++){ //sort the next element 
            int temp = arr[i]; 
            int j; 
            for (j = i; j > 0 && temp < arr[j - 1]; j--){
                arr[j] = arr[j - 1]; 
            }
            arr[j] = temp; 
        }
    }

    private static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int smallestIndex = i; 
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex]){
                    smallestIndex = j; 
                }
            }
            int temp = arr[i]; 
            arr[i] = arr[smallestIndex]; 
            arr[smallestIndex] = temp; 
        }
    }
}
