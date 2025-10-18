package edu.ucu.aed.ut02.tda.lista;

import edu.ucu.aed.tda.lista.Resultado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResultadoTest {

    @Test
    public void testConstructorYGetters() {
        Resultado<String> r = new Resultado<>(1, "dato");
        assertEquals(1, r.getEstado());
        assertEquals("dato", r.getDato());
    }

    @Test
    public void testSettersYToString() {
        Resultado<Integer> r = new Resultado<>(0, null);
        r.setEstado(-1);
        r.setDato(42);

        assertEquals(-1, r.getEstado());
        assertEquals(42, r.getDato());

        String salida = r.toString();
        assertTrue(salida.contains("estado=-1"));
        assertTrue(salida.contains("dato=42"));
    }
}
