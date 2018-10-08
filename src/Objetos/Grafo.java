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
public class Grafo <T extends Comparable> extends Dirigido
{

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORES">
    public Grafo(){super();} 

    public Grafo(ArrayList nodes, ArrayList connections) {super(nodes, connections);}
    
    public Grafo(Vertice... n){super(n);}
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="DEFAULT METHODS">
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return new Grafo((ArrayList)(this.nodes.clone()),(ArrayList)(this.connections.clone()));
    }
    
    //</editor-fold>
    
    
    
}
