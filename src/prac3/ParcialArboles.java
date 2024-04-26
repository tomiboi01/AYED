package ayuda;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {
	
	private static class Aux{
		int suma = 0;
		LinkedList<Integer> camino = new LinkedList<Integer>();
		public Aux(int suma, LinkedList<Integer> camino) {
			super();
			this.suma = suma;
			this.camino = camino;
		}
		public int getSuma() {
			return suma;
		}
		
		public List<Integer> getCamino() {
			return camino;
		}
		public void setSuma(int suma) {
			this.suma = suma;
		}
		public void setCamino(LinkedList<Integer> camino) {
			this.camino = camino;
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
		List<Integer> lista = new LinkedList<Integer>();
		if (arbol != null && !arbol.isEmpty())
			lista = resolverBinario(arbol, 0).getCamino();
		return lista;
	}
	
	
	private static Aux resolverBinario(GeneralTree<Integer> arbol, int nivel)
	{
		LinkedList<Integer> camino = new LinkedList<Integer>();
		
		if (arbol.getData()!= 0)
			camino.add(arbol.getData());
		
		if (arbol.isLeaf())
			return new Aux(arbol.getData() * nivel, camino);
		
		Aux aux;
		Aux max = new Aux(Integer.MIN_VALUE, camino);
		
		List<GeneralTree<Integer>> hijos = arbol.getChildren();
		for(GeneralTree<Integer> child:hijos) {
			aux = resolverBinario(child, nivel+1);
			if (aux.getSuma() > max.getSuma())
				max = aux;
		}
		max.getCamino().addAll(0, camino);
		max.setSuma(max.getSuma()+arbol.getData()*nivel);
		return max;
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
