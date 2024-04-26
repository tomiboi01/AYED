package prac3;

import prac1.Queue;

public class AnalizadorArbol {
    
    public static double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol)
    {
        if (arbol == null || arbol.isEmpty())
            return -1;
        GeneralTree<AreaEmpresa> arb = null;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>(); 
        double prom = arbol.getData().getTardanza();
        double suma = 0;
        int cantNodos = 0;
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty())
        {
            arb = cola.dequeue();
            if (arb != null){
                for(GeneralTree<AreaEmpresa> c : arb.getChildren()){
                    cola.enqueue(c);
                    suma += c.getData().getTardanza();
                    cantNodos++;
                }
            }
            else 
            {
                if (!cola.isEmpty())
                {   
                    cola.enqueue(null);
                    if ((double)suma/cantNodos > prom)
                        prom = (double)suma/cantNodos;
                    suma = 0;
                    cantNodos = 0;
                }
            
            }

        
        }
        return prom;

    }

}
