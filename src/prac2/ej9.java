package prac2;

public class ej9 {
    public static BinaryTree<ClaseInfo> sumAndDif(BinaryTree<Integer> arbol, int total, int dato){
        if (arbol == null || arbol.getData() == null)
            return null;

        ClaseInfo info = new ClaseInfo(total + arbol.getData(), arbol.getData() - dato);
        BinaryTree<ClaseInfo> arb = new BinaryTree<ClaseInfo>(info);
        if (arbol.isLeaf())
            return arb;
        
        if (arbol.hasLeftChild())
            arb.addLeftChild(sumAndDif(arbol.getLeftChild(), info.getSum(), arbol.getData()));
        if (arbol.hasRightChild())
            arb.addRightChild(sumAndDif(arbol.getRightChild(),info.getSum(), arbol.getData()));
        


        return arb;
    }
    
}
