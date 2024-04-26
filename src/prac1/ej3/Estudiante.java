package prac1.ej3;

public class Estudiante extends Persona {
    private String comision;
    private String direccion;

    public String tusDatos(){
        return super.tusDatos() + "Comision: " + comision + "\n" +
                "Direccion: " + direccion + "\n";
    }

    public String getComision() {
        return comision;
    }
    public void setComision(String comision) {
        this.comision = comision;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
