import java.util.*;
import edu.duke.*;

/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LogAnalyzer {
    
    private ArrayList<LogEntry> records;
    int index;
    
    public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
    }
      
     //Complete the readFile method to create a FileResource and
     //iterate over all lines,create a LogEntry and store it in the 
     //records ArrayList.
     
    public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines()){
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);                        
         }
    }
    
    public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le: records){
            String ipAddr = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }
    
    
    public void printAllHigherThanNum(int num){
         for (LogEntry le : records){
             
             int statusCode = le.getStatusCode();
             if (statusCode > num){
                System.out.println(le.getStatusCode()); 
             }
         }
     }
    
     
    public ArrayList uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIPs = new ArrayList<String>(); 
        ArrayList<String> uniqueIPsDates = new ArrayList<String>(); 
         for (LogEntry le : records){
             Date d = le.getAccessTime();
             String str = d.toString();
             String subStr = str.substring(4,10); 
             String ipAddr = le.getIpAddress();
             if(subStr.equals(someday) && !uniqueIPs.contains(ipAddr)){
                 uniqueIPs.add(ipAddr);
                 uniqueIPsDates.add(subStr);
                 
             }
        }
        return uniqueIPs;
    }
    
    
    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueIPs = new ArrayList<String>(); 
        ArrayList<Integer> uniqueIPsStatus = new ArrayList<Integer>();
        for (LogEntry le : records){
           int status = le.getStatusCode();
           String ipAddr = le.getIpAddress();
           if (status >= low && status <= high && !uniqueIPs.contains(ipAddr)){
               uniqueIPs.add(ipAddr);
               uniqueIPsStatus.add(status);
            }
        }
        return uniqueIPsStatus.size();
    }
    
    
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
    }
    
    
    public HashMap countVisitsPerIP(){
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for(LogEntry le: records){
            String ip = le.getIpAddress();
            if(!counts.containsKey(ip)){
                counts.put(ip,1);
            }
            else {
                counts.put(ip,counts.get(ip)+1);
            }
        }
        return counts;
    }
    
    
    public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
        index = 0;
        for (int num : counts.values()){
            if (index < num){
                index = num;
            }
        }
        return index;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
        
        ArrayList<String> maxIPs = new ArrayList<String>();
        for (String s : counts.keySet()){
            if (counts.get(s) == index){
                maxIPs.add(s);
            }
        }
        return maxIPs;
    }
    
    
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>> daysIps = new HashMap<String,ArrayList<String>>();
        
        for(LogEntry le: records){
            ArrayList<String> date = new ArrayList<String>();
            String ip = le.getIpAddress();
            Date d = le.getAccessTime();
            String str = d.toString();
            String dateStr = str.substring(4,10); 
            
            if(!daysIps.containsKey(ip)){
                date.add(dateStr);
                daysIps.put(ip,date);
                
            }
            
            else{
                
                date = daysIps.get(ip);
                if (!date.contains(dateStr)){
                    date.add(dateStr);
                }
            }
        }
        return daysIps;
    }
    
    
    public HashMap<String, ArrayList<String>> dayCountHash(){
        
        HashMap<String,ArrayList<String>> datesIpMap = new HashMap<String,ArrayList<String>>();
        for(LogEntry le: records){
            ArrayList<String>ipArray = new ArrayList<String>();
            String ip = le.getIpAddress();
            Date d = le.getAccessTime();
            String str = d.toString();
            String dateStr = str.substring(4,10); 
            if(!datesIpMap.containsKey(dateStr)){
                ipArray.add(ip);
                datesIpMap.put(dateStr,ipArray);
            }
            else{
                ipArray = datesIpMap.get(dateStr);
                if (!ipArray.contains(ip)){
                    ipArray.add(ip);
                }
            }
        }
        return datesIpMap;
    }
    
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
        
        int indexMap = 0;
        
        for (ArrayList s: map.values()){
            if(indexMap < s.size()){
                indexMap = s.size();
            }
        }
        
        for(String s: map.keySet()){
            ArrayList ips = map.get(s);
            if(indexMap == ips.size()){
                return s;
            }
        }
        return null; 
    }
    
    
    private HashMap<String, Integer> countVisitsPerIP(String day) {
    	 HashMap<String, Integer> map = new HashMap<String, Integer>();
    	 
    	 for (LogEntry le : records) {
    		 if (!getDay(le).equals(day)) continue;
    		 
    		 String ip = le.getIpAddress();
    		 if (!map.keySet().contains(ip)) map.put(ip, 1);
    		 else map.put(ip, map.get(ip)+1);
    	 }
    	 return map;
    	 
     }
    
     private String getDay(LogEntry le) {
    	 String date = le.getAccessTime().toString()
    	 return date.substring(4, 10);
     }
    
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String day){
        
        System.out.println("The " + day + ", these IPs visited our website: ");
        ArrayList<String> list = new ArrayList<String>();
    	HashMap<String, Integer> visits = countVisitsPerIP(day);
    	 
    	int maxCount = 0;
    	for (int count : visits.values()) 
    	   if (count > maxCount) maxCount = count;
    	 
    	for (String ip : visits.keySet())
    	   if (visits.get(ip) == maxCount) list.add(ip);
    	 
    	return list;
     }
}

    

    
