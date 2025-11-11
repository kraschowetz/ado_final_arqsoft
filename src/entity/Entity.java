package entity;

// representa uma entidade com posição, pode ter atualizações lógicas e ser desenhada na tela
public abstract class Entity {

    public Entity() {}

    // representa a posição x e y, de uma forma simplificada
    protected int m_Position[] = {0, 0};

    public abstract void update();
    public abstract void render();

    public int getXPosition()
    {
        return m_Position[0];
    }

    public int getYPosition()
    {
        return m_Position[1];
    }
}
