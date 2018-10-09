/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rick
 * @param <T> _ data type for all nodes
 */
public class Dirigido <T extends Comparable>
{
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
    
    public Vertice<T> searchNode(String complete_name)
    {
        for (Vertice<T> node : nodes)
        {
            if(node.toString().equals(complete_name)) return node;
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
    
    public ArrayList<Vertice> getFloyd(Vertice a, Vertice b)
    {
        floyd(); // armamos la matriz de adyacencias y de caminos
        
        for (int i = 0; i < nodes.size(); i++)
        {
            for (int j = 0; j < nodes.size(); j++)
            {
                System.out.print(adyacencias[i][j]+" ");
            }
            System.out.println("");
        }
        
        for (int i = 0; i < nodes.size(); i++)
        {
            for (int j = 0; j < nodes.size(); j++)
            {
                System.out.print(caminos[i][j]+" ");
            }
            System.out.println("");
        }
        
        
        System.out.println("vertices "+a+" "+b);
        
        int ia=nodes.indexOf(a),ib=nodes.indexOf(b),sumatoria=0;
        ArrayList<Vertice> camino_minimo = new ArrayList<>();
        camino_minimo.add(a);
        boolean terminado=false;
        Vertice actVert;
        
        while(!terminado)
        {
            System.out.println(ia+" "+ib);
            actVert = searchNode(caminos[ia][ib]);
            System.out.println(actVert);
            camino_minimo.add(actVert);
                System.out.println("sumatoria "+sumatoria);
            sumatoria+=adyacencias[ia][ib];
            ib=nodes.indexOf(actVert);
            terminado=b.equals(actVert);
        }
        
        JOptionPane.showMessageDialog(null, "El mínimo costo es de: "+sumatoria+"\nel camino mínimo es:\n"+camino_minimo);
        return camino_minimo;
    }
    
    public void floyd()
    {
        int ady;
        adyacencias = new int[nodes.size()][nodes.size()];
        caminos = new int[nodes.size()][nodes.size()];
        
        for (int i = 0; i < nodes.size(); i++)
        {
            for (int j = 0; j < nodes.size(); j++)
            {
                caminos[i][j] = nodes.get(j).id;
            }
        }
        
        for (int i = 0; i < nodes.size(); i++)
        {
            for (int j = 0; j < nodes.size(); j++)
            {
                adyacencias[i][j] = 999999999;
            }
            adyacencias[i][i]=0;
        }
        
        for (Arco connection : connections)
        {
            //adyacencias[nodes.indexOf(connection.getStart_point())][nodes.indexOf(connection.getStart_point())]=connection.getWeight();
            adyacencias[nodes.indexOf(connection.getEnd_point())][nodes.indexOf(connection.getStart_point())]=connection.getWeight();
        }
        
        for (int k = 0; k < nodes.size(); k++)
        {
            for (int i = 0; i < nodes.size(); i++)
            {
                for (int j = 0; j < nodes.size(); j++)
                {
                    ady=adyacencias[i][j];
                    adyacencias[i][j]=Math.min(adyacencias[i][j],adyacencias[i][k]+adyacencias[k][j]);
                    if(adyacencias[i][j]<ady)
                    {
                        caminos[i][j] = nodes.get(k).id;
                    }
                }
            }
        }
        
        
    }
    
    int[][] adyacencias,caminos;
    
    protected java.util.ArrayList<Vertice<T>> nodes;
    protected java.util.ArrayList<Arco> connections;
    
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
    
}
