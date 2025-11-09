package core;

import java.awt.Color;
import java.util.ArrayList;

import entity.Enemy;
import entity.Player;
import gfx.Renderer;
import gfx.Window;
import gfx.WindowType;

public class Engine implements Runnable {
    
    
    private static Engine s_Singleton;

    private float m_DeltaTime = 0;
    private long m_LastTimeMS = 0;
    private boolean m_Running = false;

    private Window m_Window;
    private Thread m_Thread;

    Player m_Player;
    ArrayList<Enemy> m_Enemies;

    private Engine() {
        
    }

    public static void init()
    {
        s_Singleton = new Engine();
    }

    public void start(WindowType windowType) throws InstantiationException {
        m_Running = true;
        m_Window = Window.create(windowType);
        m_Window.init();
        Renderer.init(m_Window);

        m_Player = new Player();
        m_Enemies = new ArrayList<>();
        m_Enemies.add(new Enemy());

        m_Thread = new Thread(this);
        m_Thread.start();
    }

    public static Engine get()
    {
        return s_Singleton;
    }

    public void update(float delta)
    {
        m_DeltaTime = delta;

        /*
        m_Player.update();
        for(Enemy e : m_Enemies)
        {
            e.update();
        }
        */

        // System.out.println(delta);
    }

    public void render()
    {
        Renderer.get().clear();

        m_Player.render();

        m_Window.display();
    }

    public float getDeltaTime()
    {
        return m_DeltaTime;
    }

    public static void quit()
    {
        // somehow delete s_Singleton;
    }

    @Override
    public void run() {
        final float MILLIS_IN_SECOND = 1000.f;

        while(m_Running) {
            long currentTime = System.currentTimeMillis();
            long deltaMS = currentTime - m_LastTimeMS;
            float delta = deltaMS / MILLIS_IN_SECOND;

            update(delta);
            render();

            m_LastTimeMS = currentTime;
        }
    }
}