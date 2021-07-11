
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class Part4 {

    public void processWordsWebPage() {
        URLResource webPage = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
            for (String word : webPage.words()) {
                String wordLow = word.toLowerCase();
                
                int found = wordLow.indexOf("youtube.com");
                if(found != -1){
                    int start = wordLow.indexOf("\"");
                    int end = wordLow.lastIndexOf("\"");
                    String link = word.substring(start+1, end);
                    System.out.println(link);
            }

            
    }    
}
}
