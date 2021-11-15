import edu.duke.*;

/**
 * Write a description of caesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Boolean upperCase;
        int idx;

        // Computer the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        // Count from 0 to < length of encrypted.
        for (int i = 0; i < encrypted.length(); i++) {
          
            // Look at the ith character of encrypted
            char currChar = encrypted.charAt(i);
            
            if (Character.isUpperCase(currChar)){
                upperCase = true;
                idx = alphabet.indexOf(currChar);
            }
            else{
                upperCase = false;
                idx = alphabet.indexOf(Character.toUpperCase(currChar));
                               
            }

            
            if (idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                
                if (upperCase == true){
                    encrypted.setCharAt(i, newChar);
                }
                else{
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
      
        
        }
        return encrypted.toString();
    }
    
    
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet; 
        Boolean upperCase;
        int idx;

        // Computer the shifted alphabet
        String shiftedAlphabetOne = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabetTwo = alphabet.substring(key2) + alphabet.substring(0, key2);
        
        // Count from 0 to < length of encrypted.
        for (int i = 0; i < encrypted.length(); i++) {
            
            
            // Look at the ith character of encrypted
            char currChar = encrypted.charAt(i);
            
            if (Character.isUpperCase(currChar)){
                upperCase = true;
                idx = alphabet.indexOf(currChar);
            }
            else{
                upperCase = false;
                idx = alphabet.indexOf(Character.toUpperCase(currChar));
                               
            }

            if (i % 2 == 0){
                shiftedAlphabet = shiftedAlphabetOne;
            }
            else{
                shiftedAlphabet = shiftedAlphabetTwo;
            }
            
            if (idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                
                if (upperCase == true){
                    encrypted.setCharAt(i, newChar);
                }
                else{
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
      
        
        }
        return encrypted.toString();
    }
       
    
    
    public void testCaesar(){
        int key =15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt("Noon be in the conference room with your hat on for a surprise party. YELL LOUD!", key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
        int key1 = 8;
        int key2 = 21;
        String encryptTwoKeys = encryptTwoKeys("Be in the conference room with your hat on for a surprise party. YELL LOUD!", key1, key2);
        System.out.println(encryptTwoKeys);
        String decryptTwoKeys = encryptTwoKeys(encryptTwoKeys, 26-key1, 26-key2);
        System.out.println(decryptTwoKeys);
    }
    
}
