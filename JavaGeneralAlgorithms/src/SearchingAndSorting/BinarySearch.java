/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchingAndSorting;
import java.util.Arrays;

/**
 *
 * @author Romil Chauhan
 */
public class BinarySearch {
    
    //Recursive binary search
    public int binarySearchRecursive(int[] arr, int left, int right, int value) {
        
        try {
            
            if(left <= right) {
            
                //Get middle element of the array 
                int mid = left + (right - left)/2;

                //If value is found
                if(arr[mid] == value) {
                    return mid;
                }
                //If value is on the left of middle element
                else if(arr[mid] > value) {
                    return binarySearchRecursive(arr, left, mid - 1, value);
                }
                //If value is on the right of middle element
                else if(arr[mid] < value) {
                    return binarySearchRecursive(arr, mid + 1, right, value);
                }
                
            }
            
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        
        //If element is not found
        return -1;
    }
    
    //Recursive binary search
    public int binarySearchIterative(int[] arr, int left, int right, int value) {
        
        try {
            
            while(left <= right) {
            
                //Get middle element of the array 
                int mid = left + (right - left)/2;

                //If value is found
                if(arr[mid] == value) {
                    return mid;
                }
                //If value is on the left of middle element
                else if(arr[mid] > value) {
                    right = mid - 1;
                }
                //If value is on the right of middle element
                else if(arr[mid] < value) {
                    left = mid + 1;
                }
            }
        
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
     
        //If element is not found
        return -1;
    }
    
    
    //Main driver method
    public static void main(String args[]) {
        
        int[] arr = {6, 50, 100, 101, 134, 411, 600};
        int n = arr.length;
        
        BinarySearch bs = new BinarySearch();
        
        //Testing recursive function
        int resultIndex = bs.binarySearchRecursive(arr,0,n-1,50);
        if(resultIndex == -1) {
            System.out.println("Value not found in an array");
        }
        else {
            System.out.println("Value found at index: " + resultIndex);
        }

        //Testing iterative function        
        resultIndex = bs.binarySearchIterative(arr, 0, n-1, 134);
        if(resultIndex == -1) {
            System.out.println("Value not found in an array");
        }
        else {
            System.out.println("Value found at index: " + resultIndex);
        }
        
    }
}

/*
OUTPUT:
Value found at index: 1
Value found at index: 4
*/
