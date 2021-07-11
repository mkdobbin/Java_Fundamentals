
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class Part3 {
    public boolean twoOccurences(String stringa, String stringb) {
        
        int found = stringb.indexOf(stringa);
        int count = 0;
        
        while (found != -1) {
            count = count +1;
            found = stringb.indexOf(stringa, found+1);
        }
        if(count > 1) {
            return true;
        }
        else {
            return false;
        }

    }
    
    
    public String lastPart(String stringa, String stringb) {
        int lengthA = stringa.length();
        int lengthB = stringb.length();
        int found = stringb.indexOf(stringa);
        if(found == -1){
            return stringb;
        }
        else {
            String lastPart = stringb.substring(found + lengthA, lengthB);            
            return lastPart; 
        }
        
        
    }
        
    
    
    public void testing() {
        String one = "a";
        String two = "cc";
        String three = "ba";
        String four = "howdy";
        String longstring = "abaabcdaba";
        String small = "apn";
        String big = "banana";
        
        boolean result1 = twoOccurences(one, longstring);
        System.out.println("string A : " + one + " String B : " + longstring + " Result: " + result1);
        boolean result2 = twoOccurences(two, longstring);
        System.out.println("string A : " + two + " String B : " + longstring + " Result: " + result2);
        String result3 = lastPart(small, big);
        System.out.println("string A : " + small + " String B : " + big + " Result: " + result3);
        
    
    }
}
