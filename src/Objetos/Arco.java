/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author rick
 */
public class Arco 
{

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Arco(Vertice start_point, Vertice end_point,int peso)
    {
        this.start_point = start_point;
        this.end_point = end_point;
        this.start_graphic= start_point.getCenter();
        this.end_graphic = end_point.getCenter();
        this.graph=(start_point.getGraph());
        this.weight=peso;
    }

    public Arco(Vertice start_point, Vertice end_point, int weight, String name)
    {
        this(start_point,end_point,weight);
        this.name = name;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="DEFAULT METHODS">
    
    @Override
    public String toString()
    {
        return this.start_point+"-"+this.end_point;
    }
    
    @Override
    public boolean equals(Object ob)
    {
        if(!(ob instanceof Arco))return false;
        return 
            this.start_point.equals(((Arco)ob).start_point) && this.end_point.equals(((Arco)ob).end_point)
            ||this.start_point.equals(((Arco)ob).end_point) && this.end_point.equals(((Arco)ob).start_point);    
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ATRBUTOS">
    private Vertice    start_point,    //Nodo punto de salida
                    end_point;      //Nodo punto de llegada
    private int weight;             //peso o valor de la arista
    private String  name;           //en caso de nesesitar un identificador
    private Dirigido graph;
    private Point   start_graphic,
                    end_graphic;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GT & ST">
    public Vertice getStart_point()
    {
        return start_point;
    }

    public void setStart_point(Vertice start_point)
    {
        this.start_point = start_point;
    }

    public Vertice getEnd_point()
    {
        return end_point;
    }

    public void setEnd_point(Vertice end_point)
    {
        this.end_point = end_point;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public Dirigido getGraph()
    {
        return graph;
    }

    public void setGraph(Dirigido graph)
    {
        this.graph = graph;
    }
    
    public Point getStart_graphic()
    {
        return start_graphic;
    }

    public void setStart_graphic(Point start_graphic)
    {
        this.start_graphic = start_graphic;
    }

    public Point getEnd_graphic()
    {
        return end_graphic;
    }

    public void setEnd_graphic(Point end_graphic)
    {
        this.end_graphic = end_graphic;
    }

    //</editor-fold>

    
}
