/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 *
 * @author Romil Chauhan
 */
public class LargestSumContiguousSubarray {
    
    // Get largest sum in contiguous subarray
    public int getSum(int[] arr, int n) {
        
        int curr_max = arr[0], global_max = arr[0];
        
        for(int i = 1; i < n; i++) {
            // If the array value go below 0 it updates curr_max and accordingly global_max
            curr_max = Math.max(arr[i], arr[i] + curr_max);
            global_max = Math.max(curr_max, global_max);
        }
        
        return global_max;
    }
    
    // Main driver method
    public static void main(String args[]) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        
        LargestSumContiguousSubarray lscs = new LargestSumContiguousSubarray();
        
        System.out.println("Largest sum in contiguous subarray for a given array is: " + lscs.getSum(arr,arr.length));
    }
    
}
