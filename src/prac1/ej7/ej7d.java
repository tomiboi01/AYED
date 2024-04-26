package prac1.ej7;

import java.util.*;

/*Escriba un método que realice las siguientes acciones:
■ cree una lista que contenga 3 estudiantes
■ genere una nueva lista que sea una copia de la lista del inciso i
■ imprima el contenido de la lista original y el contenido de la nueva lista
■ modifique algún dato de los estudiantes
■ vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista.
¿Qué conclusiones obtiene a partir de lo realizado?
■ ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre
ellas?
 */
public class ej7d {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList <Estudiante> lista = new ArrayList <Estudiante> ();

        lista.add(new Estudiante(10, "asdf", "asdf"));
        lista.add(new Estudiante(11, "hgf", "dfgh"));
        lista.add(new Estudiante(12, "dfsgh", "fghj"));

        // Se copia el array en un array nuevo con otra dirección en memoria, 
        // pero los objetos dentro del array tienen la misma dirección
        ArrayList<Estudiante> nLista = new ArrayList<Estudiante>(lista); 
        nLista.addAll(lista);
        nLista.clear();

        //Hago un array nuevo y copio los estudiantes en nuevos objetos
        for(Estudiante e:lista){
            nLista.add(new Estudiante(e.getLegajo(), e.getApellido(), e.getNombre()));
        }
        System.out.println("s");


    }
    
}
