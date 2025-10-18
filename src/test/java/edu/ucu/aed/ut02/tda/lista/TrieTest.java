package edu.ucu.aed.ut02.tda.lista;

import edu.ucu.aed.tda.lista.Trie;
import edu.ucu.aed.tda.lista.Resultado;
import edu.ucu.aed.tda.lista.TDALista;
import edu.ucu.aed.tda.lista.ListaEnlazada;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    // ===================== insertar() =====================

    @Test
    public void testInsertar_NuevaYDuplicada() {
        Trie<String> trie = new Trie<>();

        // Inserciones nuevas
        assertTrue(trie.insertar("sol", "sol"));
        assertTrue(trie.insertar("sopa", "sopa"));

        // Duplicada (misma palabra)
        assertFalse(trie.insertar("sol", "sol"));
    }

    @Test
    public void testInsertar_NormalizaMinusculasYRechazaFueraRango() {
        Trie<String> trie = new Trie<>();

        // Se normaliza a minúsculas internamente en Trie
        assertTrue(trie.insertar("Son", "Son"));
        Resultado<String> r = trie.buscar("son");
        assertEquals(1, r.getEstado());
        assertEquals("Son", r.getDato()); // guardamos como dato lo que pasamos

        // Caracter fuera de 'a'..'z' → rechaza
        assertFalse(trie.insertar("mañana", "mañana")); // contiene 'ñ'
        assertFalse(trie.insertar("so!", "so!"));       // contiene '!'
    }

    // ===================== buscar() =====================

    @Test
    public void testBuscar_Estados1y0yMenos1() {
        Trie<String> trie = new Trie<>();
        trie.insertar("sol", "sol");
        trie.insertar("son", "son");

        // 1 → palabra completa encontrada
        Resultado<String> r1 = trie.buscar("sol");
        assertEquals(1, r1.getEstado());
        assertEquals("sol", r1.getDato());

        // 0 → prefijo válido pero no palabra completa
        Resultado<String> r0 = trie.buscar("so");
        assertEquals(0, r0.getEstado());
        assertNull(r0.getDato());

        // -1 → no existe ni como prefijo
        Resultado<String> r_1 = trie.buscar("soda");
        assertEquals(-1, r_1.getEstado());
        assertNull(r_1.getDato());
    }

    @Test
    public void testBuscar_CasoDesdeRaizInexistenteYMayusculas() {
        Trie<String> trie = new Trie<>();
        trie.insertar("taza", "taza");

        // No arranca ni por la misma letra
        Resultado<String> r = trie.buscar("sol");
        assertEquals(-1, r.getEstado());

        // Normaliza a minúsculas: buscar en mayúsculas debe funcionar
        trie.insertar("casa", "casa");
        assertEquals(1, trie.buscar("CASA").getEstado());
    }

    // ===================== predecir() =====================

    @Test
    public void testPredecir_ConPrefijo() {
        Trie<String> trie = new Trie<>();
        trie.insertar("sol", "sol");
        trie.insertar("son", "son");
        trie.insertar("sopa", "sopa");
        trie.insertar("taza", "taza");

        TDALista<String> lista = trie.predecir("so");

        // Verifico tamaño (con tu TDA)
        assertEquals(3, lista.cantElementos());

        // Verifico contenido usando buscar() de tu TDA (sin casts ni listas Java)
        assertEquals("sol", lista.buscar("sol"));
        assertEquals("son", lista.buscar("son"));
        assertEquals("sopa", lista.buscar("sopa"));
        assertNull(lista.buscar("taza"));
    }

    @Test
    public void testPredecir_PrefijoInexistente() {
        Trie<String> trie = new Trie<>();
        trie.insertar("sol", "sol");
        trie.insertar("son", "son");

        TDALista<String> lista = trie.predecir("ta");
        assertTrue(lista.esVacia());
        assertEquals(0, lista.cantElementos());
        // imprimir() en lista vacía devuelve "Lista vacia" según tu implementación
        assertEquals("Lista vacia", lista.imprimir());
    }

    // ===================== recorrer() =====================

    @Test
    public void testRecorrer_CompletoConListaEnlazada() {
        Trie<String> trie = new Trie<>();
        trie.insertar("sol", "sol");
        trie.insertar("son", "son");
        trie.insertar("sopa", "sopa");

        // Recolecto el recorrido en tu propia ListaEnlazada
        ListaEnlazada<String> recolectadas = new ListaEnlazada<>();
        trie.recorrer(recolectadas::insertar);

        assertEquals(3, recolectadas.cantElementos());
        // Valido contenido sin usar colecciones Java
        assertEquals("sol", recolectadas.buscar("sol"));
        assertEquals("son", recolectadas.buscar("son"));
        assertEquals("sopa", recolectadas.buscar("sopa"));
    }

    @Test
    public void testRecorrer_TrieVacio() {
        Trie<String> trie = new Trie<>();

        ListaEnlazada<String> recolectadas = new ListaEnlazada<>();
        trie.recorrer(recolectadas::insertar);

        assertTrue(recolectadas.esVacia());
        assertEquals(0, recolectadas.cantElementos());
        assertEquals("Lista vacia", recolectadas.imprimir());
    }
}
