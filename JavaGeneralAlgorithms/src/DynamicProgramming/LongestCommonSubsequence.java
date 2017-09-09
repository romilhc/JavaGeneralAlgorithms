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
public class LongestCommonSubsequence {
    
    // Get the length of longest common subsequence recursively
    public int getLCSLengthRecursively(String s1, String s2, int m, int n) {
        
        if(m == 0 || n == 0) return 0;
        
        // If character is same take the length from diagnol element
        // else get the max of left or up
        else if(s1.charAt(m-1) == s2.charAt(n-1)) return 1 + getLCSLengthRecursively(s1,s2,m-1,n-1);
        else return Math.max(getLCSLengthRecursively(s1,s2,m,n-1),getLCSLengthRecursively(s1,s2,m-1,n));
        
    }
    
    // Get the length of longest common subsequence iteratively
    public int getLCSLengthIteratively(String s1, String s2, int m, int n) {
        
        int[][] lcs = new int[m+1][n+1];
        
        // Iterate over matrix to calculate the length till current string
        for(int i = 1; i < m+1; i++) {
            
            for(int j = 1; j < n+1; j++) {
                
                // If character is same take the length from diagnol element
                // else get the max of left or up
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }
                
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
                
            }
            
        }
        
        return lcs[m][n];
    }
    
    // Main driver method
    public static void main(String args[]) {
        
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        
        String s1 = "RomilChauhan";
        String s2 = "RolexChain";
        
        System.out.println("Length of LCS is: " + lcs.getLCSLengthRecursively(s1,s2,s1.length(),s2.length()));
        System.out.println("Length of LCS is: " + lcs.getLCSLengthIteratively(s1,s2,s1.length(),s2.length()));
        
    }
    
}
