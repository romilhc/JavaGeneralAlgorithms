/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Romil Chauhan
 * http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/ 
 */
public class ParenthesesPermutations {
    
    // Get all the valid permutations
    public void getPermutations(int n) {
        if(n > 0) getPermutations(new char[100], 0, n, 0, 0);
    }
    
    public void getPermutations(char[] arr, int pos, int n, int open, int close) {
        
        if(close == n) {
            int i;
            for(i = 0; i < arr.length ; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
        else {
            if(open > close) {
                arr[pos] = '}';
                getPermutations(arr, pos+1, n, open, close+1);
            }
            if(open < n) {
                arr[pos] = '{';
                getPermutations(arr, pos+1, n, open+1, close);
            }
        }
        
    }
    
    // Main driver method
    public static void main(String args[]) {
        
        ParenthesesPermutations pp = new ParenthesesPermutations();
        int n = 3;
        pp.getPermutations(n);
        
    }
    
}
