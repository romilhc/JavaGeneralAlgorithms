/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchingAndSorting;
import java.util.Arrays;

/**
 * @author Romil Chauhan
 * Problem: http://www.geeksforgeeks.org/insertion-sort/
 */
public class InsertionSort {
    
    // Swap two elements in an array
    public void swap(int[] arr, int i, int j) {
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    
    }
    
    // Sort an array
    public void insertionSortIteratively(int[] arr) {
        
        int n = arr.length, key, j;
        
        // Iterate through unsorted arrays
        for(int i = 1; i < n; i++) {
            
            // Get the ith element at key
            key = arr[i];
            j = i-1;
            
            // Compare the key with sorted array
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            
            // Place the key at its place
            arr[j+1] = key;
            
        }
        
    }
    
    // Sort an array recursively
    public void insertionSortRecursively(int[] arr, int n) {
        
        if(n == 1) return;
        
        insertionSortRecursively(arr, n-1);
        
        int key = arr[n-1];
        int j = n-2;
        
        while(j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j--;
        }
        
        arr[j+1] = key;
        
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        int[] arr1 = {6, 1, 50, 2, 100, 6, 6101, 134, 411, 600};
        int[] arr2 = {20, 1, 6, 2, 100, 6, 6101, 134, 411, 600};
        int n = arr1.length;
        
        InsertionSort bs = new InsertionSort();
        
        bs.insertionSortIteratively(arr1);
        System.out.println("Array: " + Arrays.toString(arr1));
        
        bs.insertionSortRecursively(arr2, n);
        System.out.println("Array: " + Arrays.toString(arr2));
        
    }
}

/*
OUTPUT:
Array: [1, 2, 6, 6, 50, 100, 134, 411, 600, 6101]
*/