package tp_Integrador_Java_UTN_DosTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tp_Integrador_Java_UTN_Dos.EnumResultado;
import tp_Integrador_Java_UTN_Dos.Equipo;
import tp_Integrador_Java_UTN_Dos.Partido;

public class PartidoTest {

@Test
    public void deberiaSerEmpate() {
        Equipo equipo1 = new Equipo( "Arg");
        Equipo equipo2 = new Equipo("Mex");
        Partido partido = new Partido(equipo1, 5, 5, equipo2);

        EnumResultado resultadoEquipo1 = partido.resultadoPartido(equipo1);
        EnumResultado resultadoEquipo2 = partido.resultadoPartido(equipo2);

        Assertions.assertEquals(EnumResultado.EMPATE, resultadoEquipo1);
        Assertions.assertEquals(EnumResultado.EMPATE, resultadoEquipo2);
    }


}
