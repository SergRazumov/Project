import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEvents extends Applet implements KeyListener {

    String msg = "";
    public void init() {
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        msg = "keyTyped";
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        msg = "keyPressed";
    }

    @Override
    public void keyReleased(KeyEvent e) {
        msg = "keyReleased";
    }

    public void paint(Graphics g) {
        g.drawString(msg, 0 ,0 );
    }
}
