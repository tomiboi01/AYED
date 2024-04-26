package prac1;
import java.util.Scanner;

public class ej2 {

    public static int[] devolverMultiplos(int n){
        int[] multiplos = new int[n];
        for (int i=1; i<=n; i++){
            multiplos[i-1] = n*i;
        }
        return multiplos;
    }

    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese un número");

        int a = s.nextInt();


        int[] multiplos = devolverMultiplos(a);

        for(int i: multiplos){
            System.out.println(i);
        }
        
    }
   
}
