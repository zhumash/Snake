import java.util.*;
import java.io.*;
public class StatisticsWriter {
    String path;
    public StatisticsWriter(String path) {
        this.path = path;
    }
    public String getStatistics(){
        Map <String, Integer> stats = new TreeMap();
        File f = new File(path);
        String ans = "";
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                String name = sc.next();
                int score = sc.nextInt();
                ans = ans + "\n" + name + ":" + score ;
            }
        }
        catch (Exception e) {
            return "\nFile not found";
        }
        return ans;
    }
}
