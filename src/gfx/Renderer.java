package gfx;

import java.awt.Color;
import java.awt.Graphics2D;

import entity.Enemy;
import entity.Player;

// classe renderer, facade usado para simplificar as chamadas para desenhar componentes na janela do jogo
// implementa os padrões facade e singleton
public class Renderer {
    
    private static Renderer s_Singleton;

    // referencia para o componente usado para desenhar os componentes
    private Graphics2D m_Graphics = null;

    // tamanho da janela
    private int m_WindowWidth = 0;
    private int m_WindowHeight = 0;

    // popula as variaves do Renderer com base em uma instância da interface Window
    private Renderer(Window window) {
        m_Graphics = window.getGraphics();
        m_WindowHeight = window.getHeight();
        m_WindowWidth = window.getWidth();
    }

    public static Renderer get()
    {
        return s_Singleton;
    }

    // inicializa o singleton
    public static void init(Window window)
    {
        s_Singleton = new Renderer(window);
    }

    // atualiza qual instância da classe Graphics2D deve ser usada
    // o Graphics2D a ser usado muda sempre que o método Window.display() é chamado
    public static void refresh(Window window)
    {
        s_Singleton.m_Graphics = window.getGraphics();
    }

    // limpa a tela, deixando-a toda preta
    public void clear() {
        // define a que a cor preta vai ser usada
        m_Graphics.setColor(Color.BLACK);
        // preenche um retangulo do tamanho da tela com a cor selecionada
        m_Graphics.fillRect(0, 0, m_WindowWidth, m_WindowHeight);
    }

    // desenha uma instância da classe Player na tela
    public void drawPlayer(Player player) {
        // define a que a cor azul vai ser usada
        m_Graphics.setColor(Color.BLUE);
        // preenche um retangulo de 32x32 pixels na posição do player
        m_Graphics.fillRect(player.getXPosition(), player.getYPosition(), 32, 32);
    }

    // desenha uma instância da classe Enemy na tela
    public void drawEnemy(Enemy enemy) {
        // define a que a cor vermelho vai ser usada
        m_Graphics.setColor(Color.RED);
        // preenche um retangulo de 32x32 pixels na posição do player
        m_Graphics.fillRect(enemy.getXPosition(), enemy.getYPosition(), 32, 32);
    }
}
