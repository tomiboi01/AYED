package prac1.ej7;
import java.util.*;
/*i. Implemente un método recursivo que calcule la suma de los elementos en un
LinkedList. */
public class ej7i {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>(Arrays.asList(1,5,6,2));;
    System.out.println(sumarLista(lista.iterator()));
    }
    public static int sumarLista (Iterator<Integer> i){
        if (!i.hasNext())
            return 0;
        return i.next() + sumarLista(i);
    }

    
}
