package prac2;

public class ProfundidadDeArbolBinario {
    BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    

    public ProfundidadDeArbolBinario() {

    }



    public int sumarElementosProfundidad(int n){
        return sumarElementosProfundidad(n, arbol);
    }

     static int sumarElementosProfundidad(int n, BinaryTree<Integer> arbol){
        if (arbol == null || arbol.isEmpty())
            return 0;
        if ((n == 0) && (arbol.getData() != null))
            return arbol.getData();
        int m = 0;
        if (arbol.hasLeftChild())
            m += sumarElementosProfundidad(n-1,arbol.getLeftChild());
        if(arbol.hasRightChild())
            m += sumarElementosProfundidad(n-1, arbol.getRightChild());
        return m;
        }
}



