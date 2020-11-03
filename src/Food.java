import java.awt.*;
import java.util.Random;

public class Food {
    public int x, y;
    int h, w;
    public Food(Snake s,int  h,int w) {
        this.h = h;
        this.w = w;
        next(s);

    }
    public boolean checkColition(Snake s) {
        return s.isSnakeHere(x, y);
    }
    public void next(Snake s) {
        Random r = new Random();
        while(s.isSnakeHere(x = r.nextInt(w) , y = r.nextInt(h)));
    }

}
