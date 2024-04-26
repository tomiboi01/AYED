package prac3;

import java.util.LinkedList;
import java.util.List;
import prac1.Queue;
import java.util.Iterator;


public class RecorridosAG {


    public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> lista = new LinkedList<Integer>();
        if (a != null && !a.isEmpty())
            numerosImparesMayoresQuePreOrden(a, n, lista);
        return lista;
    }

    private static void numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n, List<Integer> list){
        if (a.getData() % 2 == 1 && a.getData() > n)
            list.add(a.getData());
        for(GeneralTree<Integer> child : a.getChildren())
            numerosImparesMayoresQuePreOrden(child, n, list);

    }


    // public static List<Integer> numerosImparesMayoresQuePreOrden2 (GeneralTree <Integer> a, Integer n){
    //     List<Integer> lista = new LinkedList<Integer>();

    //     if (a.getData() % 2 == 1 && a.getData() > n)
    //         lista.add(a.getData());

    //     for(GeneralTree<Integer> child : a.getChildren())
    //         lista.addAll(numerosImparesMayoresQuePreOrden2(child, n));
    //     return lista;
    // }
    public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
        List<Integer> lista = new LinkedList<Integer>();
        if (a != null && !a.isEmpty())
            lista = numerosImparesMayoresQueInOrdenRec(a, n);
        return lista;
    }
    private static List<Integer> numerosImparesMayoresQueInOrdenRec (GeneralTree <Integer> a, Integer n){
        LinkedList<Integer> numeros = new LinkedList<Integer>();

        Iterator<GeneralTree<Integer>> ite = a.getChildren().iterator();
        if (ite.hasNext())
            numeros.addAll(numerosImparesMayoresQueInOrden(ite.next(), n));
        if (a.getData() % 2 == 1 && a.getData() > n)
            numeros.add(a.getData());
        while (ite.hasNext())
            numeros.addAll(numerosImparesMayoresQueInOrden(ite.next(), n));
        return numeros;
    }

    public static List<Integer> numerosImparesMayoresQuePosOrden (GeneralTree <Integer> a, Integer n){
        LinkedList<Integer> numeros = new LinkedList<Integer>();
        Iterator<GeneralTree<Integer>> ite = a.getChildren().iterator();
        while (ite.hasNext())
            numeros.addAll(numerosImparesMayoresQuePosOrden(ite.next(), n));
        if (a.getData() % 2 == 1 && a.getData() > n)
            numeros.add(a.getData());
        return numeros;
    }
    public static List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		 if (a == null || a.isEmpty())
             return new LinkedList<Integer>();

        GeneralTree<Integer> arb = null;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>(); 
        LinkedList<Integer> numeros = new LinkedList<Integer>();
		cola.enqueue(a);
		while (!cola.isEmpty())
		{
			arb = cola.dequeue();
            if (arb.getData() % 2 == 1 && arb.getData() > n)
                numeros.add(arb.getData());
            for(GeneralTree<Integer> c : arb.getChildren()){
                cola.enqueue(c);
            }
			
		}
        return numeros;
	}
    
}
