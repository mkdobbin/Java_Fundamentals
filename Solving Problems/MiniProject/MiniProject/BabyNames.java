import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class BabyNames {
        
    public FileResource readOneFile(int year) {
        String fname = "us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fname);       
        return fr;
    }
    
    
    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalMaleBirths = 0;
        int totalFemaleBirths =0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            String gender = rec.get(1);
            if (gender.equals("M")){
                totalMaleBirths += numBorn;
            }
            else {
                totalFemaleBirths += numBorn;
            }
                   
            totalBirths += numBorn;
        
        
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total male births = " + totalMaleBirths);
        System.out.println("total female births = " + totalFemaleBirths);
    
    }
    
    public int getRank(int year, String name, String gender){
        FileResource fr = readOneFile(year);
        int rank =1;
        for (CSVRecord rec : fr.getCSVParser(false)){
            String record_name = rec.get(0);
            String record_gender = rec.get(1);
            
            if (record_gender.equals(gender)){
                
                if (record_name.equals(name)){
                    return rank;
                }
                else{
                    rank = rank + 1;
                }
            }
            
        }
        return -1;
    }
    
    
    public String getName(int year, int rank, String gender){
        FileResource fr = readOneFile(year);
        int count = 1;
        for (CSVRecord rec : fr.getCSVParser(false)){
            String record_name = rec.get(0);
            String record_gender = rec.get(1);
            
            if (record_gender.equals(gender)){
                
                if (count == rank){
                    return record_name;
                }
                else {
                    count = count + 1;
                }
            }
        }
        return "NO NAME";
    }
    
    
    public String whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);   
        String finalString = name + "born in " + year + " would be " + newName + "if born in " + newYear;
        return finalString;
    }
    
    
    public int yearOfHighestRank(String name, String gender){
    int highestRank = 0;
    int yearWithHighestRank = 0;
    DirectoryResource dr = new DirectoryResource();
    for(File f: dr.selectedFiles()){
        String filename = f.getName();
        System.out.println("the file we select is: "+ filename);
        int year = Integer.parseInt(filename.substring(3,7));
        int rank = getRank(year, name, gender);
        System.out.println("the rank of year "+ year + " is "+ rank);
        if(rank == -1){
            continue;
        }
        if(highestRank == 0){
            highestRank = rank;
            yearWithHighestRank = year;
        }
        else{
            if(rank < highestRank){
                highestRank = rank;
                yearWithHighestRank = year;
            }
            else{
                continue;
                }
            }
        }

    if(highestRank == 0){
        return -1;
    }
    else{
        return yearWithHighestRank;
    }
    
    }   
    
    
    public double getAverageRank(String name, String gender){
	int totalRank = 0;
	int count = 0;
	DirectoryResource dr = new DirectoryResource();
	for(File f: dr.selectedFiles()){
	    String filename = f.getName();
	    System.out.println("the file we select is: "+ filename);
	    int year = Integer.parseInt(filename.substring(3,7));
	    int rank = getRank(year, name, gender);
	    System.out.println("the rank of year "+ year + " is "+ rank);
	    if(rank == -1){
		continue;
            }
            else {
		totalRank += rank;
		count++;
	    }
	}
	if(count == 0){
		return -1;
	}
	else{
		return (double)totalRank/count;
	}
    }
    
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
	int theRank = getRank(year,name,gender);
	int qualifyTotalBirth = 0;
	FileResource fr = new FileResource();
	for(CSVRecord record: fr.getCSVParser()){
	    String thisName = record.get(0);
	    String thisGender = record.get(1);
	    int totalbirthOfName = Integer.parseInt(record.get(2));
	    if(!thisGender.equals(gender)){
		continue;
            }
            else {
		if(!thisName.equals(name)) {
		    qualifyTotalBirth += totalbirthOfName;
		}
		else{
		    return qualifyTotalBirth;
		}
	    }
	}
	return -1;
    }
    
    
    public void testWhatIsNameInYear(){
        String finalString = whatIsNameInYear("Owen", 1974, 2014, "M");
        System.out.println(finalString);
               
    }
    
    public void testTotalBirths(){
        FileResource fr = new FileResource("us_babynames_by_year/yob1905.csv");
        totalBirths(fr);
    }
    
    public void testGetRank(){
        int rankF1 = getRank(1971,"Frank","M");
        System.out.println(rankF1);
               
    }
    
    public void testGetName(){
        String nameF3 = getName(1980, 350, "F");
        System.out.println(nameF3);
        String namex = getName(1982, 450, "M");
        System.out.println(namex);
        String nameM5 = getName(2012, 5, "M");
        System.out.println(nameM5);
    }
    
    public void testyearOfHighestRank(){
        int year = yearOfHighestRank("Mich", "M");
        System.out.println(year);
    }
    
    public void testgetAverageRank(){
        double avgRank = getAverageRank("Susan", "F");
        System.out.println(avgRank);
    }
    
    public void testgetTotalBirthsRankedHigher(){
        int num_higher_rank_births = getTotalBirthsRankedHigher(1990, "Emily", "F");
        System.out.println(num_higher_rank_births);
    
    }
}
