package gfx;

import java.awt.Graphics2D;

public interface Window {
    
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
                throw new InstantiationException("Unknown Canvas Type!");
        }
    }

    public void display();
    public void init();
    public Graphics2D getGraphics();
    public void requestFocus();
    public int getWidth();
    public int getHeight();

}
