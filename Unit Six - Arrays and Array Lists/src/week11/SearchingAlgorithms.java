package week11;

import java.util.Arrays;

public class SearchingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {80, 95, 10, 60, 35, 10, 25};

        int index = LinearSearch(arr, 35);  
        index = LinearSearch(arr, 36);

        Arrays.sort(arr); 
        index = BinarySearch(arr, 35); //HAS TO BE SORTED FIRST 
        
        int[] nums = new int[1000000000]; 
        for(int i = 0; i < nums.length; i ++){
            nums[i] = (int)(Math.random() * 1000); 
        }
        Arrays.sort(nums); 
        BinarySearch(nums, -1); 
    }

    private static int BinarySearch(int[] arr, int num) { //has to be sorted 
        int lower = 0; 
        int upper = arr.length - 1; 

        int comparisons = 0; 
        while(upper >= lower){
            comparisons++; 
            int mid = (upper + lower)/2; 
            if(arr[mid] == num){
                return mid;
            }
            else if(arr[mid] > num){
                upper = mid - 1; 
            }
            else{
                lower = mid + 1; 
            }
        }
        System.out.println(comparisons);
        return -1; 
    }

    private static int LinearSearch(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] == i){
                return j; 
            }
        }
        return -1; 
    }
}
