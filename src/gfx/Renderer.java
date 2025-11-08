package gfx;

import java.awt.Color;
import java.awt.Graphics2D;

public class Renderer {
    
    private static  Renderer s_Singleton;

    private Graphics2D m_Graphics = null;
    private int m_WindowWidth = 0;
    private int m_WindowHeight = 0;

    private Renderer(Window window) {
        m_Graphics = window.getGraphics();
        m_WindowHeight = window.getHeight();
        m_WindowWidth = window.getWidth();
    }

    public static Renderer get()
    {
        return s_Singleton;
    }

    public static void init(Window window)
    {
        s_Singleton = new Renderer(window);
    }

    public void clear()
    {
        m_Graphics.setColor(Color.BLACK);
        m_Graphics.fillRect(0, 0, m_WindowWidth, m_WindowHeight);
    }
}
