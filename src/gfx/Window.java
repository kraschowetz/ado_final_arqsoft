package gfx;

import java.awt.Graphics2D;

// representa uma janela que pode desenhar componentes do jogo
// implementa o design-pattern factory method
public interface Window {
    
    // método de fábrica, com base no tipo desejado, cria uma insância de Window adequada
    public static Window create(WindowType type) throws InstantiationException
    {
        switch (type) {
            case DESKTOP_WINDOW:
                return new DesktopWindow();
            
            case WIDESCREEN_WINDOW:
                return new WidescreenWindow();

            case MOBILE_WINDOW:
                    return new MobileWindow();

            default:
                throw new InstantiationException("Unknown Window Type!");
        }
    }

    // exibe a janela ao usuário
    public void display();
    // inicializa a janela
    public void init();
    // acessa o componente responsável por desenhar os componentes na tela
    public Graphics2D getGraphics();

    public int getWidth();
    public int getHeight();

}
