import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class SnakeGui extends JFrame {
    private int width = 370, height = 380;
    private Snake s;
    boolean fieldPainted = false;
    private ArrayList <Point> drawed = new ArrayList ();
    private Food f;
    private Color fieldColor =new Color(40, 225, 225);
    private Color foodColor = Color.RED;
    private Color snakeColor =  new Color(33, 226, 52);
    public SnakeGui(){
        super("Snake");
        this.setBounds(400,200,width,height);
        s = new Snake(7,7, blocksW, blocksH);
        f = new Food(s, blocksW, blocksH);
        KeyListener kl = new KeyListener() {
            public void keyTyped(KeyEvent e) {
                System.out.println(e);
                if(e.getKeyChar() == 'w'){
                    s.changeDir(0, -1);
                }else if(e.getKeyChar() == 'a') {
                    s.changeDir(-1, 0);
                }else if(e.getKeyChar() == 'd') {
                    s.changeDir(1, 0);
                }else if(e.getKeyChar() == 's') {
                    s.changeDir(0, 1);
                }
            }
            public void keyPressed(KeyEvent e) {

            }
            public void keyReleased(KeyEvent e) {

            }
        };
        addKeyListener(kl);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        s.start();
    }
    public void paint(Graphics g) {
//        g.clearRect(0, 0, 2000, 2000);

        clearSnake(g);
        if(fieldPainted == false) {
            buildField(g);
            fieldPainted = true;
        }

        drawFood(f, g);
        drawSnake(g);
        if(f.checkColition(s)) {
            drawBlock(f.x, f.y,g, fieldColor);
            s.eat();
            f.next(s);
        }
        try {
            Thread.sleep(50);
        }catch (Exception e) {

        }
        repaint();
    }
    public void clearSnake(Graphics g) {
        for(Point p : drawed) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(fieldColor);
            g2.fillRect(p.x * (blocksize + 1)+ startx, p.y * (blocksize + 1)+ starty, blocksize , blocksize);
        }
    }
    int blocksize = 20;
    int startx = 25;
    int starty = 40;
    int blocksW = 15;
    int blocksH = 15;
    private void drawFood(Food f, Graphics g) {
        drawBlock(f.x, f.y, g, foodColor);

    }
    private void  drawSnake(Graphics g) {
        drawed.clear();
        for(int x = 0; x < blocksW; ++x) {
            for(int y = 0; y < blocksH; ++y) {
                if(s.isSnakeHere(x, y)) {

                    drawed.add(new Point(x, y));
                    drawBlock(x, y, g, snakeColor);
                }
            }
        }
    }

    void drawBlock(int x, int y, Graphics g, Color c) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(c);
        g2.fillRect(x * (blocksize + 1)+ startx, y * (blocksize + 1)+ starty, blocksize , blocksize);
    }
    private void buildField(Graphics g) {
        // 0 15

        for(int x = 0; x < blocksW; ++x) {
            for(int y = 0; y < blocksH; ++y) {
                drawBlock(x, y, g, fieldColor);
            }
        }
    }
}
