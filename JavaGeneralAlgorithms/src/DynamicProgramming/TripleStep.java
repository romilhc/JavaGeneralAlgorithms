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
public class TripleStep {
    
    // Get total number of ways to climb n steps by skipping 1, 2 or 3 steps in all recursively
    public int getTotalWaysRecursively(int n) {
        
        // 0 ways to climb less than 0 steps
        if(n < 0) return 0;
        
        // 1 way to climb no step
        if(n == 0) return 1;
        
        // Total ways to climb n steps is sum of total ways to climbing n-1, n-2 and n-3 steps
        return getTotalWaysRecursively(n-1) + getTotalWaysRecursively(n-2) + getTotalWaysRecursively(n-3);
    }
    
    // Get total number of ways to climb n steps by skipping 1, 2 or 3 steps in all iteratively
    public int getTotalWaysIteratively(int n) {
        
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        return getTotalWaysIterativelyHelper(n, memo);
        
    }
    
    // Helper function for iterative implementation
    public int getTotalWaysIterativelyHelper(int n, int[] memo) {
        
        // 0 ways to climb less than 0 steps
        if(n < 0) return 0;
        
        // 1 way to climb no step
        else if(n == 0) return 1;
        
        else if(memo[n] > -1) return memo[n];
        
        else {
            memo[n] = getTotalWaysIterativelyHelper(n-1, memo) + getTotalWaysIterativelyHelper(n-2, memo) + getTotalWaysIterativelyHelper(n-3, memo);
        }
        
        return memo[n];
    }
    
    // Main dirver method
    public static void main(String args[]) {
        
        TripleStep ts = new TripleStep();
        int n = 5;
        System.out.println("Total ways to climb " + n + " steps by skipping 1, 2 or 3 step is: " + ts.getTotalWaysRecursively(n));
        System.out.println("Total ways to climb " + n + " steps by skipping 1, 2 or 3 step is: " + ts.getTotalWaysIteratively(n));
        
    }
    
}
