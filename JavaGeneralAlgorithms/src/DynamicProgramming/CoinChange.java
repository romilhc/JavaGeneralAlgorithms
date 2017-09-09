/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Arrays;

/**
 *
 * @author Romil Chauhan
 */
public class CoinChange {
    
    // Count the total number of ways to form sum n recursively
    public int countTotalWaysRecursively(int arr[], int m, int n) {
        
        if(n == 0) return 1;
        if(n < 0 || (m <= 0 && n >= 1)) return 0;
        
        // Case 1: consider current coin in sum,  2: exclude current coin 
        return countTotalWaysRecursively(arr, m-1, n) + countTotalWaysRecursively(arr, m, n - arr[m-1]);
        
    }
    
    // Count the total number of ways to form sum n iteratively
    public int countTotalWaysIteratively(int arr[], int m, int n) {
        
        // Counter array
        int counter[] = new int[n+1];
        
        counter[0] = 1;
        for(int i = 1; i < n+1; i++) counter[i] = 0;
        
        // Compute total number of ways taking each coin at 0..sum values at a time
        for(int i = 0; i < m; i++) {
            for(int j = arr[i]; j <= n; j++) {
                counter[j] += counter[j-arr[i]];
            }
        }
        
        return counter[n];
    }
    
    // Main driver method
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3}, m = arr.length, n = 4;
        CoinChange cc = new CoinChange();
        System.out.println(cc.countTotalWaysRecursively(arr, m, n));
        System.out.println(cc.countTotalWaysIteratively(arr, m, n));
    }
    
}
