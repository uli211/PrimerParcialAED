//package src.test.java.edu.ucu.aed.ut02.tda.lista;
package edu.ucu.aed.ut02.tda.lista;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
//import src.main.java.edu.ucu.aed.tda.lista.ArbolBinarioBusqueda;
import edu.ucu.aed.tda.lista.ArbolBinarioBusqueda;
public class ArbolBinarioBusquedaTest {

    @Test
    void insertar_buscar_inorder_y_duplicados() {
        ArbolBinarioBusqueda<Integer> abb = new ArbolBinarioBusqueda<>();
        assertTrue(abb.esVacio());
        assertNull(abb.buscar(99));

        assertTrue(abb.insertar(10));
        assertTrue(abb.insertar(5));
        assertTrue(abb.insertar(15));
        assertFalse(abb.esVacio());
        assertEquals(3, abb.cantidadNodos());

        // duplicado
        assertFalse(abb.insertar(10));
        assertEquals(3, abb.cantidadNodos());

        assertEquals(15, abb.buscar(15));
        assertNull(abb.buscar(7));

        List<Integer> in = new ArrayList<>();
        abb.inOrder(in::add);
        assertEquals(List.of(5,10,15), in);
    }

    @Test
    void eliminar_0_1_2_hijos() {
        ArbolBinarioBusqueda<Integer> abb = new ArbolBinarioBusqueda<>();
        for (int v : new int[]{10,5,1,7,15,12,18}) abb.insertar(v);

        // hoja
        assertTrue(abb.eliminar(1));
        assertNull(abb.buscar(1));
        // 1 hijo
        assertTrue(abb.eliminar(5)); // queda 7
        assertNull(abb.buscar(5));
        // 2 hijos
        assertTrue(abb.eliminar(15)); // reemplaza por 12
        assertNull(abb.buscar(15));

        List<Integer> in = new ArrayList<>();
        abb.inOrder(in::add);
        assertEquals(List.of(7,10,12,18), in);

        assertEquals(4, abb.cantidadNodos());
        assertEquals(2, abb.cantidadHojas()); // 7 y 18
        assertEquals(2, abb.cantidadNodosInternos()); // 10 y 12
    }

    @Test
    void recorridos_pre_post_y_vacios() {
        ArbolBinarioBusqueda<Integer> abb = new ArbolBinarioBusqueda<>();
        // recorridos en vacío no deben lanzar excepción
        abb.inOrder(x -> {});
        abb.preOrder(x -> {});
        abb.postOrder(x -> {});
        assertTrue(abb.esVacio());

        abb.insertar(2);
        abb.insertar(1);
        abb.insertar(3);

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        abb.preOrder(pre::add);
        abb.postOrder(post::add);

        assertEquals(List.of(2,1,3), pre);
        assertEquals(List.of(1,3,2), post);
    }
}
