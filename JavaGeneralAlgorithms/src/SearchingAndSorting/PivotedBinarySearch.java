/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchingAndSorting;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Romil Chauhan
 * Problem: http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class PivotedBinarySearch {
    
    //Pivoted Binary Search
    public int pivotedBinarySearch(int[] arr, int left, int right, int value) {
        
        
        int n = arr.length - 1, pivot = findPivot(arr, 0, n);
        
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
            
            //Get middle element of the array 
            int mid = left + (right - left)/2;
            
            //If pivot element is found except the last element as mid
            if(mid < right && arr[mid] > arr[mid+1]) {
                return mid;
            }
            //If pivot element is found except the first element as mid
            else if(mid > left && arr[mid-1] > arr[mid]) {
                return (mid - 1);
            }
            //If pivot is on the left of middle element
            else if(arr[left] >= arr[mid]) {
                right = mid - 1;
            }
            //If pivot is on the right of middle element
            else {
                left = mid + 1;
            }
            
        }
        
        //If element is not found
        return -1;
    }
    
    //Main driver method
    /*public static void main(String args[]) {
        
        int[] arr = {6, 50, 100, 101, 134, 411, 600, 1};
        int[] arr1 = {100, 1, 2, 3, 4, 5};
        int n = arr1.length;
        
        PivotedBinarySearch pbs = new PivotedBinarySearch();
        int resultIndex = pbs.pivotedBinarySearch(arr1, 0, n-1, 100);
    
        if(resultIndex == -1) {
            System.out.println("Value not found in an array");
        }
        else {
            System.out.println("Value found at index: " + resultIndex);
        }
        
    }*/
    

    public static void main (String[] args) throws java.lang.Exception
    {
            // your code goes here
            int[] arr = new int[]{2,5,1,4,3};
            int k = 2;
            System.out.println(kEmptySlots(arr, k));

    }
	
    public static int kEmptySlots(int[] flowers, int k) {
        int[] days =  new int[flowers.length];
        for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for(int i = 0; right < days.length; i++){
            if(days[i] < days[left] || days[i] < days[right]){
                if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i; 
                right = k + 1 + i;
                //System.out.println(right + " " + res + " " + left] + " " + days[right]);
            }
            
        }
        return (res == Integer.MAX_VALUE)?-1:res;
    }
    
    /*public static String getNextTime(String s) {
        
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(char c: s.toCharArray()) {
            if(Character.isLetter(c))
        }
        
    } */
}


/*
OUTPUT:
Pivot found at index: 6
Value found at index: 0
*/