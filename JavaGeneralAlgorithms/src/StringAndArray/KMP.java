/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;

import java.util.Arrays;

/**
 *
 * @author Romil Chauhan
 */
public class KMP {
    
    // Compute LPS array
    public void computeLPS(int lps[], String pat) {
        
        int i = 1, j = 0;
        lps[0] = 0;
        
        while(i < pat.length()) {
            
            if(pat.charAt(i) == pat.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            }
            else {
                if(j != 0) {
                    j = lps[j-1];
                }
                else {
                    j = 0;
                    i++;
                }
            }
            
        }
        
    }
    
    // Find substring pattern in string s1
    public void findPattern(String s1, String pat) {
        
        int lps[] = new int[pat.length()], i = 0, j = 0, N = s1.length(), M = pat.length();
        
        computeLPS(lps, pat);
        
        System.out.println(Arrays.toString(lps));
        
        while(i < N) {
            
            if(s1.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            
            if(j == M) {
                System.out.println("Pattern found at index: " + j);
            }
            else if(i < N && s1.charAt(i) != pat.charAt(j)) {
                if(j != 0) 
                    j = lps[j-1];
                else
                    i++;
            }
            
        }
        
        
        
    }
    
    // Main driver method
    public static void main(String args[]) {
        
        String s1 = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        
        KMP kmp = new KMP();
        
        kmp.findPattern(s1,pattern);
    }
}
