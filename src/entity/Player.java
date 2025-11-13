package entity;

import core.Engine;
import gfx.Renderer;

public class Player extends Entity {

    @Override
    public void update() {
        // exemplo de movimento
        m_Position[1] = 32;
        m_Position[0] += .01f;
        if(m_Position[0] > 800)
        {
            m_Position[0] = -32;
        }
    }

    @Override
    public void render() {
        Renderer.get().drawPlayer(this);
    }
    
}
