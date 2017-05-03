package sample;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by RwD on 3/5/2017.
 */
public class Key {
    static char c;
    public static char getCh() {
        final JFrame frame = new JFrame();
        synchronized (frame) {
            frame.setUndecorated(true);
            frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    synchronized (frame) {
                        frame.setVisible(false);
                        frame.dispose();
                        frame.notify();
                    }
                    c = e.getKeyChar();
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    c = 0;
                }
                @Override
                public void keyTyped(KeyEvent e) {
                    c = 0;
                }
            });
            frame.setVisible(true);
            try {
                frame.wait();
            } catch (InterruptedException e1) {
            }
        }
        return c;
    }
}
