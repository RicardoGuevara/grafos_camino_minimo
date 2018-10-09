/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author rick
 * @param <T> _ cntent data type (must being comparable)
 */
public class Vertice <T extends Comparable>
{

    public Vertice(T data)
    {
        this.data = data;
        this.id= actid;
        actid++;
        connections = new ArrayList<Arco>();
    }

    public Vertice(T data, Point location, Rectangle space)
    {
        this(data);
        this.location = location;
        this.space = space;
    }
    
    public Vertice(Point location, T data)
    {
        this(data,grafos.Grafos.grafo,location,new Rectangle(location.x,location.y,diameter,diameter));
    }

    public Vertice(T data, Dirigido graph, Point location, Rectangle space)
    {
        this(data,location,space);
        this.graph = graph;
        //graph.add(this);
    }

    public Vertice(T data, Dirigido graph, ArrayList<Arco> connections, Point location, Rectangle space)
    {
        this.data = data;
        this.graph = graph;
        this.connections = connections;
        this.location = location;
        this.space = space;
    }
    
    @Override
    public boolean equals(Object ob)
    {
        if(!(ob instanceof Vertice)) return false;
        return this.id == ((Vertice)ob).id;
    }
    
    @Override
    public String toString()
    {
        return this.data+" "+this.id;
    }
    private T data;
    private Dirigido graph;
    private java.util.ArrayList<Arco> connections;
    private Point location;
    private Rectangle space;
    public int id;
    private static int actid = 0;
    public static int diameter = 50;
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ArrayList<Arco> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Arco> connections) {
        this.connections = connections;
    }
    
    public Dirigido getGraph()
    {
        return graph;
    }

    public void setGraph(Dirigido graph)
    {
        this.graph = graph;
    }
    
    public Point getLocation()
    {
        return location;
    }

    public void setLocation(Point location)
    {
        this.location = location;
    }

    public Rectangle getSpace()
    {
        return space;
    }

    public void setSpace(Rectangle space)
    {
        this.space = space;
    }
    
    public Point getCenter()
    {
        return new Point(this.location.x+diameter/2,this.location.y+diameter/2);
    }
    
    
    
}
