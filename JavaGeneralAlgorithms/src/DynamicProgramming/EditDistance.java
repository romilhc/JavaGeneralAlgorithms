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
public class EditDistance {
    
    // Get total edits to convert one string to another recursively
    public int getTotalEditsRecursively(String s1, String s2, int m , int n) {
        
        // If length of first string is 0, return length of second string
        if(m == 0) return n;

        // If length of second string is 0, return length of first string
        if(n == 0) return m;
        
        if(s1.charAt(m-1) == s2.charAt(n-1)) return getTotalEditsRecursively(s1, s2, m-1, n-1);
        
        return 1 + Math.min(getTotalEditsRecursively(s1, s2,m-1,n-1), Math.min(getTotalEditsRecursively(s1, s2, m-1, n), getTotalEditsRecursively(s1, s2, m, n-1)));
        
    }

    // Get total edits to convert one string to another iteratively
    public int getTotalEditsIteratively(String s1, String s2, int m, int n) {
        
        int countEdits[][] = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++) {
            
            for(int j = 0; j <= n; j++) {
                
                // If length of first string is 0, return length of second string
                if(i == 0) countEdits[i][j] = j;
                
                // If length of second string is 0, return length of first string
                else if(j == 0) countEdits[i][j] = i;
                
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    countEdits[i][j] = countEdits[i-1][j-1];
                
                else
                    countEdits[i][j] = 1 + Math.min(countEdits[i-1][j-1], Math.min(countEdits[i-1][j], countEdits[i][j-1]));
                
            }
            
        }
        
        return countEdits[m][n];
    }
    
    // Main driver method
    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";
        EditDistance ed = new EditDistance();
        System.out.println( ed.getTotalEditsRecursively( str1 , str2 , str1.length(), str2.length()) );
        System.out.println( ed.getTotalEditsIteratively( str1 , str2 , str1.length(), str2.length()) );
    }
    
}
