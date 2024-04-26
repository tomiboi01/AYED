package prac2;

public class Transformacion {
    private BinaryTree<Integer> arbol = new BinaryTree<Integer>();

    
    
    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    public void sumaModificar (){
        sumaMod(arbol);

    }
    
    
    public int sumaMod (BinaryTree<Integer> arbol){
        int aux = 0;
        if (arbol.hasLeftChild())
            aux += sumaMod(arbol.getLeftChild());
        if (arbol.hasRightChild())
            aux += sumaMod(arbol.getRightChild());
        int ret = arbol.getData();
        arbol.setData(aux);
        aux += ret;
        return aux;
    }
    public BinaryTree<Integer> getArbol() {
        return arbol;
    }
    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }



public BinaryTree<Integer> sumaNuevo(){
    BinaryTree<Integer> arbolCopia = new BinaryTree<>();
    sumaRec(this.arbol, arbolCopia);
     return arbolCopia;

}

private static int sumaRec (BinaryTree<Integer> arbol, BinaryTree<Integer> arbolCopia){

    int sumaHijos = 0;

    if(arbol.hasLeftChild()) {
        BinaryTree<Integer> arbolAuxI = new BinaryTree<>();
        sumaHijos += sumaRec(arbol.getLeftChild(),arbolAuxI);
        arbolCopia.addLeftChild(arbolAuxI);
    }
    if(arbol.hasRightChild()) {
        BinaryTree<Integer> arbolAuxD = new BinaryTree<>();
        sumaHijos += sumaRec(arbol.getRightChild(),arbolAuxD);
        arbolCopia.addRightChild(arbolAuxD);
    }
    arbolCopia.setData(sumaHijos);

    return sumaHijos + arbol.getData();

}

}

