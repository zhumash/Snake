
public class Point implements Comparable <Point>{
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(x > o.y)
            return 1;
        if(x < o.y)
            return -1;
        if(y > o.y)
            return 1;
        if(y < o.y)
            return -1;
        return 0;
    }


    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o.getClass() != this.getClass())
            return false;
        Point p = (Point)o;
        return p.x == this.x && p.y == this.y;
    }
}
