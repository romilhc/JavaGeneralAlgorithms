/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchingAndSorting;

/**
 *
 * @author Romil Chauhan
 */
public class PivotedBinarySearch {
    
    //Pivoted Binary Search
    public int pivotedBinarySearch(int[] arr, int left, int right, int value) {
        
        
        int n = arr.length - 1, pivot = findPivot(arr, 0, n-1);
        
        //Compare value with pivot's value and set left and right accordingly.
        if(pivot != -1) {
            System.out.println("Pivot found at index: " + pivot);
            if(value >= arr[left]) right = pivot;
            else left = pivot + 1;
        }
        else {
            System.out.println("Array is already sorted in increasing order.");
        }
        
        
        //Now apply normal binary search.
        BinarySearch bs = new BinarySearch();
        return bs.binarySearchIterative(arr, left, right, value);
        
    }
    
    //Find pivot element in a increasing sorted array
    public int findPivot(int[] arr, int left, int right) {
        
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            
            if(mid < right && arr[mid] > arr[mid+1]) {
                return mid;
            }
            else if(mid > left && arr[mid-1] > arr[mid]) {
                return (mid - 1);
            }
            else if(arr[left] >= arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            
        }
        
        //If element is not found
        return -1;
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        int[] arr = {6, 50, 100, 101, 134, 411, 600, 1, 2, 3};
        int n = arr.length;
        
        PivotedBinarySearch pbs = new PivotedBinarySearch();
        int resultIndex = pbs.pivotedBinarySearch(arr, 0, n-1, 6);
    
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
Pivot found at index: 6
Value found at index: 0
*/