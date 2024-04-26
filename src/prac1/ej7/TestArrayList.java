package prac1.ej7;
/*Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de
números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los
números a la lista, imprime el contenido de la misma iterando sobre cada elemento. */
import java.util.*;
public class TestArrayList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList <Integer>();
        Integer i = s.nextInt();
        while (!i.equals(0)) {
            lista.add(i);
            i = s.nextInt();

        }
    
        for(Integer m:lista){
            System.out.println(m);
        }

        LinkedList <Integer> numeros = new LinkedList<Integer>();

        numeros.add(s.nextInt());
        for(Integer m:numeros)
            System.out.println(m);

        
    }
    
}
