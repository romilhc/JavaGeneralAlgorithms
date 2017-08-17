/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;

import java.util.Arrays;

/**
 * @author Romil Chauhan
 * http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 */
public class CountTripletsWSumLessThanN {
    
    //Counting triplets with sum less than given value 
    public int countTriplets(int[] arr, int value) {
        
        //Sort the array
        Arrays.sort(arr);
        
        //Initialize result count
        int count = 0, j, k, n = arr.length;
        
        //Start counting triplet with element at ith index as first element
        for (int i = 0; i < (n-2); i++) {
            
            //Find remaining elements between j and k
            j = i + 1; k = n - 1;
            
            //Iterate to find the triplets by moving inside
            while (j < k) {
                
                //If sum is greater or equal to the three elements at i, j and k 
                if((arr[i] + arr[j] + arr[k]) >= value) k--;
                //If sum is less than three elements at i, j and k
                else {
                    
                    //If my sum with kth element is less than given value  
                    //then all the elements with less than k will also 
                    //satisfy the condition.
                    count += k - j;
                    
                    j++;
                
                }
                
            }
            
        }
        
        return count;
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        int[] arr = new int[] {5, 1, 3, 4, 7};
        int value = 12;
        
        CountTripletsWSumLessThanN triplets = new CountTripletsWSumLessThanN();
        
        System.out.println("Count: " + triplets.countTriplets(arr, value)); 
        
    }
    
}

/*
OUTPUT:
Count: 4
*/