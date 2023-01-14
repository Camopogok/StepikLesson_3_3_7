import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JComponent implements KeyListener, ActionListener {
    static int winW = 800;
    static int winH = 600;
    int x;
    int y;
    int delta = 5;
    Image icon = new ImageIcon("src/иконка.png").getImage();
    Timer t = new Timer(10,this);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Текстуры");
        frame.setLocation(284,134);
        frame.setSize(winW, winH);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        Main main = new Main();
        frame.add(main);
        frame.addKeyListener(main);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT ) {
            if (x<=winW-50-60) {
                x += delta;
                if (keyEvent.isShiftDown()) {
                    x+= 2* delta;
                }
            } else x=0;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT ) {
            if (x>=50) {
                x -= delta;
                if (keyEvent.isShiftDown()) {
                    x-= 2* delta;
                }
            } else x = winW - 100;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN ) {
            if (y<=winH-50-60) {
                y += delta;
                if (keyEvent.isShiftDown()) {
                    y+= 2* delta;
                }
            } else y=0;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP ) {
            if (y>=50) {
                y -= delta;
                if (keyEvent.isShiftDown()) {
                    y-= 2* delta;
                }
            } else y=winH-100;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(icon, x, y, 50,50,null);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
