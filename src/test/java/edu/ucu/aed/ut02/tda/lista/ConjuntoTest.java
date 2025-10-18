package edu.ucu.aed.ut02.tda.lista;
//package src.test.java.edu.ucu.aed.ut02.tda.lista;
import org.junit.jupiter.api.Test;
import edu.ucu.aed.tda.lista.Conjunto;
import edu.ucu.aed.tda.lista.TDAConjunto;
//import src.main.java.edu.ucu.aed.tda.lista.Conjunto;
//import src.main.java.edu.ucu.aed.tda.lista.TDAConjunto;
import static org.junit.jupiter.api.Assertions.*;

public class ConjuntoTest {

    @Test
    public void insertarSinDuplicados() {
        Conjunto<Integer> c = new Conjunto<Integer>();
        assertTrue(c.esVacia());
        assertTrue(c.insertar(10));
        assertFalse(c.insertar(10)); // no duplica
        assertTrue(c.insertar(20));
        assertEquals(2, c.cantElementos());
        assertEquals(10, c.obtenerPorIndice(0));
        assertEquals(20, c.obtenerPorIndice(1));
    }

    @Test
    public void unionBasica() {
        Conjunto<Integer> a = new Conjunto<Integer>();
        a.insertar(1);
        a.insertar(2);
        a.insertar(3);

        Conjunto<Integer> b = new Conjunto<Integer>();
        b.insertar(3);
        b.insertar(4);
        b.insertar(5);

        TDAConjunto<Integer> u = a.union(b);
        // elementos esperados: {1,2,3,4,5} (orden según inserciones)
        assertEquals(5, u.cantElementos());
        assertNotNull(u.buscar(1));
        assertNotNull(u.buscar(5));
    }

    @Test
    public void interseccionBasica() {
        Conjunto<Integer> a = new Conjunto<Integer>();
        a.insertar(1);
        a.insertar(2);
        a.insertar(3);

        Conjunto<Integer> b = new Conjunto<Integer>();
        b.insertar(2);
        b.insertar(3);
        b.insertar(4);

        TDAConjunto<Integer> i = a.interseccion(b);
        assertEquals(2, i.cantElementos());
        assertNotNull(i.buscar(2));
        assertNotNull(i.buscar(3));
        assertNull(i.buscar(1));
        assertNull(i.buscar(4));
    }

    @Test
    public void diferenciaBasica() {
        Conjunto<Integer> a = new Conjunto<Integer>();
        a.insertar(1);
        a.insertar(2);
        a.insertar(3);

        Conjunto<Integer> b = new Conjunto<Integer>();
        b.insertar(3);
        b.insertar(4);
        b.insertar(5);

        TDAConjunto<Integer> d = a.diferencia(b); // elementos en a que no están en b -> {1,2}
        assertEquals(2, d.cantElementos());
        assertNotNull(d.buscar(1));
        assertNotNull(d.buscar(2));
        assertNull(d.buscar(3));
    }
    @Test
    public void imprimir_enVacio_yNoVacio_conDelimitador() {
        Conjunto<Integer> c = new Conjunto<>();
        assertEquals("Lista vacia", c.imprimir());       // vacío

        c.insertar(1);
        c.insertar(2);
        assertEquals("Lista no vacia", c.imprimir());    // no vacío
        assertEquals("Impresión completa", c.imprimir(" - "));
    }

    @Test
    public void esVacia_falseCuandoHayElementos_yObtenerPorIndiceInvalido() {
        Conjunto<Integer> c = new Conjunto<>();
        assertTrue(c.esVacia());
        c.insertar(10);
        assertFalse(c.esVacia());

        // inválidos
        assertNull(c.obtenerPorIndice(-1));
        assertNull(c.obtenerPorIndice(1));
    }

    @Test
    public void eliminar_enVacio_eInexistente() {
        Conjunto<Integer> c = new Conjunto<>();
        assertNull(c.eliminar(1));    // eliminar en vacío

        c.insertar(5);
        c.insertar(7);
        assertNull(c.eliminar(999));  // inexistente
        assertEquals(2, c.cantElementos());
    }

    @Test
    public void operaciones_conConjuntoVacio() {
        Conjunto<Integer> a = new Conjunto<>();
        Conjunto<Integer> b = new Conjunto<>();
        b.insertar(2);
        b.insertar(3);

        // A vacío, B no vacío
        TDAConjunto<Integer> u1 = a.union(b);
        assertEquals(2, u1.cantElementos());

        TDAConjunto<Integer> i1 = a.interseccion(b);
        assertTrue(i1.esVacia());

        TDAConjunto<Integer> d1 = a.diferencia(b);
        assertTrue(d1.esVacia());

        // B vacío, A no vacío
        a.insertar(1);
        a.insertar(2);
        TDAConjunto<Integer> u2 = a.union(new Conjunto<>());
        assertEquals(2, u2.cantElementos());
        TDAConjunto<Integer> i2 = a.interseccion(new Conjunto<>());
        assertTrue(i2.esVacia());
        TDAConjunto<Integer> d2 = a.diferencia(new Conjunto<>());
        assertEquals(2, d2.cantElementos());
    }
}
