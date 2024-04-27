package prac3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import prac1.Queue;

public class ParcialArboles {
	
	private static class Aux{
		int suma = 0;
		List<Integer> camino = new LinkedList<Integer>();
	
		public Aux(int suma) {
			this.suma = suma;
		}

		public int getSuma() {
			return suma;
		}
		
		public List<Integer> getCamino() {
			return camino;
		}

		public void actualizar(int suma, LinkedList<Integer> camino) {
			this.suma = suma;
			this.camino.clear();
			this.camino.addAll(camino);
		}
		
	}
	
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if (arbol != null)
			return esDeSeleccionRet(arbol);
		else return false;
		
	}
	private static boolean esDeSeleccionRet (GeneralTree<Integer> arbol) {
		if (arbol.isLeaf())
			return true;
		int min = Integer.MAX_VALUE;
		boolean aux = true;
		Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
		GeneralTree<Integer> child;
		while (it.hasNext() && aux)
		{
			child = it.next();
			if (child.getData() < min)
				min = child.getData();
			if (min < arbol.getData())
				return false;
			aux &= esDeSeleccionRet(child);
			
		}
		return aux && (arbol.getData() == min);
		
	}

	public static List<Integer> resolverBinario (GeneralTree<Integer> arbol)
	{
		Aux aux =  new Aux(0);
		if (arbol != null && !arbol.isEmpty())
			resolverBinario(arbol, 0, new LinkedList<Integer>(), 0, aux);
		return aux.getCamino();
	}
	
	
	private static void resolverBinario(GeneralTree<Integer> arbol, int nivel, List<Integer> actual, int suma, Aux max)
	{
		if (arbol.getData()==1)
		{
			actual.add(1);
			suma += 1 * nivel;
		}
		if ((arbol.isLeaf() && suma > max.getSuma()))
				max.actualizar(suma, new LinkedList<Integer>(actual));
		
		for(GeneralTree<Integer> child: arbol.getChildren())
		{
			resolverBinario(child, nivel + 1, actual, suma, max);
			
		}
		if (arbol.getData()==1)
		{
			actual.remove(actual.size()-1);
			suma -= 1 * nivel;
		}
	}
	
	public static boolean resolver(GeneralTree<Integer> arbol) {
		if (arbol == null)
			return false;
		
	
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> arb;
		cola.enqueue(arbol);
		cola.enqueue(null);
		int numeroNodos = 1;
		boolean aux = true;
		while (!cola.isEmpty() && aux)
		{
			arb = cola.dequeue();
			if (arb != null)
			{
				for(GeneralTree<Integer> child:arb.getChildren())
					cola.enqueue(child);
			}
			else 
				if (!cola.isEmpty())
					if (cola.size() != ++numeroNodos)
						aux = false;
					else
						cola.enqueue(null);
			
		}
		return aux;
	
	}
	
	
}
