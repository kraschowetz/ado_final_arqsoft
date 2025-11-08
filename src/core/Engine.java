package core;

import gfx.Window;
import gfx.WindowType;

public class Engine implements Runnable {
    
    
    private static Engine s_Singleton;

    private float m_DeltaTime = 0;
    private long m_LastTimeMS = 0;
    private boolean m_Running = false;

    private Window m_Window;
    private Thread thread;

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

        thread = new Thread(this);
        thread.start();
    }

    public static Engine get()
    {
        return s_Singleton;
    }

    public void update(float delta)
    {
        m_DeltaTime = delta;
        System.out.println(delta);
    }

    public void render()
    {

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

            m_LastTimeMS = currentTime;
        }
    }
}