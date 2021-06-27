package Models;

public class Ciudad {
    private int Id;
    private String Nombre;
    private int Poblacion;
    private double Latitud;
    private double Longitud;

    public Ciudad() {

    }
    public Ciudad(int id, String nombre, int poblacion, double latitud,double longitud){
        Id=id;
        Nombre=nombre;
        Poblacion=poblacion;
        Latitud=latitud;
        Longitud=longitud;
    }
    public int getId(){
        return Id;
    }
    public void setId(int id){
        Id= id;
    }
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String nombre){
        Nombre= nombre;
    }
    public int getPoblacion(){
        return Poblacion;
    }
    public void setPoblacion(int poblacion){
        Poblacion= poblacion;
    }
    public double getLatitud(){
        return Latitud;
    }
    public void setLatitud(double latitud){
        Latitud= latitud;
    }
    public double getLongitud(){
        return Longitud;
    }
    public void setLongitud(double longitud){
        Longitud= longitud;
    }


}
