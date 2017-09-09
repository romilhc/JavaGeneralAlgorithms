/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Arrays;

/**
 * @author Romil Chauhan
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinCost {
    
    // Get minimum cost to reach right bottom of the matrix recursively
    public int getMinCostRecursively(int[][] cost, int m, int n) {
        
        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        else if(m == 0 && n == 0) return cost[m][n];
        else return cost[m][n] + Math.min(getMinCostRecursively(cost, m-1, n-1), Math.min(getMinCostRecursively(cost, m-1, n),getMinCostRecursively(cost, m, n-1)));
        
    }
    
    // Get minimum cost to reach right bottom of the matrix iteratively
    public int getMinCostIteratively(int[][] cost, int m, int n) {
        
        int[][] totalCost = new int[m][n];
        
        totalCost[0][0] = 0;
        
        for(int i = 1; i < m; i++) {
            totalCost[i][0] = totalCost[i-1][0] + cost[i][0];
        }
        
        for(int i = 1; i < n; i++) {
            totalCost[0][i] = totalCost[0][i-1] + cost[0][i];
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                totalCost[i][j] = Math.min(totalCost[i-1][j-1], Math.min(totalCost[i-1][j], totalCost[i][j-1])) + cost[i][j];
            }
        }
        
        return totalCost[m-1][n-1];
    }
    
    // Main driver method
    public static void main(String args[]) {
        
        int cost[][] = new int[][]{ {1, 2, 3},
                                    {4, 8, 2},
                                    {1, 5, 3} };
        
        MinCost mc = new MinCost();
        System.out.println(mc.getMinCostRecursively(cost, cost.length - 1, cost[0].length - 1));
        System.out.println(mc.getMinCostIteratively(cost, cost.length - 1, cost[0].length - 1));
    }
    
}
