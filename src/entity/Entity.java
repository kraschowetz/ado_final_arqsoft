package entity;

// representa uma entidade com posição, pode ter atualizações lógicas e ser desenhada na tela
public abstract class Entity {

    public Entity() {}

    // representa a posição x e y, de uma forma simplificada
    protected float m_Position[] = {0, 0};

    public abstract void update();
    public abstract void render();

    public int getXPosition()
    {
        return (int)m_Position[0];
    }

    public int getYPosition()
    {
        return (int)m_Position[1];
    }
}
