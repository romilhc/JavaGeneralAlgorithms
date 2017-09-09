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
public class LongestIncreasingSubsequence {
    
    // Get maximum size of increasing sub sequence in an array
    public int getSequenceSize(int[] arr, int n) {
        
        int list[] = new int[n], max = 0;
        
        // Initialize list with 1
        for(int i = 0; i < n; i++) {
            list[i] = 1;
        }
        
        // Compare the j's element with ith elemnt and update the list with
        // current longest increasing subsequence
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && (list[j] + 1) > list[i]) {
                    list[i] = list[j] + 1;
                    if(list[i] > max) {
                        max = list[i];
                    }
                }
            }
        }
        
        return max;
    }
    
    // Main driver method
    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println("Length of lis is: " +  lis.getSequenceSize(arr, arr.length));
    }
    
}
