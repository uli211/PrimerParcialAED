package edu.ucu.aed.ut02.tda.lista;
//package src.test.java.edu.ucu.aed.ut02.tda.lista;
import org.junit.jupiter.api.Test;
import edu.ucu.aed.tda.lista.LinkedList;
//import src.main.java.edu.ucu.aed.tda.lista.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void insertarYImprimir() {
        LinkedList<Integer> dl = new LinkedList<Integer>();
        assertTrue(dl.insertar(1));
        assertTrue(dl.insertar(2));
        assertTrue(dl.insertar(3));
        String s = dl.imprimir();
        assertEquals("1 2 3 ", s);
        assertEquals(3, dl.cantElementos());
        assertFalse(dl.esVacia());
    }

    @Test
    public void imprimirReverso() {
        LinkedList<Integer> dl = new LinkedList<Integer>();
        dl.insertar(10);
        dl.insertar(20);
        dl.insertar(30);
        assertEquals("30 20 10 ", dl.imprimirReverso());
    }

    @Test
    public void buscarYEliminarEnTresPosiciones() {
        LinkedList<Integer> dl = new LinkedList<Integer>();
        dl.insertar(10);
        dl.insertar(20);
        dl.insertar(30);

        // buscar
        assertEquals(20, dl.buscar(20));
        assertNull(dl.buscar(99));

        // eliminar cabeza
        assertEquals(10, dl.eliminar(10));
        assertEquals(2, dl.cantElementos());
        assertNull(dl.buscar(10));

        // eliminar cola
        assertEquals(30, dl.eliminar(30));
        assertEquals(1, dl.cantElementos());
        assertNull(dl.buscar(30));

        // eliminar nodo intermedio (ahora solo queda 20)
        assertEquals(20, dl.eliminar(20));
        assertTrue(dl.esVacia());
    }

    @Test
    public void obtenerPorIndice() {
        LinkedList<Integer> dl = new LinkedList<Integer>();
        dl.insertar(5);
        dl.insertar(6);
        assertEquals(5, dl.obtenerPorIndice(0));
        assertEquals(6, dl.obtenerPorIndice(1));
        assertNull(dl.obtenerPorIndice(-1));
        assertNull(dl.obtenerPorIndice(5));
    }

    @Test
    public void imprimirConDelimitador() {
        LinkedList<Integer> dl = new LinkedList<Integer>();
        assertEquals("Lista vacía", dl.imprimir(" | "));
        dl.insertar(1);
        dl.insertar(2);
        assertEquals("1 | 2", dl.imprimir(" | "));
    }
}
