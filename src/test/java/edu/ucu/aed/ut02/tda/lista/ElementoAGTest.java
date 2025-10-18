//package src.test.java.edu.ucu.aed.ut02.tda.lista;
package edu.ucu.aed.ut02.tda.lista;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
//import src.main.java.edu.ucu.aed.tda.lista.ElementoAG;
import edu.ucu.aed.tda.lista.ElementoAG;
public class ElementoAGTest {

    @Test
    void construir_por_ph_sh_y_medir() {
        ElementoAG<String> A = new ElementoAG<>("A");
        ElementoAG<String> B = new ElementoAG<>("B");
        ElementoAG<String> C = new ElementoAG<>("C");
        ElementoAG<String> D = new ElementoAG<>("D");
        ElementoAG<String> E = new ElementoAG<>("E");
        ElementoAG<String> F = new ElementoAG<>("F");

        A.setPrimerHijo(B);
        B.setHermanoDerecho(C);
        C.setHermanoDerecho(D);
        B.setPrimerHijo(E);
        E.setHermanoDerecho(F);

        assertFalse(A.esHoja());
        assertTrue(E.esHoja());

        assertEquals(6, A.cantidadNodos());
        assertEquals(4, A.cantidadHojas()); // C, D, E, F

        assertEquals(2, A.altura()); // A->B->E/F
        assertEquals(0, E.altura());

        assertSame(B, A.buscar("B"));
        assertNull(A.buscar("Z"));

        List<String> pre = new ArrayList<>();
        A.preOrder(n -> pre.add(n.getDato()));
        assertEquals(List.of("A","B","E","F","C","D"), pre);

        List<String> post = new ArrayList<>();
        A.postOrder(n -> post.add(n.getDato()));
        assertEquals(List.of("E","F","B","C","D","A"), post);
    }
}
