package tp_Integrador_Java_UTN_Dos;

public class Equipo {


    private String nombre;
    private String descripcion;


    //Constructor
    public Equipo(String nombre) {

        this.nombre = nombre;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    //Getters
    public String getNombre() {

        return nombre;
    }
    public String getDescripcion() {

        return descripcion;
    }
}//Fin

