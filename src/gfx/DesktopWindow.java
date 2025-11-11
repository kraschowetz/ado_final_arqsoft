package gfx;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

// implementação concreta da interface Window
public class DesktopWindow extends Canvas implements Window {

    // largura e altura da janela, em pixels
    static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    // numero de buffers para serem usados na BufferStrategy
    private static final int NUM_BUFFERS = 2;
    // título da janela
    private static final String TITLE = "Janela Desktop!";

    private Graphics2D m_Graphics2D = null;
    private BufferStrategy m_BufferStrategy = null;

    // exibe a janela
    @Override
    public void display() {
        m_Graphics2D.dispose();
        m_BufferStrategy.show();
        m_Graphics2D = (Graphics2D) m_BufferStrategy.getDrawGraphics();
    }

    // configura um JFrame para exibir a janela
    public DesktopWindow()
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
