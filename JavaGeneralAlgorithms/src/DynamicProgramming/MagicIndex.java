/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 * @author Romil Chauhan
 * http://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
 */
public class MagicIndex {
    
    // Find the magic index in a given array having non distinct numbers
    public int findMagicIndex(int arr[]) {
        return findMagicIndex(arr,0,arr.length-1);
    }
    
    public int findMagicIndex(int arr[], int low, int high) {
        
        // If low is less or equal than high
        if(low <= high) {
            
            int mid = low + (high - low)/2;
            
            if(arr[mid] == mid) return mid;
            
            // Look for magic index in left subarray
            int leftIndex = findMagicIndex(arr, low, Math.min(mid-1, arr[mid]));
            if(leftIndex >= 0) return leftIndex;
            
            // Look for magic index in right subarray
            int rightIndex = findMagicIndex(arr, Math.max(mid+1, arr[mid]), high);
            if(rightIndex >= 0) return rightIndex;
            
        }
        
        return -1;
        
    }
    
    // Main driver method
    public static void main(String args[]) {
        int arr[] = new int[]{-10, -1, 0, 3, 3, 3, 10, 11, 30, 50, 100};
        
        MagicIndex mi = new MagicIndex();
        
        System.out.println(mi.findMagicIndex(arr));
                
        
    }
    
}
