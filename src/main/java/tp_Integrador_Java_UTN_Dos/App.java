package tp_Integrador_Java_UTN_Dos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class App {
    public static void main( String[] args )    {
        System.out.println( "Hello World!" );

        //Leer Archivo Partidos
        String miArchivoPartidos = "C:\\Users\\PC\\Desktop\\Tp 2daEntrega\\Tp-Integrador-Java-UTN-Dos\\src\\Dato.csv";
        Path ruta = Paths.get(miArchivoPartidos);
        List<String> lineasArchivoPartidos = null;
        List <String> campou= null;
        Collection<Partido> partidos = new ArrayList<Partido>();
        String equipo1;
        String equipo2;
        int ronda;

        EnumResultado resultado= null;
        try {
            lineasArchivoPartidos = Files.readAllLines(ruta);
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo encontrar el archivo " + miArchivoPartidos);
            System.exit(1);
        }
        //Agrego aux (boolean esEncabezado) para no leer el encabezado.
        // La variable la inicializo como true y automaticamente en la primer iteracion pasa a ser false.
        boolean esEncabezado = true;
        for (String lineaArchivoPartido : lineasArchivoPartidos) {
            //Si el encabezado es true entonces el encabezado se convierte en false
            if (esEncabezado) {
                esEncabezado = false;
            }
            //Si el encabezado no es true entonces imprimo por pantalla.
            else {
                String[] campos = lineaArchivoPartido.split(";");
                ronda = Integer.parseInt(campos[0]);
                equipo1 = campos[1];
                equipo2 = campos[4];
                Equipo equipoLocal = new Equipo(equipo1);
                Equipo equipoVisitante = new Equipo(equipo2);
                Partido partido = new Partido(ronda, equipoLocal, equipoVisitante);

                partido.setGolesEquipoLocal(Integer.parseInt(campos[2]));
                partido.setGolesEquipoVisitante(Integer.parseInt(campos[3]));
                partidos.add(partido);
                }
            }



        //Leer Archivo Pronosticos
        String miArchivoPronosticos = "C:\\Users\\PC\\Desktop\\Tp 2daEntrega\\Tp-Integrador-Java-UTN-Dos\\src\\Apuestas.csv";
        Path ruta2 = Paths.get(miArchivoPronosticos);
        List<String> lineasArchivoPronosticos = null;
        List <Participante> participanteList = new ArrayList<>();


        try {
            lineasArchivoPronosticos = Files.readAllLines(ruta2);
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo encontrar el archivo " + miArchivoPronosticos);
            System.exit(2);
        }

        esEncabezado = true;
        for (String lineaArchivoPronostico : lineasArchivoPronosticos) {
            //Si el encabezado es true entonces el encabezado se convierte en false
            if (esEncabezado) {
                esEncabezado = false;
            }
            //Si el encabezado no es true entonces:
            else {
                String[] campos = lineaArchivoPronostico.split(";");
                String jugador = campos[0];
                Equipo equip1 = new Equipo(campos[1]);
                Equipo equip2 = new Equipo(campos[5]);

                Partido partido = null;

                for (Partido partidoColeccion : partidos) {
                    if (partidoColeccion.getEquipoLocal().getNombre().equals(equip1.getNombre())
                            && partidoColeccion.getEquipoVisitante().getNombre().equals(equip2.getNombre())) {
                        partido = partidoColeccion;
                    }

                }
                Equipo equipo = null;

                if ("x".equals(campos[2])) {
                    equipo = equip1;
                    resultado = EnumResultado.GANADOR;
                }
                if ("x".equals(campos[3])) {
                    equipo = equip1;
                    resultado = EnumResultado.EMPATE;
                }
                if ("x".equals(campos[4])) {
                    equipo = equip1;
                    resultado = EnumResultado.PERDEDOR;
                }

                //Verifica si el participante ya esta en la lista o si es nuevo
                boolean esNuevoParticipante= true;
                for (Participante persona : participanteList) {
                    if (jugador.equals(persona.getNombre())) {
                        esNuevoParticipante = false;
                        break;
                    }
                }
                if (esNuevoParticipante) {
                    participanteList.add(new Participante(jugador));
                }

                for (Participante participante : participanteList) {
                    if (participante.getNombre().equals(jugador)) {
                        participante.addPronostico(new Pronostico(partido, equipo, resultado));
                    }
                }
            }
        }

        //Para calcular los puntos por Jugador
        int suma=0;
        for (Participante esteParticipante : participanteList) {
            System.out.printf("%s: %d%n", esteParticipante.getNombre(), contarPuntos(esteParticipante));
            suma+=sumarTotalPuntos(esteParticipante);

        }

    }

    // Método contarPuntos:
    public static int contarPuntos(Participante p) {
        int puntaje = 0;
        for (Pronostico q : p.getPronosticoList()) {
            puntaje += q.puntos();
        }
        return puntaje;
    }

    // Método sumarTotalPuntos
    public static int sumarTotalPuntos(Participante p) {
        int puntaje = 0;
        int ptos=0;
        int extra=5;
        for (Pronostico q : p.getPronosticoList()) {
            puntaje += q.ΣPuntos();
        }
        ptos=puntaje+ptos;

        return ptos;

    }

} //Fin Clase App Main

