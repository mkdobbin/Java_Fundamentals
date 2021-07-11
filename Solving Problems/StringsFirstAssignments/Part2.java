
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String dnaUpper = dna.toUpperCase();
        int Upper = 0;
        if(dnaUpper == dna) {
            Upper = 1;
        }
        
        String dnaLower = dna.toLowerCase();
        String startCodonLower = startCodon.toLowerCase();
        String stopCodonLower = stopCodon.toLowerCase();
                
        int start = dnaLower.indexOf(startCodonLower);
        if (start == -1) {
            return "no start";
        }
        int stop = dnaLower.indexOf(stopCodonLower, start+3);
        if (stop == -1) {
            return "no end";
        }
        if ((stop - start) % 3 == 0) {
            if(Upper == 1) {
                return dna.substring(start, stop +3);
            }
            else {
                return dnaLower.substring(start, stop +3);
            }
        }
        else {
                return "Not a multiple";
        }
        

    }

    public void testSimpleGene() {
        String one = "cccatggggtttaaataataataggagagagagagagagttt";
        String two = "atgggataaa";
        String three = "ATGGGATAAA";
        String four = "atg";
        
        String result1 = findSimpleGene(one, "atg", "taa");
        System.out.println("string : " + two + " gene: " + result1);
        String result2 = findSimpleGene(two, "atg", "taa");
        System.out.println("string : " + two + " gene: " + result2);
        String result3 = findSimpleGene(three, "atg", "taa");
        System.out.println("string : " + three + " gene: " + result3);
        String result4 = findSimpleGene(four, "atg", "taa");
        System.out.println("string : " + four + " gene: " + result4);
        
    }
}

