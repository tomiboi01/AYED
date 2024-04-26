package prac1.ej7;
/*Hacer una lista con todos los valores que surgen de hacer la funcion recursiva n/2 si n es par, y n*3 +1 si es impar, hasta el 1
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ej7g {
    public static void main(String[] args) {
    List <Integer> lista = calcularSucesion(30);
    System.out.println(lista);
    }

    public static List <Integer> calcularSucesion (int n){
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.add(n);
        if (n==1)
            return lista;
        if (n%2 == 0)
        {
           lista.addAll(calcularSucesion((int) n/2));
           return lista;
        }
        lista.addAll(calcularSucesion(n*3 - 1));
        return lista;
    }
}
