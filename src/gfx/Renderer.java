package gfx;

import java.awt.Color;
import java.awt.Graphics2D;

import entity.Enemy;
import entity.Player;

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
        m_Graphics.clearRect(0, 0, m_WindowWidth, m_WindowHeight);
    }

    public void drawPlayer(Player player)
    {
        m_Graphics.setColor(Color.BLUE);
        m_Graphics.fillRect(player.getXPosition(), player.getYPosition(), 32, 32);
    }

    public void drawEnemy(Enemy enemy)
    {
        m_Graphics.setColor(Color.RED);
        m_Graphics.fillRect(enemy.getXPosition(), enemy.getYPosition(), 32, 32);
    }
}
