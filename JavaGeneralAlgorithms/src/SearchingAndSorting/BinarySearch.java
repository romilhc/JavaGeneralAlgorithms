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
    public int BinarySearchRecursive(int[] arr, int left, int right, int value) {
        
        if(left < right) {
            
        }
        
        return -1;
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        int[] arr = {6, 50, 100, 101, 134, 411};
        int n = arr.length;
        BinarySearch bs = new BinarySearch();
        
        int resultIndex = bs.BinarySearchRecursive(arr,0,n-1,100);
        
    }
}
