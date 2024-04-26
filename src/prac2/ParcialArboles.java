package prac2;

public class ParcialArboles {
    private BinaryTree<Integer> arb;

    public ParcialArboles(BinaryTree<Integer> arb) {
        this.arb = arb;
    }

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if (arbol1 == null)
            return true;
        else if (arbol2 == null)
                return false;
        return esPref(arbol1, arbol2);
    }


    private static boolean esPref(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if (arbol1.getData() != arbol2.getData())
            return false;
        if (arbol1.isLeaf() && arbol2.isLeaf())
            return true;
        boolean nD = true;
        boolean nI = true;
        if (arbol1.hasLeftChild())
            if(arbol2.hasLeftChild())
                nI = esPref(arbol1.getLeftChild(), arbol2.getLeftChild());
            else 
                nI = false;
        if (arbol1.hasRightChild() && nI)
            if (arbol2.hasRightChild())
                nD = esPref(arbol1.getRightChild(), arbol2.getRightChild());
            else 
                nD = false;
        return nD && nI; 
    } 
    
    //Asumo que no se manda un arbol nulo como parametro
    public static BinaryTree<Integer> buscarNumero (BinaryTree<Integer> arbol, int num){
        if (arbol.isEmpty())
            return null;
        if (arbol.getData() == num)
            return arbol;
        BinaryTree<Integer> nodo = null;
        if (arbol.hasLeftChild())
            nodo = buscarNumero(arbol.getLeftChild(), num);
        if (arbol.hasRightChild() && nodo == null) 
            return buscarNumero(arbol.getRightChild(), num);
        return nodo;
    }

    public boolean isLeftTree(int num){
        BinaryTree<Integer> nod = buscarNumero(arb, num);
        int hijosUnicosIzquierdos;
        int hijosUnicosDerechos;
        if (nod == null)
            return false;
        if (nod.hasLeftChild())
            hijosUnicosIzquierdos = contarHijosUnicos(nod.getLeftChild());
        else hijosUnicosIzquierdos = -1;
        if (nod.hasRightChild())
            hijosUnicosDerechos = contarHijosUnicos(nod.getRightChild());
        else hijosUnicosDerechos = -1;
        return hijosUnicosIzquierdos > hijosUnicosDerechos;
    }

    //Asumo que no se manda un arbol nulo como parametro
    public int contarHijosUnicos(BinaryTree<Integer> arbol){
        if (arbol.isLeaf())
            return 0;
        if (arbol.hasLeftChild() && !arbol.hasRightChild())
            return 1 + contarHijosUnicos(arbol.getLeftChild());
        if (arbol.hasRightChild() && !arbol.hasLeftChild())
            return 1 + contarHijosUnicos(arbol.getRightChild());
        return contarHijosUnicos(arbol.getLeftChild())+ contarHijosUnicos(arbol.getRightChild());
    }


     
    }

    
