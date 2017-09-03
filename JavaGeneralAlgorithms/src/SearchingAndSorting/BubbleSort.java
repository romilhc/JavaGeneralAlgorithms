/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchingAndSorting;
import java.util.Arrays;

/**
 * @author Romil Chauhan
 * Problem: http://www.geeksforgeeks.org/bubble-sort/
 */
public class BubbleSort {
    
    // Swap two elements in an array
    public void swap(int[] arr, int i, int j) {
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    
    }
    
    // Sort an array
    public void sort(int[] arr) {
        
        int n = arr.length;
        boolean swap = false;
        
        // Iterate through array comparing with next element and
        // cutting off the length at every iteration.
        for(int i = 0; i < (n-1); i++) {
            
            // Initialize swapping variable
            swap = false;
            
            
            for(int j = 0; j < (n-i-1); j++) {
                
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    swap = true;
                }
                
            }
            
            // Check if the swapping has stopped
            if(!swap) break;
        }
        
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        int[] arr = {6, 1, 50, 2, 100, 6, 6101, 134, 411, 600};
        int n = arr.length;
        
        BubbleSort bs = new BubbleSort();
        
        bs.sort(arr);
        
        System.out.println("Array: " + Arrays.toString(arr));
        
    }
}

/*
OUTPUT:
Array: [1, 2, 6, 6, 50, 100, 134, 411, 600, 6101]
*/