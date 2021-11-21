
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Tester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le.getLogInfo());
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300,400);
        System.out.println(le2);
       
    }
    
    
    public void testLogAnalyzer(){
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        System.out.println(LogAnalyzer.countUniqueIPs());
        
    }
    
    
    public void testUniqueIP(){
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        System.out.println("There are " + LogAnalyzer.countUniqueIPs()+ " different IPs");
    }
    
   
    public void testStatusCodeHigherThanNum(){
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        LogAnalyzer.printAllHigherThanNum(400);
    }
    
   
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        LogAnalyzer.countUniqueIPs();
        ArrayList a = LogAnalyzer.uniqueIPVisitsOnDay("Sep 27");
        System.out.println(a.size());
    }
    
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        System.out.println(LogAnalyzer.countUniqueIPsInRange(400,499));
    }
    
    public void testWebsiteVisits(){
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("weblog2_log");
        HashMap<String,Integer> counts = LogAnalyzer.countVisitsPerIP();
        System.out.println(counts);
        System.out.println("The ip with most visits "  + LogAnalyzer.mostNumberVisitsByIP(counts)+ " times.");
        System.out.print("These are the ip's with more visits: ");
        System.out.println(LogAnalyzer.iPsMostVisits(counts));
        HashMap<String,ArrayList<String>> daysIps = LogAnalyzer.iPsForDays();
        System.out.println(daysIps);
        HashMap<String,ArrayList<String>> datesIpMap = LogAnalyzer.dayCountHash();
        System.out.println("Day with most different IP visits: " + LogAnalyzer.dayWithMostIPVisits(datesIpMap));
        System.out.println(LogAnalyzer.iPsWithMostVisitsOnDay(datesIpMap, "Sep 30"));
    }
    
}
