
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part3 {

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        // find stopCodon starting from (startIndex +3), currIndex
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){
            int diff = currIndex - startIndex;
            if (diff % 3 == 0){
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }    
        }
        return dna.length();
    }
    
    public void testFindStop() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if (dex !=9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9, "TAA");
        if (dex != 21) System.out.println("error on 21");
                      
     
    }
    
    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        if (minIndex == dna.length()){
            return "not found";
        }
        return dna.substring(startIndex, minIndex +3);
        
        }
    
    public int countGenes(String dna) {
        
        int occur_times = 0;
        while (true) {
            String Gene = findGene(dna);
            
            System.out.println(Gene);
            if (Gene.equals("")){
                break;
            }
            occur_times = occur_times + 1;
            dna = dna.substring(dna.indexOf(Gene) + Gene.length());
        }
        
        return occur_times;
    }
        
 
    public void testFindGene(){
        String dna = "xxxyyyzzzATGxxxyyyzzzTAAxxxTAGTGA";
        String dex = findGene(dna);
        System.out.println(dex);
        if (dex != "ATGxxxyyyzzzTAA") System.out.println("error");
        dna = "xxxyyyzzzATGxxxyyyzzzTABxxxTAGTGA";
        dex = findGene(dna);
        System.out.println(dex);
        if (dex != "ATGxxxyyyzzzTABxxxTAG") System.out.println("error on min string");
        

    }
    
    public void printAllGenes(String dna){
        while (true) {
            String Gene = findGene(dna);
            System.out.println(Gene);
            if (Gene.equals("")){
                break;
            }
            dna = dna.substring(dna.indexOf(Gene) + Gene.length());
        }
    }
            
    public void testPrintAllGenes(){
        String dna = "xxxyyyzzzATGxxxyyyzzzTAAxxxATGTGA";
        printAllGenes(dna);
    }
    
    public void testCountGenes(){
        String dna = "xxxyyyzzzATGxxxyyyzzzTAAxxxATGTGA";
        int result = countGenes(dna); 
        System.out.println(result);
    }
}