/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;
import java.util.Arrays;
/**
 * @author Romil Chauhan
 * Problem: http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 */
public class ConvertArrayToZigzagFashion {
    
    //Swap the elements at i and j in an array
    public void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //Convert array to zigzag fashion in form  a < b > c < d > e < f
    public void convertToZigzag(int[] arr) {
        
        //Flag denotes the status of current comparision operator, true denotes < and false denotes >
        boolean flag = true;
        
        for(int i = 0; i <= arr.length - 2; i++) {
            
            //If current operator is < and arr[i] is greater than arr[i+1] then swap them
            if(flag) {
                if(arr[i] > arr[i+1]) Swap(arr,i,i+1);
            }
            //If current operator is > and arr[i] is less than arr[i+1] then swap them
            else {
                if(arr[i] < arr[i+1]) Swap(arr,i,i+1);
            }
            
            //Toggle flag
            flag = !flag;
        }
        
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        int[] arr = new int[] {5, 1, 3, 4, 7};
        
        ConvertArrayToZigzagFashion zigzag = new ConvertArrayToZigzagFashion();
        
        System.out.println("Input array: " + Arrays.toString(arr)); 
        zigzag.convertToZigzag(arr);
        System.out.println("Output array: " + Arrays.toString(arr)); 
        
    }
    
}

/*
OUTPUT:
Input array: [5, 1, 3, 4, 7]
Output array: [1, 5, 3, 7, 4]
*/