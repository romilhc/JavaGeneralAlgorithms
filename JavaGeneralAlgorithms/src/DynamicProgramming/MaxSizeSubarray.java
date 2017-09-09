/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 * @author Romil Chauhan
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaxSizeSubarray {
    
    // Get maximum subarray size with all 1's
    public int getSize(int[][] M) {
        int R = M.length, C = M[0].length, globalMax = 0;
        int tempM[][] = new int[R][C];
        
        for(int i = 0; i < R; i++) tempM[i][0] = M[i][0];
        for(int i = 0; i < C; i++) tempM[0][i] = M[0][i];
        
        for(int i = 1; i < R; i++) {
            
            for(int j = 1; j < C; j++) {
                    
                if(M[i][j] != 0) {
                    tempM[i][j] = Math.min(tempM[i-1][j-1], Math.min(tempM[i][j-1],tempM[i-1][j])) + 1;
                    if(tempM[i][j] > globalMax) {
                        globalMax = tempM[i][j];
                    }
                }
                else {
                    tempM[i][j] = 0;
                }
            }
            
        }
        
        // Global maximum size
        return globalMax;
    }
    
    // Main driver program 
    public static void main(String[] args) 
    {
        int M[][] =  {{0, 1, 1, 0, 1}, 
                      {1, 1, 0, 1, 0}, 
                      {0, 1, 1, 1, 0},
                      {1, 1, 1, 1, 0},
                      {1, 1, 1, 1, 1},
                      {0, 0, 0, 0, 0}};
           
        MaxSizeSubarray maxSize = new MaxSizeSubarray();
        System.out.println("Maximum size sub array with 1's is: " + maxSize.getSize(M));
    }
    
}
