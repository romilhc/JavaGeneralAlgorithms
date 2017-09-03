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
public class StringCompression {
    
    public String compressString(String s) {
        
        StringBuilder compressedString = new StringBuilder();
        int n = s.length(), charCounter = 0;
        
        // Iterate through string to compress it
        for(int i = 0; i < n; i++) {
            charCounter++;
            
            // Append when character changes or string end has come
            if((i + 1) == n || s.charAt(i) != s.charAt(i + 1)) {
                compressedString.append(s.charAt(i));
                compressedString.append(charCounter);
                charCounter = 0;
            }
        }
        
        // Return the minimum of compressedString length and original string length
        return compressedString.length() < s.length() ? compressedString.toString() : s;
    }
    
    //Main driver method
    public static void main(String args[])
    {
        String s1 = "aaaaaabbccd";
        
        StringCompression compressor = new StringCompression();
        
        System.out.println("Compressed String: " + compressor.compressString(s1));
    }
    
}

/*
INPUT:
aaaaaabbccd
OUTPUT:
Compressed String: a6b2c2d1

*/