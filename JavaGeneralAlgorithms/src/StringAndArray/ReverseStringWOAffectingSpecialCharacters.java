/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringAndArray;

/**
 *
 * @author Romil Chauhan
 */
public class ReverseStringWOAffectingSpecialCharacters {
    
    //Reverse a string without affecting special characters
    public String reverseString(String inputString) {
        
        //Create temporary array
        char[] temp = inputString.toCharArray();
        int left = 0, right = inputString.length() - 1;
        
        //Reverse the string using two pointers each from start and end moving inwards.
        while(left < right) {
            
            //If the char at pointer left is not a alphabet
            if(!Character.isLetter(temp[left])) left++;
            //If the char at pointer right is not a alphabet
            else if(!Character.isLetter(temp[right])) right--;
            //If the char at both pointers are alphabet            
            else {
                
                char tempChar = temp[left];
                temp[left] = temp[right];
                temp[right] = tempChar;
                left++;
                right--;
            }
            
        }
        
        return new String(temp);
    }
    
    //Main driver method
    public static void main(String args[]) {
        
        
        String inputString = "a,b,c,$d";
        
        ReverseStringWOAffectingSpecialCharacters revStr = new ReverseStringWOAffectingSpecialCharacters();
        
        String outputString = revStr.reverseString(inputString);
        System.out.println("Input String: " + inputString);
        System.out.println("Output String: " + outputString);
    }
    
}

/*
OUTPUT:
Input String: a,b,c,$d
Output String: d,c,b,$a

Input String: a,456b,c,$d
Output String: d,456c,b,$a
*/