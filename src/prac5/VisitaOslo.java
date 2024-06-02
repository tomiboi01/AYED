package prac5;

import java.util.ArrayList;
import java.util.List;

public class VisitaOslo {

    public static List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos)
    {
        Vertex<String> v = lugares.search("Ayuntamiento");
        if (v == null)
            return new ArrayList<String>();
        List<String> camino = new ArrayList<String>();
        boolean[] visitados = new boolean[lugares.getSize()];
        paseoEnBici(lugares,v, destino, maxTiempo, maxTiempo, lugaresRestringidos, visitados, camino);
        return camino;
    }

    private static boolean paseoEnBici(Graph<String> lugares,Vertex<String> v, String destino,int tiempoActual,int maxTiempo,  List<String> lugaresRestringidos, boolean[] visitados, List<String> camino)
    {
        camino.add(v.getData());
        visitados[v.getPosition()] = true;
        if (v.getData().equals(destino))
            return true;
        for (Edge<String> e : lugares.getEdges(v))
            if (!visitados[e.getTarget().getPosition()] && !lugaresRestringidos.contains(e.getTarget().getData()) && e.getWeight() < tiempoActual  && paseoEnBici(lugares,e.getTarget(), destino,  maxTiempo - e.getWeight(), maxTiempo,lugaresRestringidos, visitados, camino))
                return true;
        
        camino.remove(camino.size() - 1);
        visitados[v.getPosition()] = false;
        return false;
    }
    
}
