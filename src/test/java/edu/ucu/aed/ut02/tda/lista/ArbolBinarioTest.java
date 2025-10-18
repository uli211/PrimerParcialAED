//package src.test.java.edu.ucu.aed.ut02.tda.lista;
package edu.ucu.aed.ut02.tda.lista;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
//import src.main.java.edu.ucu.aed.tda.lista.ArbolBinario;
import edu.ucu.aed.tda.lista.ArbolBinario;
public class ArbolBinarioTest {

    @Test
    void insertar_sin_orden_buscar_eliminar() {
        ArbolBinario<Integer> ab = new ArbolBinario<>();
        assertTrue(ab.esVacio());
        assertNull(ab.buscar(5));

        // Inserciones: raíz -> izq -> der -> recursivo por izq
        assertTrue(ab.insertar(10)); // raíz
        assertTrue(ab.insertar(5));  // izq
        assertTrue(ab.insertar(15)); // der
        assertTrue(ab.insertar(2));  // recursivo por izq del 5

        assertFalse(ab.esVacio());
        assertEquals(4, ab.cantidadNodos());
        assertEquals(2, ab.cantidadHojas()); // 2 y 15
        assertEquals(2, ab.cantidadNodosInternos()); // 10 y 5

        // buscar sin orden
        assertEquals(15, ab.buscar(15));
        assertNull(ab.buscar(99));

        // eliminar sin orden (propaga por todo el árbol)
        assertTrue(ab.eliminar(5));
        assertNull(ab.buscar(5));
        assertEquals(3, ab.cantidadNodos());
    }

    @Test
    void recorridos_no_vacios_y_vacios() {
        ArbolBinario<Integer> ab = new ArbolBinario<>();
        // en vacío
        ab.inOrder(x -> {});
        ab.preOrder(x -> {});
        ab.postOrder(x -> {});

        ab.insertar(10);
        ab.insertar(5);
        ab.insertar(15);
        ab.insertar(2);

        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        ab.inOrder(in::add);
        ab.preOrder(pre::add);
        ab.postOrder(post::add);

        // Como no hay orden, sólo validamos que tengan los 4 elementos
        assertEquals(Set.of(10,5,15,2), new HashSet<>(in));
        assertEquals(Set.of(10,5,15,2), new HashSet<>(pre));
        assertEquals(Set.of(10,5,15,2), new HashSet<>(post));
    }
}
