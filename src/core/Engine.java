package core;

import java.util.ArrayList;

import entity.Enemy;
import entity.Player;
import gfx.Renderer;
import gfx.Window;
import gfx.WindowType;

// classe Engine, implementa o design pattern singleton
// lida com o game-loop e mantém propriedade dos elementos do jogo
public class Engine implements Runnable {
    
    private static Engine s_Singleton;

    // tempo, em segundos, desde o ultimo frame (ou atualização lógica)
    private float m_DeltaTime = 0;
    // quando, em milisegundos, que o último frame (ou atualização lógica) aconteceu
    private long m_LastTimeMS = 0;
    // controla o game-loop
    private boolean m_Running = false;

    private Window m_Window;
    private Thread m_Thread;

    Player m_Player;
    ArrayList<Enemy> m_Enemies;

    private Engine() {}

    // inicializa o singleton
    public static void init() {
        s_Singleton = new Engine();
    }

    // inicia os elementos do jogo e a thread do game-loop
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

    public static Engine get() {
        return s_Singleton;
    }

    // atualiza a lógica dos components jogo
    // recebe delta: tempo que se passou desde o ultimo update(), em segundos
    private void update(float delta) {
        m_DeltaTime = delta;

        m_Player.update();
        for(Enemy e : m_Enemies)
        {
            e.update();
        }
    }

    // desenha os componentes do jogo na tela
    private void render() {
        // limpa a tela do jogo
        Renderer.get().clear();

        // renderiza as entidades
        m_Player.render();
        for(Enemy e : m_Enemies)
        {
            e.render();
        }

        // exibe a tela e atualiza o renderer
        m_Window.display();
        Renderer.refresh(m_Window);
    }

    public float getDeltaTime() {
        return m_DeltaTime;
    }

    // no método run é onde aconteçe o game-loop
    @Override
    public void run() {
        final float MILLIS_IN_SECOND = 1000.f;

        // enquanto o jogo está em execução, update() e render() são chamados em loop
        // ao fechar a janela do jogo, este loop é encerrado
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