import java.awt.*;
import java.util.*;
import java.util.List;

public class Snake extends Thread{
    private List <Point> points = new ArrayList ();
    private int dx = 0, dy = 0, w, h;
    public Snake(int startx, int starty, int w, int h) {
        points.add(new Point(startx, starty));
        this.w = w;
        this.h = h;
    }
    void eat() {
        int x = points.get(points.size() - 1).x;
        int y = points.get(points.size() - 1).y;
        points.add(new Point(x - dx, y - dy));
    }
    void changeDir(int dx, int dy) {
        if(dy != 0 && dy + this.dy == 0)
            return;
        if(dx != 0 && dx + this.dx == 0)
            return;

        this.dx = dx;
        this.dy = dy;
    }

    public boolean isSnakeHere(int x, int y) {
        return points.contains(new Point(x, y));
    }
    public void run() {
        while(true) {

            int nx = dx + points.get(0).x;
            int ny = dy + points.get(0).y;
            if(nx == w)
                nx = 0;
            if(ny == h)
                ny = 0;
            if(nx == -1)
                nx = w - 1;
            if(ny == -1)
                ny = h - 1;
            Point pv = points.get(0);
            points.set(0, new Point(nx, ny));

            for(int i = 1; i < points.size(); ++i) {
                Point tmp = points.get(i);
                points.set(i, pv);
                pv = tmp;
            }
            try {
                Thread.sleep(140);
            }catch (Exception e) {

            }
        }
    }


}

