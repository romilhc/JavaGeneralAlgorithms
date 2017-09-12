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
public class RecursiveMultiplication {
    
    // Multiply two numbers without using mulitplication operator
    public int getProduct(int a, int b) {
        
        if(b == 0 || a == 0) return 0;
        
        if(b == 1) return a;
        
        if(b%2 == 0) return getProduct(a << 1, b/2);
        else return a + getProduct(a, b-1);
        
    }
    
    // Main driver mehtod
    public static void main(String args[]) {
        
        RecursiveMultiplication rm = new RecursiveMultiplication();
        
        System.out.println(rm.getProduct(1,5));
        
    }
    
}
