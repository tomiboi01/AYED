package prac3;
import prac1.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>> (); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>>  children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>>  getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>>  children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) 
		children.remove(child);
	}

	public void PorNiveles(){
		GeneralTree<T> arb = null;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>(); 
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty())
		{
			arb = cola.dequeue();
			if (arb != null){
				System.out.print(arb.getData() + " ");
				for(GeneralTree<T> c : arb.getChildren()){
					cola.enqueue(c);
				}
			}
			else 
				if (!cola.isEmpty())
				{
					cola.enqueue(null);
					System.out.println("");
				}

		}
	}

	public boolean esAncestro(T a, T b){
		GeneralTree<T> nodo = buscarDato(a);
		if (nodo != null && nodo.buscarDato(b) != null)
       		return true;
		return false;
	}

	private GeneralTree<T> buscarDato(T a){
		if (getData().equals(a))
			return this;
		GeneralTree<T> aux = null;
		Iterator<GeneralTree<T>> ite = children.iterator();
		while(ite.hasNext() && aux == null)
		{
			aux = buscarDato(ite.next().getData());
		}
		return aux;
	
	}


	public int altura()
	{
		if (isLeaf())
			return 0;
		return alturaRec();
	}
	private int alturaRec(){
		int aux = 0;
		int max = 0;
		for(GeneralTree<T> child : getChildren())
		{
			if (!child.isLeaf())
			{
				aux = child.alturaRec();
				if (aux > max)
					max = aux;
			}
		}
		return max+1;
	}

	public int nivel (T dato){
		if (isEmpty())
			return -1;
		return nivel(dato,0);
	}
	private int nivel (T dato, int nivel)
	{
		if (getData() == dato)
			return nivel;
		int niv = -1;
		if (hasChildren())
			{
				Iterator<GeneralTree<T>> ite = children.iterator();
				while (ite.hasNext() && niv == -1)
					niv = ite.next().nivel(dato, nivel+1);
			}
		return niv;
	}

	public int ancho()
	{

		int max = 1;
		GeneralTree<T> arb = null;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty())
		{
			arb = cola.dequeue();
			if (arb != null)
			{;
				for(GeneralTree<T> c : arb.getChildren())
					cola.enqueue(c);
			}
			else
			{

				if (!cola.isEmpty())
				{
					if (cola.size() > max)
						max = cola.size();
					cola.enqueue(null);
				}
			}

		}
		return max;
	}





}