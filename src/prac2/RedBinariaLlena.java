package prac2;

public class RedBinariaLlena {
    
    
    public static int calcularEnvio(BinaryTree<Integer> a){      
        if (a.isEmpty())
            return 0;
        int envioI = a.getData() == null ? 0 : a.getData();
        if (a.hasLeftChild())
            envioI += calcularEnvio(a.getLeftChild());   
        int envioD = a.getData() == null ? 0 : a.getData();
        if (a.hasRightChild())
            envioD += calcularEnvio(a.getRightChild());

        if (envioI > envioD)
            return envioI;
        return envioD; 


    }
/* 
    public static int calcularEnvio(BinaryTree<Integer> a){
        if (a.isLeaf())
            return 0;
        int n = 0;
        int envioI = 0;
        if (a.hasLeftChild())
            envioI += a.getLeftChild().getData() + calcularEnvio(a.getLeftChild());   
        int envioD = 0; 
        if (a.hasRightChild())
            envioD += a.getRightChild().getData() + calcularEnvio(a.getRightChild());

        if (envioI > envioD)
            return envioI;
        return envioD; 


    }*/
}
