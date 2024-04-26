package prac1.ej5;

public class Registro{
    private int Maximo;
    private int Minimo;
    private double Real;

    

    public Registro(int maximo, int minimo, double real) {
        Maximo = maximo;
        Minimo = minimo;
        Real = real;
    }
    public int getMaximo() {
        return Maximo;
    }
    public void setMaximo(int maximo) {
        Maximo = maximo;
    }
    public int getMinimo() {
        return Minimo;
    }
    public void setMinimo(int minimo) {
        Minimo = minimo;
    }
    public double getReal() {
        return Real;
    }
    public void setReal(double real) {
        Real = real;
    }

    

}
