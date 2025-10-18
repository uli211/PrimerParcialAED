//package src.test.java.edu.ucu.aed.ut02.tda.lista;
package edu.ucu.aed.ut02.tda.lista;
import org.junit.jupiter.api.Test;
import edu.ucu.aed.tda.lista.ArrayList;
//import src.main.java.edu.ucu.aed.tda.lista.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void insertarYCantidadDebeSubir() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        assertEquals(0, arr.cantElementos());
        assertTrue(arr.insertar(10));
        assertTrue(arr.insertar(20));
        assertEquals(2, arr.cantElementos());
        assertEquals(10, arr.obtenerPorIndice(0));
        assertEquals(20, arr.obtenerPorIndice(1));
    }

    @Test
    public void asegurarCapacidadDebeDuplicarInternamente() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 25; i++) {
            assertTrue(arr.insertar(i));
        }
        assertEquals(25, arr.cantElementos());
        assertEquals(0, arr.obtenerPorIndice(0));
        assertEquals(24, arr.obtenerPorIndice(24));
    }

    @Test
    public void insertarOrdenadoYBuscarBinario() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        assertTrue(arr.insertarOrdenado(30));
        assertTrue(arr.insertarOrdenado(10));
        assertTrue(arr.insertarOrdenado(20));
        assertTrue(arr.insertarOrdenado(20)); // permite duplicados

        // orden esperado: 10, 20, 20, 30
        assertEquals(10, arr.obtenerPorIndice(0));
        assertEquals(20, arr.obtenerPorIndice(1));
        assertEquals(20, arr.obtenerPorIndice(2));
        assertEquals(30, arr.obtenerPorIndice(3));

        assertEquals(20, arr.buscarBinario(20));
        assertEquals(10, arr.buscarBinario(10));
        assertEquals(30, arr.buscarBinario(30));
        assertNull(arr.buscarBinario(99));
    }

    @Test
    public void eliminarExistenteYNoExistente() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.insertar(1);
        arr.insertar(2);
        arr.insertar(3);

        assertEquals(2, arr.eliminar(2));
        assertEquals(2, arr.cantElementos());
        assertNull(arr.buscar(2));

        assertNull(arr.eliminar(99)); // no existe
        assertEquals(2, arr.cantElementos());
    }

    @Test
    public void obtenerPorIndiceFueraDeRango() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.insertar(5);
        assertNull(arr.obtenerPorIndice(-1));
        assertNull(arr.obtenerPorIndice(1)); // solo hay índice 0
    }

    @Test
    public void imprimirVaciaYNoVacia() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        assertEquals("Lista vacía", arr.imprimir());
        arr.insertar(7);
        String s1 = arr.imprimir();
        assertEquals("Lista no vacía", s1);

        String s2 = arr.imprimir(" - ");
        assertEquals("Lista no vacía", s2);
    }

    @Test
    public void buscarSecuencial() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.insertar(4);
        arr.insertar(8);
        assertEquals(8, arr.buscar(8));
        assertNull(arr.buscar(9));
    }

    @Test
    public void vaciarDebeDejarEnCero() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.insertar(1);
        arr.insertar(2);
        arr.vaciar();
        assertEquals(0, arr.cantElementos());
        assertEquals("Lista vacía", arr.imprimir());
        assertTrue(arr.esVacia());
    }
}
