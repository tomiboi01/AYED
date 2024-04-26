/*Escriba tres métodos de clase (static) que reciban por parámetro dos números enteros (tipo
int) a y b e impriman todos los números enteros comprendidos entre a; b (inclusive), uno por
cada línea en la salida estándar. Para ello, dentro de una nueva clase escriba un método por
cada uno de los siguientes incisos:
a. Que realice lo pedido con un for.
b. Que realice lo pedido con un while.
c. Que realice lo pedido sin utilizar estructuras de control iterativas (for, while, do
while).
 */

package prac1;
public class ej1 {
    public static void ImprimirEntreConFor(int a, int b){
        if (a>b)
            for (int i=b; i<=a; i++){
                System.out.println(i);
            }
        else  for (int i=a; i<=b; i++){
            System.out.println(i);
        }
    }

    public static void ImprimirEntreConWhile(int a, int b){
        if (a>b){
            int i =b;
            while (i<= a) {
                System.out.println(i);
                i++;
            }
        }
        else {
            int i = a;
            while(i<=b){
                System.out.println(i);
                i++;
            }
        }
    }
    public static void ImprimirEntreSinIterativas(int a, int b){
        if (a>b){
            System.out.println(a);
            if (a!=b)
                ImprimirEntreSinIterativas(a-1, b);
        }
        else {
            System.out.println(a);
            if (a!=b)
                ImprimirEntreSinIterativas(a+1, b);
        }
    }
    public static void main (String[] args){
        ej1.ImprimirEntreConFor(1, 10);
        ej1.ImprimirEntreConWhile(1, 10);
        ej1.ImprimirEntreSinIterativas(1, 10);
    }
}