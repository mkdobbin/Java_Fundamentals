import java.util.*;

/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LargestQuakes {
    private int indexOfLargest(ArrayList<QuakeEntry> data){
        int index = -1;
        double maxMag = 0;
        for(QuakeEntry qe : data){
            double mag = qe.getMagnitude();
            if(maxMag < mag){
                maxMag = mag;
                index = data.indexOf(qe);
            }
        }
        return index;
    }
    
    private ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> quakeDataCopy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        for(int i = 0; i<howMany; i++){
            int index = indexOfLargest(quakeDataCopy);
            
            if(index == -1){ 
                break;
            }
            
            QuakeEntry quake = quakeDataCopy.get(index);
            answer.add(quake);
            quakeDataCopy.remove(quake);
            
        }
        return answer;
    }
    
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
    
   
        int howMany = 5;
        ArrayList<QuakeEntry> large = getLargest(list, howMany);
        for(QuakeEntry qe : large){
            System.out.println(qe);
        }
        System.out.println("Total number of earthquakes found: "+list.size());
    }
}

