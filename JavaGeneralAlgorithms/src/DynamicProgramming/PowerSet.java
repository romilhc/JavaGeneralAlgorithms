/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Romil Chauhan
 */
public class PowerSet {
    
    // Get the powerset for a given array
    public ArrayList<String> getPowerSet(char arr[]) {
        
        int n = arr.length;
        ArrayList<String> result = new ArrayList<>();
        result.add("");
        
        for(int i = 0; i < n; i++) {
            
            ArrayList<String> temp = new ArrayList<>();
            for(String s: result) {
                temp.add(s + "" + arr[i]);
            }
            
            result.addAll(temp);
        }
        
        
        return result;
    } 
    
    // Main driver method
    public static void main(String args[]) {
        char arr[] = new char[]{'a', 'b', 'c'};
        
        PowerSet ps = new PowerSet();
        System.out.println(ps.getPowerSet(arr));
    }
}
