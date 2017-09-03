/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;

/**
 * @author Romil Chauhan
 * Cracking the Coding Interview: Chap1Prob1, http://www.geeksforgeeks.org/determine-string-unique-characters/ 
 */
public class IsUnique {
    
    // Check if string has unique characters. No extra space.
    // Assuming string contains a-z characters only.
    // Using long int we can check for more range of characters.
    public boolean checkUniqueCharWOExtraSpace(String s) {
        
        // Checker variable acts as an boolean array to keep track of characters
        int checker = 0, val;
        
        // Iterate over string and check if the bit is set in checker for
        // character then return false else set the bit in checker.
        for(char ch: s.toCharArray()) {
            val = ch - 'a';
            
            if((checker & (1 << val)) > 0) {
                return false;
            }
            
            checker |= (1 << val);
        }
        
        // Complete string iterated and all characters are unique
        return true;
    }
    
    // Check if string has unique characters. Using extra space.
    // Assuming string contains ascii characters only. 
    public boolean checkUniqueChar(String s) {
        
        // Create boolean array to check if character has occured before
        boolean[] arr = new boolean[128];
        
        // Iterate over string and if the bool is false in an array make it true
        // else return false
        for(char ch: s.toCharArray()) {
            if(!arr[ch]) arr[ch] = true;
            else return false;
        }
        
        // Complete string iterated and all characters are unique
        return true;
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        IsUnique isUnique = new IsUnique();
        
        // Checking using extra space
        String s = "MyNameIs";
        String str = "MyNameIsRomilChauhan";
        
        System.out.println("Is \"" + s + "\" unique? " + isUnique.checkUniqueChar(s));
        System.out.println("Is \"" + str + "\" unique? " + isUnique.checkUniqueChar(str));

        //Checking without extra space
        s = "iamrhc";
        str = "mynameisromilchauhan";
        
        System.out.println("Is \"" + s + "\" unique? " + isUnique.checkUniqueCharWOExtraSpace(s));
        System.out.println("Is \"" + str + "\" unique? " + isUnique.checkUniqueCharWOExtraSpace(str));

    }
}

/*
OUTPUT:
Using extra space
Is "MyNameIs" unique? true
Is "MyNameIsRomilChauhan" unique? false
Without any extra space
Is "iamrhc" unique? true
Is "mynameisromilchauhan" unique? false
*/
