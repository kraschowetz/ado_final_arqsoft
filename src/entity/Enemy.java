package entity;

import gfx.Renderer;

public class Enemy extends Entity {

    @Override
    public void update() {
    }

    @Override
    public void render() {
        Renderer.get().drawEnemy(this);
    }
    
}
