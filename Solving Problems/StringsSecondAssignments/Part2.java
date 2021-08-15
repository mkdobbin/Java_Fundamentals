
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part2 {

    public int howMany(String stringa, String stringb) {
        
        int lengthA = stringa.length();
        int currIndex = stringb.indexOf(stringa);
            
        int occur_times = 0;
        while (currIndex != -1){
            occur_times = occur_times + 1;
            currIndex = stringb.indexOf(stringa, currIndex + lengthA);
            
        }
        return occur_times;
    }
    
    public void testCountGenes(){
        
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        int test1 = howMany(stringa, stringb);
        System.out.println(test1);
        
        stringa = "AA";
        stringb = "ATAAAA";
        
        int test2 = howMany(stringa, stringb);
        System.out.println(test2);
        
    }
    
}

