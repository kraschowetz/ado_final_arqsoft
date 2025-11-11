package gfx;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

// implementação concreta da interface Window
public class MobileWindow extends Canvas implements Window {

    // largura e altura da janela, em pixels
    private static final int WIDTH = 360;
    private static final int HEIGHT = 800;
    // numero de buffers para serem usados na BufferStrategy
    private static final int NUM_BUFFERS = 2;
    // título da janela
    private static final String TITLE = "Janela Mobile!";

    private Graphics2D m_Graphics2D = null;
    private BufferStrategy m_BufferStrategy = null;

    // exibe a janela
    @Override
    public void display() {
        m_Graphics2D.dispose();
        getBufferStrategy().show();
        m_Graphics2D = (Graphics2D) m_BufferStrategy.getDrawGraphics();
    }

    // configura um JFrame para exibir a janela
    public MobileWindow()
    {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        JFrame frame = new JFrame();
        frame.add(this);
        frame.setTitle(TITLE);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerra a aplicação ao fechar a janela
        frame.setResizable(false);
        frame.setVisible(true);
        frame.requestFocus();
        frame.pack();
    }

    // inicializa o componente Graphics2D e BufferStrategy
    @Override
    public void init() {
        createBufferStrategy(NUM_BUFFERS);
        m_BufferStrategy = getBufferStrategy();
        m_Graphics2D = (Graphics2D)m_BufferStrategy.getDrawGraphics();
    }

    @Override
    public Graphics2D getGraphics() {
        return m_Graphics2D;
    }
    
    @Override
    public int getWidth()
    {
        return WIDTH;
    }

    @Override
    public int getHeight()
    {
        return HEIGHT;
    }
}
