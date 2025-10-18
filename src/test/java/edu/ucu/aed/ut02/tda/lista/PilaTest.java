package edu.ucu.aed.ut02.tda.lista;
//package src.test.java.edu.ucu.aed.ut02.tda.lista;
import org.junit.jupiter.api.Test;
import edu.ucu.aed.tda.lista.Pila;
//import src.main.java.edu.ucu.aed.tda.lista.Pila;
import static org.junit.jupiter.api.Assertions.*;

public class PilaTest {

    @Test
    public void lifoBasico() {
        Pila<Integer> st = new Pila<Integer>();
        assertTrue(st.esVacia());
        assertTrue(st.insertar(10)); // push (al principio)
        assertTrue(st.insertar(20));
        assertTrue(st.insertar(30));

        assertEquals(3, st.cantElementos());
        assertEquals(30, st.tope());

        assertEquals(30, st.sacar());
        assertEquals(20, st.tope());
        assertEquals(20, st.sacar());
        assertEquals(10, st.sacar());
        assertTrue(st.esVacia());
        assertNull(st.sacar()); // vacía
    }

    @Test
    public void buscarYEliminarPorValor() {
        Pila<Integer> st = new Pila<Integer>();
        st.insertar(1);
        st.insertar(2);
        st.insertar(3);

        assertEquals(2, st.buscar(2));
        assertNull(st.buscar(99));

        assertEquals(2, st.eliminar(2)); // eliminar por valor en lista interna
        assertNull(st.buscar(2));
        assertEquals(2, st.cantElementos());
        assertEquals(3, st.tope());
    }
    @Test
    public void obtenerPorIndice_valido_eInvalido() {
        Pila<Integer> st = new Pila<>();
        st.insertar(100);
        st.insertar(200); // al principio → queda primero

        // válidos (LIFO → índice 0 es el último insertado)
        assertEquals(200, st.obtenerPorIndice(0));
        assertEquals(100, st.obtenerPorIndice(1));

        // inválidos
        assertNull(st.obtenerPorIndice(-1));
        assertNull(st.obtenerPorIndice(2));
    }

    @Test
    public void imprimir_enVacia_yConDelimitador() {
        Pila<Integer> st = new Pila<>();
        assertEquals("Lista vacia", st.imprimir()); // vacío

        st.insertar(1);
        st.insertar(2);
        st.insertar(3);

        assertEquals("Lista no vacia", st.imprimir());       // no vacío
        assertEquals("Impresión completa", st.imprimir(" -> "));
    }
}
