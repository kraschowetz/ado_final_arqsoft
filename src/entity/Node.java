package entity;

import java.util.ArrayList;

public class Node {

    private ArrayList<Node> m_Children;

    public Node()
    {
        m_Children = new ArrayList<>();
    }

    public void update()
    {
        for (Node child : m_Children)
        {
            child.update();
        }
    }

    public void render()
    {
        for (Node child : m_Children)
        {
            child.render();
        }
    }

}
