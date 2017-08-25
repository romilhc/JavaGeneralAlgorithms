/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;

import java.util.Arrays;

/**
 * @author Romil Chauhan
 * Problem: http://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
 */
public class PythagoreanTriplet {
    
    //Check if given array has pythagorean triplet
    public boolean containsTriplet(int[] arr) {
        
        int n = arr.length, left, right;
        
        //Store all the squares
        for(int i = 0; i < n; i++) {
            arr[i] *= arr[i];
        }
        
        //Sort the array
        Arrays.sort(arr);
        
        //Fix the last (greatest of triplet) element and move inward using left and right
        for(int i = n - 1 ; i > 1; i--) {
            
            left = 0;   //Index of first element
            right = i - 1; //Index of last element in arr[0..i-1]
            
            //Move inward while left is less than right
            while(left < right) {
                
                //If sum of left and right equals the element at i then return true
                if((arr[left] + arr[right]) == arr[i]) return true;
                
                //Else if sum is less than i then increment left
                if((arr[left] + arr[right]) < arr[i]) left++;
                //If sum is greater than i then decrement right
                else right++;
            }
        }
        
        //If no triplet is found return false
        return false;
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        int[] arr = new int[] {5, 1, 3, 4, 7};
        
        PythagoreanTriplet pt = new PythagoreanTriplet();
        
        System.out.println("Input array: " + Arrays.toString(arr)); 
        System.out.println("Output: " + pt.containsTriplet(arr)); 
        
    }
    
}

/*
OUTPUT:
Input array: [5, 1, 3, 4, 7]
Output: true
Input array: [5, 1, 3, 34, 7]
Output: false
*/