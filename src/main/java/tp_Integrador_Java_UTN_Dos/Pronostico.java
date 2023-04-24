package tp_Integrador_Java_UTN_Dos;

public class Pronostico {

    private Partido partido;
    private Equipo equipo;
    private EnumResultado resultadoProno;

    //Metodo de puntos
    public Pronostico(Partido partido, Equipo equipo, EnumResultado resultadoProno) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultadoProno = resultadoProno;


    }


    public int puntos(){
        EnumResultado resultadoPartido = this.partido.resultadoPartido(this.equipo);
        if(this.resultadoProno.equals(resultadoPartido)){
            return 1;
        } else {

            return 0;
        }
    }

    public int ΣPuntos() {

        int suma = 0;
        suma += puntos();
        return suma;
    }
@Override
    public String toString() {
        return "\n *Pronóstico del Partido: " + partido + "\n *Datos Seleccionados del Equipo: \n" + equipo
                + " -Resultado: " + resultadoProno;
    }
}//Fin


