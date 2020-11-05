public class Statistics implements Comparable<Statistics>{
    public String userName;
    public Integer score;
    public Statistics(String userName, Integer score) {
        this.score = score;
        this.userName = userName;
    }

    @Override
    public int compareTo(Statistics o) {
        if(score.compareTo(o.score) == 0)
            return o.userName.compareTo(userName);
        return o.score.compareTo(score);
    }

    @Override
    public String toString() {
        return userName + ": " + score;
    }
}
