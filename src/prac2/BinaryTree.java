package prac2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import prac1.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas(){
		if (isLeaf())
			return 1;
		int auxL = 0;
		if (hasLeftChild())
			auxL = getLeftChild().contarHojas();
		int auxR = 0;
		if (hasRightChild())
			auxR = getRightChild().contarHojas();
		return auxL + auxR;
	}
		
		

    public BinaryTree<T> espejo(){
		BinaryTree<T> aux = new BinaryTree<T>();
		aux.setData(getData());
		if (isLeaf())
			return aux;
		if (hasLeftChild())
		{
			aux.addRightChild(leftChild.espejo());
		}
		if (hasRightChild())
		{
			aux.addLeftChild((rightChild.espejo()));
		}
		return aux;
    }


	public void porNiveles(int n, int m) {
		int nivel = 0;
		BinaryTree<T> v = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) 
		{
			v = cola.dequeue();
			if ((v == null) && (!cola.isEmpty()))
			{
				nivel++;
				cola.enqueue(null);
				System.out.println("");
			}
			else
			if ((v != null))
			{
				if (nivel>= n)
					System.out.print(v.getData()+" ");
				if (nivel< m)
				{
					if (v.hasLeftChild())
					cola.enqueue(v.getLeftChild());
				if (v.hasRightChild())
					cola.enqueue(v.getRightChild());
			}
			}
			}

	}

	public void entreNiveles() {

		BinaryTree<T> v = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) 
		{
			v = cola.dequeue();
			if ((v == null) && (!cola.isEmpty()))
			{
				cola.enqueue(null);
				System.out.println("");
			}
			else
			if ((v != null))
			{
				System.out.print(v.getData()+" ");
				if (v.hasLeftChild())
					cola.enqueue(v.getLeftChild());
				if (v.hasRightChild())
					cola.enqueue(v.getRightChild());
			}
		}
}
			


	List<Integer> numerosPares(){
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
		if (getData() != null && ((int) getData() % 2 == 0))
            arreglo.add((int) getData());
		if (hasLeftChild())
        	arreglo.addAll(getLeftChild().numerosPares());
		if (hasRightChild())
			arreglo.addAll(getRightChild().numerosPares());
		return arreglo;
		}


	public boolean isLleno(){
		BinaryTree<T> ab = null;
		
		int cantNodos = 0;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		int nivel = 0;
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()){
			ab = cola.dequeue();
			if (ab!=null)
			{	
				if (ab.hasLeftChild()){
					cola.enqueue(ab.getLeftChild());
					cantNodos++;
				}
				if (ab.hasRightChild()){
					cola.enqueue(ab.getRightChild());
					cantNodos++;
				}
			}
				
			else if (!cola.isEmpty())
			{
				if (cantNodos != Math.pow(2,++nivel))
					return false;
				cantNodos = 0;
				cola.enqueue(null);
			}
		}
		
		return true;
	}

	public int retornarMayor (){
		int mayor = getData() != null ? (int) getData() : Integer.MIN_VALUE;
		if (hasLeftChild())
			mayor = Math.max(mayor, getLeftChild().retornarMayor());
		if (hasRightChild())
			mayor = Math.max(mayor, getRightChild().retornarMayor());
		if (getData() != null && (int) getData() > mayor)
			return (int) getData();
		return mayor;

	}


	

}


