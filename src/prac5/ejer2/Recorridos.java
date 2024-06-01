package prac5.ejer2;

import java.util.ArrayList;
import java.util.List;

import prac5.Edge;
import prac5.Graph;
import prac5.Vertex;
import prac1.Queue;

public class Recorridos<T> {


    public List<T> dfs(Graph<T> grafo){
        if (grafo != null && !grafo.isEmpty())
        {
            boolean[] usado = new boolean[grafo.getSize()];
            ArrayList<T> ret = new ArrayList<T>();
            for (Vertex<T> v : grafo.getVertices())
                if (!usado[v.getPosition()])
                {
                    dfsprivado(usado, ret, v, grafo);
                }

            return ret;
        }
        return new ArrayList<T>();

        
    } 

    private void dfsprivado (boolean[] usado, List<T> ret, Vertex<T> v, Graph<T> g)
    {
        
        ret.add(v.getData());
        usado[v.getPosition()] = true;
        for (Edge<T> edge : g.getEdges(v))
            if (!usado[edge.getTarget().getPosition()])
                dfsprivado(usado, ret, edge.getTarget(), g);
    

    }

    public List<T> bfs (Graph<T> grafo)
    {
        Queue<Vertex<T>> cola;
        boolean[] usado = new boolean[grafo.getSize()];
        ArrayList<T> ret = new ArrayList<T>()
        for (Vertex<T> v : grafo.getVertices())
        {
            cola = new Queue<Vertex<T>>();
            if (!usado[v.getPosition()])
            {
                usado[v.getPosition()] = true;
                cola.enqueue(v);
                Vertex<T> aux;
                while(!cola.isEmpty())
                {
                    aux = cola.dequeue();
                    ret.add(aux.getData());
                    for (Edge<T> edge : grafo.getEdges(aux))
                        if (!usado[edge.getTarget().getPosition()])
                            cola.enqueue(edge.getTarget());
                }
            }
        }
        return ret;
    }
        
}

