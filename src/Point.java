
public class Point{
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
