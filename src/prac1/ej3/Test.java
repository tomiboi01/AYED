package prac1.ej3;

public class Test {
    public static void main(String[] args) {
        Profesor p = new Profesor();
        p.setNombre("Juan");
        p.setApellido("Perez");
        p.setMail("skldf@gmail.com");

        p.setFacultad("Ingenieria");
        p.setCatedra("Algoritmos");

        System.out.println(p.tusDatos());
    }
}