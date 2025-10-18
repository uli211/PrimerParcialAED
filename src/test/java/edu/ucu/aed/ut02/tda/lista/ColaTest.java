package edu.ucu.aed.ut02.tda.lista;
//package src.test.java.edu.ucu.aed.ut02.tda.lista;
import org.junit.jupiter.api.Test;
import edu.ucu.aed.tda.lista.Cola;
//import src.main.java.edu.ucu.aed.tda.lista.Cola;
import static org.junit.jupiter.api.Assertions.*;

public class ColaTest {

    @Test
    public void fifoBasico() {
        Cola<Integer> q = new Cola<Integer>();
        assertTrue(q.esVacia());
        assertTrue(q.insertar(10)); // usa listaInterna.insertar (al final)
        assertTrue(q.ponerEnCola(20));
        assertTrue(q.ponerEnCola(30));

        assertEquals(3, q.cantElementos());
        assertEquals(10, q.frente());

        assertEquals(10, q.quitarDeCola()); // sale el primero
        assertEquals(2, q.cantElementos());
        assertEquals(20, q.frente());

        assertEquals(20, q.quitarDeCola());
        assertEquals(30, q.quitarDeCola());
        assertTrue(q.esVacia());
    }

    @Test
    public void buscarYEliminarDirecto() {
        Cola<Integer> q = new Cola<Integer>();
        q.ponerEnCola(5);
        q.ponerEnCola(7);
        q.ponerEnCola(9);

        assertEquals(7, q.buscar(7));
        assertNull(q.buscar(11));

        assertEquals(7, q.eliminar(7)); // eliminar por valor
        assertNull(q.buscar(7));
        assertEquals(2, q.cantElementos());
        assertEquals(5, q.frente());
    }
    @Test
    public void obtenerPorIndice_valido_eInvalido() {
        Cola<Integer> q = new Cola<>();
        q.ponerEnCola(100);
        q.ponerEnCola(200);

        // válidos
        assertEquals(100, q.obtenerPorIndice(0));
        assertEquals(200, q.obtenerPorIndice(1));

        // inválidos
        assertNull(q.obtenerPorIndice(-1));
        assertNull(q.obtenerPorIndice(2));
    }

    @Test
    public void imprimir_enVacia_yConDelimitador() {
        Cola<Integer> q = new Cola<>();

        // vacía (ListaEnlazada.imprimir())
        assertEquals("Lista vacia", q.imprimir());

        q.ponerEnCola(1);
        q.ponerEnCola(2);
        q.ponerEnCola(3);

        // no vacía
        assertEquals("Lista no vacia", q.imprimir());
        assertEquals("Impresión completa", q.imprimir(" | "));
    }

    @Test
    public void eliminarInexistente_noCambiaTamanio() {
        Cola<Integer> q = new Cola<>();
        q.ponerEnCola(5);
        q.ponerEnCola(7);

        assertNull(q.eliminar(999));
        assertEquals(2, q.cantElementos());
        assertEquals(5, q.frente());
    }
}
