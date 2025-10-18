package edu.ucu.aed.ut02.tda.lista;
//package src.test.java.edu.ucu.aed.ut02.tda.lista;
import org.junit.jupiter.api.Test;
import edu.ucu.aed.tda.lista.ListaEnlazada;
import edu.ucu.aed.tda.lista.TDANodo;   
//import src.main.java.edu.ucu.aed.tda.lista.ListaEnlazada;
//import src.main.java.edu.ucu.aed.tda.lista.TDANodo;
import static org.junit.jupiter.api.Assertions.*;

public class ListaEnlazadaTest {

    @Test
    public void insertarAlFinal() {
        ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
        assertEquals("Lista vacia", l.imprimir());
        assertTrue(l.insertar(1));
        assertTrue(l.insertar(2));
        assertTrue(l.insertar(3));
        assertEquals(3, l.cantElementos());
        assertEquals(1, l.obtenerPorIndice(0));
        assertEquals(3, l.obtenerPorIndice(2));
    }

    @Test
    public void insertarOrdenado() {
        ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
        assertTrue(l.insertarOrdenado(20));
        assertTrue(l.insertarOrdenado(10));
        assertTrue(l.insertarOrdenado(30));
        assertTrue(l.insertarOrdenado(25));
        assertEquals(10, l.obtenerPorIndice(0));
        assertEquals(20, l.obtenerPorIndice(1));
        assertEquals(25, l.obtenerPorIndice(2));
        assertEquals(30, l.obtenerPorIndice(3));
    }

    @Test
    public void buscarYEliminar() {
        ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
        l.insertar(10);
        l.insertar(20);
        l.insertar(30);

        assertEquals(20, l.buscar(20));
        assertNull(l.buscar(99));

        // eliminar cabeza
        assertEquals(10, l.eliminar(10));
        assertEquals(2, l.cantElementos());
        assertNull(l.buscar(10));

        // eliminar último (ver finalLista)
        assertEquals(30, l.eliminar(30));
        assertEquals(1, l.cantElementos());
        assertNull(l.buscar(30));

        // eliminar inexistente
        assertNull(l.eliminar(50));
        assertEquals(1, l.cantElementos());
    }

    @Test
    public void insertarAlPrincipio() {
        ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
        assertTrue(l.insertarAlPrincipio(5));
        assertTrue(l.insertarAlPrincipio(3));
        assertEquals(3, l.obtenerPorIndice(0));
        assertEquals(5, l.obtenerPorIndice(1));
    }

    @Test
    public void esVaciaYIndices() {
        ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
        assertTrue(l.esVacia()); // cabeza == null -> true (devuelve true)
        l.insertar(1);
        assertFalse(l.esVacia());
        assertNull(l.obtenerPorIndice(-1));
        assertNull(l.obtenerPorIndice(5));
    }

    @Test
    public void imprimirConDelimitador() {
        ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
        assertEquals("Lista vacía", l.imprimir("|"));
        l.insertar(1);
        l.insertar(2);
        l.insertar(3);
        assertEquals("Impresión completa", l.imprimir("-"));
    }

    @Test
    public void gettersInternosCabezaYFinal() {
        ListaEnlazada<Integer> l = new ListaEnlazada<Integer>();
        l.insertar(10);
        l.insertar(20);
        l.insertar(30);

        assertEquals(10, l.getCabeza());
        TDANodo<Integer> fin = l.getFinalLista();
        assertNotNull(fin);
        assertEquals(30, fin.getDato());
    }
}
