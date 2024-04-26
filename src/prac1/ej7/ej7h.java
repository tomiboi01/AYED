package prac1.ej7;

import java.util.ArrayList;
import java.util.Scanner;

public class ej7h {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<Integer>();

        for (int i=0; i<6; i++)
            lista.add(s.nextInt());

        invertirArrayList(lista);

        System.out.println("asdf");

    }

    public static void invertirArrayList(ArrayList<Integer> lista){
        Integer aux;

        for(int i=0; i<lista.size()/2; i++){
            aux = lista.get(i);
            lista.set(i, lista.get(lista.size()-i-1));
            lista.set(lista.size()-i-1,aux);
        }


    }

    
}
