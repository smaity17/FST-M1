package activities;

import java.util.Arrays;

class Activity4 {
   
    public static void main(String args[]) {
        int[] arr = { 7, 5, 2, 1, 4 };
        System.out.println("Array before sorting: ");
        System.out.println(Arrays.toString(arr));
        int i;        
        for (i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && key < arr[j]) {
            	arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = key;
        }
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
    }
}
