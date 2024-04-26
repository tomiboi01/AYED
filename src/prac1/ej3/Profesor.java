package prac1.ej3;

public class Profesor extends Persona {
    private String facultad;
    private String catedra;

    public String tusDatos(){
        return super.tusDatos() + "Facultad: " + facultad + "\n" +
                "Catedra: " + catedra + "\n";
    }
    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    public String getCatedra() {
        return catedra;
    }
    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    
}
