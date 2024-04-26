package prac3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EncontrarPrincess {
 
    public static List<Personaje> encontrarPrincesa(GeneralTree<Personaje> arbol) {
    List<Personaje> lista = null;
    if (arbol.getData().esPrincesa() || arbol.getData().esDragon() || arbol.isLeaf()) {
        if (arbol.getData().esPrincesa()) {
            Personaje p = arbol.getData();
            lista=new LinkedList<Personaje>();
            lista.add(0, p);
        }
        return lista;
    }
    
    List<GeneralTree<Personaje>> hijos = arbol.getChildren();
    Iterator<GeneralTree<Personaje>> it = hijos.iterator();
    while (it.hasNext() && lista==null) {
        lista = encontrarPrincesa(it.next());
        if (lista!=null) {
            lista.add(0, arbol.getData());
            break;
        }
    }
    return lista;
    }
   }
   