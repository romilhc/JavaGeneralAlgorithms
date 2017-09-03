/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;

/**
 * @author Romil Chauhan
 * Cracking the Coding Interview: Chap1Prob4
 */
public class PalindromePermutation {
    
    // Check if the string is palindrome permutation.
    // String should contains characters from a-z only. 
    public boolean checkPalindormePermutation(String str) {
        
        //Create bit vector for the given string
        int bitVector = countCharacters(str);
        
        //Check exactly one or not bit is set in bitVector
        return checkOneOrNoBitSet(bitVector);
    }
    
    // Create bitVector for given string 
    public int countCharacters(String str) {
        
        int bitVector = 0;
        
        for(char ch: str.toCharArray()) {
            bitVector = toggleBitVector(bitVector, ch - 'a');
        }
    
        return bitVector;
    }
    
    // Toggle bit in bitVector;
    public int toggleBitVector(int bitVector, int index) {
        
        int mask = 1 << index;
        
        if((bitVector & mask) == 0) {
            bitVector |= mask;
        }
        else {
            bitVector &= ~mask;
        }
        
        return bitVector;
    }
    
    // Check if the bitVector has only one or no bit set
    public boolean checkOneOrNoBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        PalindromePermutation checkPP = new PalindromePermutation();
        
        String str1 = "romilcromil";
        
        System.out.println("Is \"" + str1 + "\" palindrome permutation? " + checkPP.checkPalindormePermutation(str1));
        
        
    }
    
}

/*
OUTPUT:
Is "romilcromil" palindrome permutation? true
*/
