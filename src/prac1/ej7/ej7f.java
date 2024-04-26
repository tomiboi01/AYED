package prac1.ej7;

import java.util.ArrayList;
import java.util.Scanner;

public class ej7f {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i=0; i<6; i++)
            lista.add(s.nextInt());

        System.out.println(ej7f.esCapicua(lista));
    }



    public static boolean esCapicua(ArrayList<Integer> lista){
        for (int i=0; i<lista.size()/2; i++){
            if (!lista.get(i).equals(lista.get(lista.size() - 1 - i)) )
                return false;
            

        }
        return true;

    }

}
