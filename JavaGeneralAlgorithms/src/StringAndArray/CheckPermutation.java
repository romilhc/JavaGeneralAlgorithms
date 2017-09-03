/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Romil Chauhan
 * Cracking the Coding Interview: Chap1Prob2, http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 */
public class CheckPermutation {
    
    // Check if two strings are permutation on eachother.
    public boolean checkPermutation(String str1, String str2) {
        
        // Declare hashmap to track count of characters. 
        // Max length would be the total number of characters in Ascii Standard.
        HashMap<Character, Integer> charCounter = new HashMap<Character, Integer>();
        int len1 = str1.length(), len2 = str2.length();
        
        // If both the strings are of different length
        if(len1 != len2) return false;
        
        for(int i = 0; i < len1 && i < len2; i++) {
            
            // Increment the characters count of string 1.
            if(!charCounter.containsKey(str1.charAt(i))) {
                charCounter.put(str1.charAt(i), 1);
            }
            else {
                charCounter.put(str1.charAt(i), charCounter.get(str1.charAt(i)) + 1 );
            }
            
            // Increment the characters count of string 2.
            if(!charCounter.containsKey(str2.charAt(i))) {
                charCounter.put(str2.charAt(i), -1);
            }
            else {
                charCounter.put(str2.charAt(i), charCounter.get(str2.charAt(i)) - 1 );
            }
            
        }
        
        // Check the hashmap if any counter is non zero then return false.
        for(Map.Entry<Character, Integer> entry: charCounter.entrySet()) {
            if(entry.getValue() != 0) return false;
        }
        
        // If both strings are permutation of eachother.
        return true;
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        CheckPermutation checkPermut = new CheckPermutation();
        
        
        String str1 = "RomilC";
        String str2 = "CRomil";
        
        System.out.println("Is \"" + str1 + "\" and \"" + str2 + "\" permutation of eachother? " + checkPermut.checkPermutation(str1, str2));
        
        str1 = "Romilx";
        str2 = "CRomil";
        
        System.out.println("Is \"" + str1 + "\" and \"" + str2 + "\" permutation of eachother? " + checkPermut.checkPermutation(str1, str2));
        
    }
    
    
    
}

/*
OUTPUT:
Is "RomilC" and "CRomil" permutation of eachother? true
Is "Romilx" and "CRomil" permutation of eachother? false
*/
