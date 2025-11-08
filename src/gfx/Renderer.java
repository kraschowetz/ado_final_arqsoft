package gfx;

import java.awt.Graphics2D;

public class Renderer {
    
    private static  Renderer s_Singleton;

    private Graphics2D m_Graphics = null;
    private int m_WindowWidth = 0;
    private int m_WindowHeight = 0;

    private Renderer() {}

    public static Renderer get()
    {
        return s_Singleton;
    }

    public void init(Window window)
    {
        m_Graphics = window.getGraphics();
    }

    public void clear()
    {

    }
}
