import java.util.*;
import java.io.*;
public class StatisticsWriter {
    String path;
    public StatisticsWriter(String path) {
        this.path = path;
    }
    public void addStats(String user, Integer newScore) {
        Map <String, Integer> stats = new TreeMap();
        File f = new File(path);
        try {
            ArrayList <Statistics> s = new ArrayList();
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                String name = sc.next();
                int score = sc.nextInt();
                stats.put(name, Math.max(stats.getOrDefault(name, 0 ), score));
            }
            stats.put(user, Math.max(stats.getOrDefault(user, 0), newScore));
            for (Map.Entry<String,Integer> entry : stats.entrySet())
                s.add(new Statistics(entry.getKey(), entry.getValue()));
            String ans = "";
            for(Statistics t : s) {
                if(ans.equals(""))
                    ans = t.userName + " " + t.score;
                else
                    ans += "\n" + t.userName + " " + t.score;
            }
//            System.out.println(ans);
            PrintWriter pw = new PrintWriter(f);
            pw.write(ans);
            pw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
    public String getStatistics(){
        Map <String, Integer> stats = new TreeMap();
        File f = new File(path);
        String ans = "";
        try {
            ArrayList <Statistics> s = new ArrayList();
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                String name = sc.next();
                int score = sc.nextInt();
                s.add(new Statistics(name, score));
            }
            Collections.sort(s);
            for(Statistics r : s) {
                ans = ans + "\n" +  r ;
            }
            sc.close();
        }
        catch (Exception e) {

            return "\nFile not found";
        }

        return ans;
    }
}
