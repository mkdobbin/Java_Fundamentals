import edu.duke.*;
/**
 * Write a description of BreakingCaesar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakingCaesar {
    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k=0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] +=1;
            }
        }
        return counts;
    }
    
    
    public int maxIndex(int[] values) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                index = i;
            }
        }
        return index;
    }
    
    
    public String halfOfString(String message, int start) {
        String answer = "";
        for (int i = start; i < message.length(); i += 2) {
            answer = answer + message.charAt(i);
        }
        return answer;
    }
    
    
    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    
    
    public String decryptTwoKeys(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String messageA = halfOfString(encrypted, 0);
        String messageB = halfOfString(encrypted, 1);
        int key1 = getKey(messageA);
        int key2 = getKey(messageB);
        System.out.println(key1 + " " + key2);
        
        return cc.encryptTwoKeys(encrypted, 26-key1, 26 - key2);
    }
        
    
    public void testdecrypt(){
        FileResource resource = new FileResource("mysteryTwoKeysPractice.txt");
        String message = "";
        for(String word : resource.words()){ 
            message = message + " " + word; 
        }
        //String message = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        System.out.println(decryptTwoKeys(message));
    }
        
    
    
    
}
