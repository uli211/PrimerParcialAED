package edu.ucu.aed.ut02.tda.lista;

import edu.ucu.aed.tda.lista.NodoTrie;
import edu.ucu.aed.tda.lista.Resultado;
import edu.ucu.aed.tda.lista.TDALista;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodoTrieTest {

    @Test
    public void testInsertarYBuscarPalabra() {
        NodoTrie<String> nodo = new NodoTrie<>();
        assertTrue(nodo.insertar("sol", "sol"));

        // Reinsertar misma palabra → false
        assertFalse(nodo.insertar("sol", "sol"));

        // Buscar palabra completa
        Resultado<String> r1 = nodo.buscar("sol");
        assertEquals(1, r1.getEstado());
        assertEquals("sol", r1.getDato());

        // Buscar prefijo incompleto
        Resultado<String> r2 = nodo.buscar("so");
        assertEquals(0, r2.getEstado());
    }

    @Test
    public void testPredecirYRecorrerDesdeNodo() {
        NodoTrie<String> nodo = new NodoTrie<>();
        nodo.insertar("sol", "sol");
        nodo.insertar("son", "son");
        nodo.insertar("sopa", "sopa");

        // predecir("so") debería devolver las tres palabras
        TDALista<String> lista = nodo.predecir("so");
        assertEquals(3, lista.cantElementos());
        assertEquals("sol", lista.buscar("sol"));
        assertEquals("son", lista.buscar("son"));
        assertEquals("sopa", lista.buscar("sopa"));

        // predecir("ta") → lista vacía
        TDALista<String> vacia = nodo.predecir("ta");
        assertTrue(vacia.esVacia());
    }
}
