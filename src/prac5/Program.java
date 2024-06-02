package prac5;

import java.util.ArrayList;
import java.util.List;

import prac5.adjList.AdjListGraph;

public class Program {
    public static void main(String[] args) {
        Graph<String> grafo = cargarGrafoCiudades();
        Mapa map = new Mapa(grafo);
        List<String> ciudades = new ArrayList<String>();
        ciudades.add("Barcelona");
        for(String ciudad :  map.caminoMasCortoRec("Madrid","Malaga"))
            System.out.print(ciudad + " ----> ");
    }




    public static Graph<String> cargarGrafoCiudades()
    {
        Graph<String> grafo = new AdjListGraph<>();
        grafo.createVertex("Madrid");
        grafo.createVertex("Barcelona");
        grafo.createVertex("Valencia");
        grafo.createVertex("Sevilla");
        grafo.createVertex("Zaragoza");
        grafo.createVertex("Malaga");
        Vertex<String> v0 = grafo.getVertex(0);
        Vertex<String> v1 = grafo.getVertex(1);
        Vertex<String> v2 = grafo.getVertex(2);
        Vertex<String> v3 = grafo.getVertex(3);
        Vertex<String> v4 = grafo.getVertex(4);
        Vertex<String> v5 = grafo.getVertex(5);
        grafo.connect(v0, v1, 10);
        grafo.connect(v0, v2, 20);
        grafo.connect(v0, v3, 30);
        grafo.connect(v1, v3, 40);
        grafo.connect(v1, v0, 10);
        grafo.connect(v2, v0, 20);
        grafo.connect(v3, v5, 1);
        grafo.connect(v3, v1, 40);
        grafo.connect(v3, v0, 30);
        grafo.connect(v3, v4, 5);
        grafo.connect(v4, v3, 5);
        grafo.connect(v4, v5, 10);
        grafo.connect(v5, v4, 10);
        return grafo;
    }
}
