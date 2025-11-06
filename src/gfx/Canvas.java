package gfx;

public interface Canvas {
    
    public static Canvas create(CanvasType type) throws InstantiationException
    {
        switch (type) {
            case DESKTOP_CANVAS:
                return null;
            
            case WIDESCREEN_CANVAS:
                return null;

            case MOBILE_CANVAS:
                return null;

            default:
                throw new InstantiationException("Unknown Canvas Type!");
        }
    }

    public void display();

}
