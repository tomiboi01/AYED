package prac3;

public class ProcesadorGematria {

    public int contar(GeneralTree<Integer> a, int valor){
        int contar = 0;
        int resta = valor - a.getData();
        if (a.isLeaf()){
            if (resta == 0)
                return 1;
            if (resta != 0)
                return 0;
        }
        if (resta > 0)
            for(GeneralTree<Integer> i : a.getChildren())
                contar += contar(i,resta);
        return contar;
}

}
