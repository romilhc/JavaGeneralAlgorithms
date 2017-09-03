/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;

/**
 * @author Romil Chauhan
 * Cracking the Coding Interview: Chap1Prob5
 */

public class OneAway {
    
    // Check if two strings are one edit away
    public boolean checkOneAwayUsingRunLength(String s1, String s2) {
        
        int len1 = s1.length(), len2 = s2.length(), i = 0, j = 0;
        
        // If one string is greater than another by more than one character
        if((len1 - len2) > 1) return false;
        if((len1 - len2) < -1) return false;
        
        // If second string is greater than first by length 1
        if((len1 - len2) == -1) return checkOneAwayUsingRunLength(s2, s1);
        
        // flag to track only one edit
        boolean flag = false;
        
        // Check if characters are same at each index except one
        while (j < len2) {
            
            // If there is first occurance of dissimilarity 
            if(s1.charAt(i) != s2.charAt(j) && !flag) {
                
                i++;
                
                //If both the strings are of same length
                if(len1 == len2) j++;
                flag = true;
                continue;
            
            }
            // If more than one characters are not same
            else if(s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        
        return true;
    }
    
    //Main driver method
    public static void main(String args[])
    {
        String s1="pale";
        String s2="bale";
        
        OneAway oa = new OneAway();
        
        System.out.println("Are \"" + s1 + "\" and \"" + s2 + "\" are one edit away? " + oa.checkOneAwayUsingRunLength(s1, s2));
    }
    
}

/*
OUTPUT:
Are "pale" and "bale" are one edit away? true
*/