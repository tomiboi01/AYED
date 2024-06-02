package prac5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import prac5.adjList.AdjListGraph;

public class Mapa 
{
    private Graph<String> mapaCiudades = new AdjListGraph<>();

    public Mapa(Graph<String> grafo)
    {
        this.mapaCiudades = grafo;
    }

    public List<String> devolverCamino(String ciudad1, String ciudad2)
    {
        Vertex<String> verticeC1 = mapaCiudades.search(ciudad1);
        if (verticeC1 == null)
            return new ArrayList<String>();
        List<String> camino = new ArrayList<String>();
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        devolverCamino(ciudad2,verticeC1, visitados, camino);
        return camino;


    }

    private boolean devolverCamino(String ciudad2, Vertex<String> verticeC1, boolean[] visitados, List<String> camino)
    {
        camino.add(verticeC1.getData());
        if (verticeC1.getData().equals(ciudad2))
            return true;
        int pos = verticeC1.getPosition();
        visitados[pos] = true;
        for (Edge<String> e : mapaCiudades.getEdges(verticeC1))
            if (!visitados[e.getTarget().getPosition()] && devolverCamino(ciudad2, e.getTarget(), visitados, camino))
                    return true;
        camino.remove(camino.size() - 1);
        return false;
    }

    public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
        Vertex<String> verticeC1 = mapaCiudades.search(ciudad1);
        if (verticeC1 == null )
            return new ArrayList<String>();;
        List<String> camino = new ArrayList<String>();
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        devolverCaminoExceptuando(ciudad2,verticeC1, visitados, camino, ciudades);
        return new ArrayList<String>(camino);


    }

    private boolean devolverCaminoExceptuando (String ciudad2, Vertex<String> verticeC1, boolean[] visitados, List<String> camino, List<String> ciudades)
    {
        camino.add(verticeC1.getData());
        if (verticeC1.getData().equals(ciudad2))
            return true;
        int pos = verticeC1.getPosition();
        visitados[pos] = true;
        for (Edge<String> e : mapaCiudades.getEdges(verticeC1))
            if (!visitados[e.getTarget().getPosition()] && !ciudades.contains(e.getTarget().getData()) &&  devolverCaminoExceptuando(ciudad2, e.getTarget(), visitados, camino, ciudades))
                    return true;
        camino.remove(camino.size() - 1);
        return false;
    }

    
    public List<String> caminoMasCortoRec(String ciudad1, String ciudad2)
    {
        Vertex<String> verticeC1 = mapaCiudades.search(ciudad1);
        if (verticeC1 == null)
            return new ArrayList<String>();
        List<String> caminoMin = new ArrayList<String>();
        List<String> caminoActual = new ArrayList<String>();
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        caminoMasCortoRec(ciudad2, verticeC1, visitados, caminoMin, caminoActual, Integer.MAX_VALUE, 0);
        return caminoMin;
    }

    private int caminoMasCortoRec(String ciudad2, Vertex<String> verticeC1, boolean[] visitados,List<String> listaMin, List<String> camino, int min, int distanciaActual)
    {
        camino.add(verticeC1.getData());
        visitados[verticeC1.getPosition()] = true;
        if (verticeC1.getData().equals(ciudad2) && distanciaActual < min)
        {
                listaMin.clear();
                listaMin.addAll(camino);
                min = distanciaActual;
        }
        else
        for (Edge<String> e : mapaCiudades.getEdges(verticeC1))
            if (!visitados[e.getTarget().getPosition()])
            {
                min = caminoMasCortoRec(ciudad2, e.getTarget(), visitados, listaMin, camino, min, distanciaActual + 1);
            }
        
        camino.remove(camino.size() - 1);
        visitados[verticeC1.getPosition()] = false;
        return min;
    }

    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        Vertex<String> verticeC1 = mapaCiudades.search(ciudad1);
        if (verticeC1 == null )
            return new ArrayList<String>();;
        
        int origen = verticeC1.getPosition();

        int[][] tabla =devolverTabla(mapaCiudades.getSize());
        tabla[origen][0] = 0;
        int menor;
        for (int i= 0; i< mapaCiudades.getSize(); i++)
        {
            menor = menorTabla(tabla);
            tabla[menor][2] = 1;
            for (Edge<String> e : mapaCiudades.getEdges(mapaCiudades.getVertex(menor)))
            {
                if (tabla[e.getTarget().getPosition()][2] == 0 && tabla[menor][0] + e.getWeight() < tabla[e.getTarget().getPosition()][0])
                {
                    tabla[e.getTarget().getPosition()][0] = tabla[menor][0] + e.getWeight();
                    tabla[e.getTarget().getPosition()][1] = menor;
                }
            }
        }
        List<String> camino = new LinkedList<String>();
        int posDestino = mapaCiudades.search(ciudad2).getPosition();
        while(posDestino != origen)
        {
            camino.add(0,mapaCiudades.getVertex(posDestino).getData());
            posDestino = tabla[posDestino][1];
        }
        camino.add(0,ciudad1);

       return camino;
    }

    private int[][] devolverTabla(int vertices)
    {
        int[][] array = new int[vertices][3];
        for (int i = 0; i < vertices; i++)
        {
            array[i][0] = Integer.MAX_VALUE;
            array[i][1] = 0;
            array[i][2] = 0;
        }
        
        return array;
    }

    private int menorTabla(int[][] Tabla)
    {
        int menor = Integer.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < Tabla.length; i++)
        {
            if (Tabla[i][0] < menor && Tabla[i][2] == 0) 
            {
                menor = Tabla[i][0];
                pos = i;
            }
        }
        return pos;
    }


    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto)
    {
        Vertex<String> verticeC1 = mapaCiudades.search(ciudad1);
        if (verticeC1 == null)
            return new ArrayList<String>();
        List<String> camino = new ArrayList<String>();
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        caminoSinCargarCombustible(ciudad2,verticeC1, visitados, camino, tanqueAuto);
        return camino;


    }

    private boolean caminoSinCargarCombustible(String ciudad2, Vertex<String> verticeC1, boolean[] visitados, List<String> camino, int tanqueAuto)
    {
        camino.add(verticeC1.getData());
        visitados[verticeC1.getPosition()] = true;
        if (verticeC1.getData().equals(ciudad2))
            return true;
        for (Edge<String> e : mapaCiudades.getEdges(verticeC1))
        {
            if (!visitados[e.getTarget().getPosition()] && e.getWeight() <= tanqueAuto && caminoSinCargarCombustible(ciudad2, e.getTarget(), visitados, camino, tanqueAuto - e.getWeight()))
                return true;
        }
        camino.remove(camino.size() - 1);
        visitados[verticeC1.getPosition()] = false;
        return false;
    }

    public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto)
    {
        Vertex<String> verticeC1 = mapaCiudades.search(ciudad1);
        if (verticeC1 == null)
            return new ArrayList<String>();
        List<String> camino = new ArrayList<String>();
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        caminoConMenorCargaDeCombustible(ciudad2,verticeC1, visitados, camino, tanqueAuto);
        return camino;

    }

    private boolean caminoConMenorCargaDeCombustible(String ciudad2, Vertex<String> v, boolean[] visitados, List<String> camino, int tanqueAuto)
    {
        camino.add(v.getData());
        visitados[v.getPosition()] = true;
        if (v.getData().equals(ciudad2))
            return true;

        for(Edge<String> e : mapaCiudades.getEdges(v))
            if (!visitados[e.getTarget().getPosition()] && e.getWeight() <= tanqueAuto && caminoConMenorCargaDeCombustible(ciudad2, e.getTarget(), visitados, camino, tanqueAuto - e.getWeight()))
                return true;

        camino.remove(camino.size() - 1);
        visitados[v.getPosition()] = false;
    
        return false;
    }

}