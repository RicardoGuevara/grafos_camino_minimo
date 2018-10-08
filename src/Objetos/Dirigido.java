/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author rick
 * @param <T> _ data type for all nodes
 */
public class Dirigido <T extends Comparable>
{
    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Dirigido(ArrayList<Vertice<T>> nodes, ArrayList<Arco> connections) 
    {
        this.nodes = nodes;
        this.connections = connections;
    }

    public Dirigido() 
    {
        nodes = new ArrayList<>();
        connections = new ArrayList();
    }
    
    public Dirigido(Vertice... n)
    {
        nodes = new ArrayList<>();
        connections = new ArrayList();
        for (Vertice node : n) 
        {
            nodes.add(node);
        }
    }
    
    //</editor-fold>´
    
    //<editor-fold defaultstate="collapsed" desc="DEFAULT METHODS">

    @Override
    public String toString()
    {
        return "___________________________\nGrafo:\ndata type: "
                +this.getClass().getCanonicalName()+"\nNodes: "
                +this.nodes+"\nConnections: "
                +this.connections
                +"\n___________________________\n";
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return new Dirigido((ArrayList)(this.nodes.clone()),(ArrayList)(this.connections.clone()));
    }
    
    //</editor-fold>
    
    public void add(Vertice<T>... n)
    {
    for (Vertice node : n) {
    this.nodes.add(node);
    node.setGraph(this);
    }
    }
    
    public void add(Arco... c)
    {
        for (Arco connection : c) {
            this.connections.add(connection);
            connection.getStart_point().getConnections().add(c);
            connection.getEnd_point().getConnections().add(c);
            connection.setGraph(this);
        }
    }
    
    public Vertice<T> getNodeAt(java.awt.Point p)
    {
        for (Vertice<T> node : nodes)
        {
            if(node.getSpace().contains(p)) return node;
        }
        return null;
    }
    
    public Vertice<T> searchNode(int id)
    {
        for (Vertice<T> node : nodes)
        {
            if(node.id == id) return node;
        }
        return null;
    }
    
    public void del(Vertice<T> node)
    {
        this.nodes.remove(node);
        /*ArrayList<Connection> c = node.getConnections();
        c.forEach((connection) ->
        {
        this.connections.remove(connection);
        });*/
        ArrayList<Arco> con = new ArrayList<>();
        for (Arco connection : connections)
        {
            if(connection.getStart_point().equals(node)||connection.getEnd_point().equals(node)) con.add(connection);
        }
        connections.removeAll(con);
        System.out.println(this);
    }
    
    //<editor-fold defaultstate="collapsed" desc="ATRBUTOS">
    protected java.util.ArrayList<Vertice<T>> nodes;
    protected java.util.ArrayList<Arco> connections;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GT & ST">
    public ArrayList<Vertice<T>> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Vertice<T>> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Arco> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Arco> connections) {
        this.connections = connections;
    }
    //</editor-fold>    
}
