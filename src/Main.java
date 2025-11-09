import core.Engine;
import gfx.WindowType;

public class Main {
    public static void main(String[] args) {
        Engine.init();
        
        try {
            Engine.get().start(WindowType.DESKTOP_WINDOW);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        int a = 0;
    }
}
