package tp_Integrador_Java_UTN_Dos;

import java.util.ArrayList;
import java.util.List;

public class Participante {

    // Atributos
    private String nombre;
    private final List<Pronostico> pronosticoList;

    public Participante() {
        this.pronosticoList = null;
    }

    // Constructor
    public Participante(String nombre) {
        this.nombre = nombre;
        this.pronosticoList = new ArrayList<>();
    }

    public Participante(String nombre, List<Pronostico> pronosticoList) {
        this.nombre = nombre;
        this.pronosticoList = pronosticoList;
    }

    public void addPronostico(Pronostico pronostico) {
        this.pronosticoList.add(pronostico);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pronostico> getPronosticoList() {
        return pronosticoList;
    }
    @Override
    public String toString() {
        return "Persona: " + nombre + "\n" + "\tPronosticos: \n\t\t" + pronosticoList;
    }

} // Fin Clase Participante
