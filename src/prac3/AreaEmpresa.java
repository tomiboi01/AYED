package prac3;

public class AreaEmpresa
{
    private String id;
    private int tardanza;


    
    public AreaEmpresa(int tardanza) {
        this.tardanza = tardanza;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getTardanza() {
        return tardanza;
    }
    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }

    @Override
    public String toString(){
        return ""+tardanza;

    }

}