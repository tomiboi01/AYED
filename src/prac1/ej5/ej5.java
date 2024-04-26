package prac1.ej5;


/*5. Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
en un único método. Escriba tres métodos de clase, donde respectivamente:
a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return". */

public class ej5{
    private int maximo;
    private int minimo;
    private double prom;
    int[] vec = new int[]{1,5,7,-5,20,-5,5,89,65,34};


    
    public  static void main(String[] args) {
        int[] vector = new int[]{1,5,7,-5,20,-5,5,89,65,34};
        Registro r = MaxMinPromEnArray(vector);
        System.out.println(r.toString());
    }

    public static Registro MaxMinPromEnArray (int[] v){
        int max= -9999;
        int min = 9999;
        double suma = 0;
        for (int i=0; i<v.length; i++){
            if (v[i] > max)
                max = v[i];
            if (v[i] < min)
                min = v[i];
            suma += v[i]; 
        }
        return new Registro(max, min, (double) suma/v.length);
    }
    public static void MaxMinPromEnArray (int[] v, Registro r){
        int max= -9999;
        int min = 9999;
        double suma = 0;
        for (int i=0; i<v.length; i++){
            if (v[i] > max)
                max = v[i];
            if (v[i] < min)
                min = v[i];
            suma += v[i]; 
        }
        r.setMaximo(max);
        r.setMinimo(min);
        r.setReal((double) suma/v.length);
    }

    public  void MaxMinPromEnArray (){
        int max= -9999;
        int min = 9999;
        double suma = 0;
        for (int i=0; i< vec.length; i++){
            if (vec[i] > max)
                max = vec[i];
            if (vec[i] < min)
                min = vec[i];
            suma += vec[i]; 
        }
        this.maximo = max;
        this.minimo = min;
        this.prom = (double) suma/vec.length;
       
    }
}