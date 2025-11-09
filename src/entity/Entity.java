package entity;

public abstract class Entity {

    public Entity() {}

    private int m_Position[] = {0, 0};

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
