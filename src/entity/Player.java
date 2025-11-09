package entity;

import gfx.Renderer;

public class Player extends Entity {

    @Override
    public void update() {
    }

    @Override
    public void render() {
        Renderer.get().drawPlayer(this);
    }
    
}
