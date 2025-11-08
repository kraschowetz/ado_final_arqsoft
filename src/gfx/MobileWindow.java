package gfx;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class MobileWindow extends Canvas implements Window {

    private static final int WIDTH = 360;
    private static final int HEIGHT = 800;
    private static final int NUM_BUFFERS = 2;
    private static final String TITLE = "Janela Mobile!";

    private Graphics2D graphics2D = null;

    @Override
    public void display() {
        getBufferStrategy().show();
    }

    @Override
    public void init() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        JFrame frame = new JFrame();
        frame.add(this);
        frame.setTitle(TITLE);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.requestFocus();
        frame.pack();

        if(getBufferStrategy() == null) {
            createBufferStrategy(NUM_BUFFERS);
        }
        graphics2D = (Graphics2D)(getBufferStrategy().getDrawGraphics());
    }

    @Override
    public Graphics2D getGraphics() {
        return graphics2D;
    }
    
}
