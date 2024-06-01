package prac5;

import prac5.adjList.AdjListGraph;
import prac5.ejer2.Recorridos;

public class Program {
    public static void main(String[] args) {
        


        AdjListGraph<Integer> grafo = new AdjListGraph<Integer>();
            // Grafo inicial
            // (2)  <-->  (1)  --> (3)
            Vertex<Integer> vert1 = grafo.createVertex(1);
            Vertex<Integer> vert2 = grafo.createVertex(2);
            Vertex<Integer> vert3 = grafo.createVertex(3);
            grafo.connect(vert1, vert2);
            grafo.connect(vert1, vert3);
            grafo.connect(vert2, vert1);
            for(Integer d : new Recorridos<Integer>().dfs(grafo))
                System.out.println(d);
        }
}
