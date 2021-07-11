/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("atg");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("taa", start+3);
        if ((stop - start) % 3 == 0) {
                return dna.substring(start, stop +3);
        }
        else {
                return "";
        }
        

    }

    public void testSimpleGene() {
        String one = "AAATGCCCTAACTAGATTAAGAAACC”";
	String two = "atgggataaa";
        String three = "";
        String four = "atg";
        
        String result1 = findSimpleGene(one);
        System.out.println("string : " + one + " gene: " + result1);
        String result2 = findSimpleGene(two);
        System.out.println("string : " + two + " gene: " + result2);
        String result3 = findSimpleGene(three);
        System.out.println("string : " + three + " gene: " + result3);
        String result4 = findSimpleGene(four);
        System.out.println("string : " + four + " gene: " + result4);
        
    }
}
