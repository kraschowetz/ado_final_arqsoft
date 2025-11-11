package entity;

import gfx.Renderer;

public class Player extends Entity {

    @Override
    public void update() {
        m_Position[0] = 128;
    }

    @Override
    public void render() {
        Renderer.get().drawPlayer(this);
    }
    
}
