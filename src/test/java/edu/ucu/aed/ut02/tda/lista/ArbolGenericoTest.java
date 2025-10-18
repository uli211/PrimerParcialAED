//package src.test.java.edu.ucu.aed.ut02.tda.lista;
package edu.ucu.aed.ut02.tda.lista;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
//import src.main.java.edu.ucu.aed.tda.lista.ArbolGenerico;
import edu.ucu.aed.tda.lista.ArbolGenerico;
public class ArbolGenericoTest {

    @Test
    void vacio_insercion_busqueda_conteos_altura_y_recorridos() {
        ArbolGenerico<String> ag = new ArbolGenerico<>();
        assertTrue(ag.esVacio());
        assertNull(ag.buscar("A"));

        // insertar en vacío → la raíz pasa a ser el nuevoDato
        ag.insertar("IGNORADO", "A");
        assertFalse(ag.esVacio());
        assertEquals("A", ag.getRaiz().getDato());

        // A: hijos B,C,D ; B: hijos E,F
        ag.insertar("A", "B");
        ag.insertar("A", "C");
        ag.insertar("A", "D");
        ag.insertar("B", "E");
        ag.insertar("B", "F");

        assertEquals(6, ag.cantidadNodos());

        // hojas = {C, D, E, F} = 4
        assertEquals(4, ag.cantidadHojas());

        // altura: A( B(E,F), C, D )
        // camino más largo A->B->E (o F) ⇒ 2 (en aristas) ó 3 (en nodos)
        int h = ag.altura();
        assertTrue(h == 2 || h == 3, "altura() debe ser 2 (aristas) o 3 (nodos); fue " + h);

        // buscar
        assertNotNull(ag.buscar("F"));
        assertNull(ag.buscar("Z"));

        // recorridos (orden de inserción de hijos)
        List<String> pre = new ArrayList<>();
        ag.preOrder(pre::add);
        assertEquals(List.of("A","B","E","F","C","D"), pre);

        List<String> post = new ArrayList<>();
        ag.postOrder(post::add);
        assertEquals(List.of("E","F","B","C","D","A"), post);
    }


    @Test
    void imprimir_no_explota() {
        ArbolGenerico<Integer> ag = new ArbolGenerico<>();
        ag.imprimirPreOrder();  // no debe lanzar
        ag.imprimirPostOrder(); // no debe lanzar
        ag.insertar(0, 1);
        ag.imprimirPreOrder();
        ag.imprimirPostOrder();
    }
}
