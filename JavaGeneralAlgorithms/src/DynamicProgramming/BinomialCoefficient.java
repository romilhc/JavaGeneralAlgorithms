/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 * @author Romil Chauhan
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 */
public class BinomialCoefficient {
    
    /*
    The binomial coefficient problem can be solved recursively using the mathematical function:
    C(n, k) = C(n-1, k-1) + C(n-1, k)
    C(n, 0) = C(n, n) = 1
    */
    
    // Compute binomial coefficient recursively.
    public int getBinomialCoeffRecursively(int n, int k) {
        
        // Base Case: If k == 0 and n == k return 1
        if(k == 0 || n == k) return 1;
        
        // Else return sum of Coefficient of n-1,k-1 && n-1,k
        return getBinomialCoeffRecursively(n-1, k-1) + getBinomialCoeffRecursively(n-1, k);
        
    }
    
    // Compute binomial coefficient iteratively.
    public int getBinomialCoeffIteratively(int n, int k) {
        
        // One dimensional array is used to store previously computed values
        int j, C[] = new int[k+1];
        
        C[0] = 1;
        
        // Iterate till n to compute values
        for(int i = 1; i < n+1; i++) {
            j = Math.min(i, k);
            
            // J is iterated to compute coefficient values for each i
            while(j > 0) {
                
                // C[j-1] denotes (n-1,k-1) && C[j] denotes (n-1,k)
                C[j] = C[j] + C[j-1];
                j--;
            }
        }
        
        return C[k];
    }
    
    // Main driver method
    public static void main(String args[]) {
        
        BinomialCoefficient bc = new BinomialCoefficient();
        System.out.println(bc.getBinomialCoeffRecursively(5, 2));
        System.out.println(bc.getBinomialCoeffIteratively(5, 2));
        
    }
    
}
