package prac3;

public class RedDeAguaPotable {
    private GeneralTree<Character> arbol = new GeneralTree<Character>();

    public RedDeAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }

    private double minimoCaudal(GeneralTree<Character> arbol, double caudal)
    {
        if (arbol.isLeaf())
            return caudal;

        double aux;
        double min = caudal;
        for (GeneralTree<Character> child:arbol.getChildren())
        {
            aux = minimoCaudal(child, caudal / arbol.getChildren().size());
            if (aux < min)
                min = aux;
        }
        return min;

    }

    public double minimoCaudal(double caudal)
    {
        if (arbol != null)
            return minimoCaudal(arbol,caudal);
        return -1;
    }

    
}
