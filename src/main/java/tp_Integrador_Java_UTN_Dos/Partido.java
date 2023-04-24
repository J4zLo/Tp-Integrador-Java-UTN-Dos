package tp_Integrador_Java_UTN_Dos;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private int ronda;


    //Constructores
    public Partido(int ronda, Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.ronda = ronda;
    }
    public Partido(Equipo equipoLocal, int golesEquipoLocal, int golesEquipoVisitante, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;

    }

    //Setters
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {

        this.golesEquipoLocal = golesEquipoLocal;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    //Getters
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    //Metodo Resultado
    public EnumResultado resultadoPartido(Equipo equipo) {
        if (golesEquipoLocal == golesEquipoVisitante) {
            return EnumResultado.EMPATE;
        }
        if (equipo.getNombre().equals(equipoLocal.getNombre())) {
            if (golesEquipoLocal > golesEquipoVisitante) {
                return EnumResultado.GANADOR;
            } else {
                return EnumResultado.PERDEDOR;
            }
        } else {
            if (golesEquipoLocal < golesEquipoVisitante) {
                return EnumResultado.GANADOR;
            } else {
                return EnumResultado.PERDEDOR;
            }
        }
    }
}//Fin clase Partido
