//package src.test.java.edu.ucu.aed.ut02.tda.lista;
package edu.ucu.aed.ut02.tda.lista;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
/*
import src.main.java.edu.ucu.aed.tda.lista.TElementoAB;
import src.main.java.edu.ucu.aed.tda.lista.ArbolAVL;
import src.main.java.edu.ucu.aed.tda.lista.ArrayList;
*/

import edu.ucu.aed.tda.lista.TElementoAB;
import edu.ucu.aed.tda.lista.ArbolAVL;
import edu.ucu.aed.tda.lista.ArrayList;
public class ArbolAVLTest {

    private static <T extends Comparable<T>> boolean checkAVLInvariants(TElementoAB<T> n) {
        if (n == null) return true;
        int izq = (n.getHijoIzquierdo() == null) ? -1 : n.getHijoIzquierdo().getAltura();
        int der = (n.getHijoDerecho() == null) ? -1 : n.getHijoDerecho().getAltura();
        int balance = izq - der;
        if (balance < -1 || balance > 1) return false;
        return checkAVLInvariants(n.getHijoIzquierdo()) && checkAVLInvariants(n.getHijoDerecho());
    }

    @Test
    void insertar_buscar_basico_y_traversals() {
        ArbolAVL<Integer> avl = new ArbolAVL<>();
        assertTrue(avl.esVacio());
        assertNull(avl.buscar(10));

        for (int v : new int[]{10, 5, 15, 2, 7, 12, 20}) {
            assertTrue(avl.insertar(v));
        }
        assertFalse(avl.esVacio());
        assertEquals(7, avl.cantidadNodos());
        assertEquals(4, avl.cantidadHojas()); // 2,7,12,20
        assertEquals(3, avl.cantidadNodosInternos()); // 10,5,15

        assertEquals(12, avl.buscar(12));
        assertNull(avl.buscar(99));

       ArrayList<Integer> in = new ArrayList<>();
       ArrayList<Integer> pre = new ArrayList<>();
       ArrayList<Integer> post = new ArrayList<>();

        avl.inOrder(in::insertar);
        avl.preOrder(pre::insertar);
        avl.postOrder(post::insertar);


        assertEquals(7, in.cantElementos());
        assertEquals((Integer)2,  in.obtenerPorIndice(0));
        assertEquals((Integer)5,  in.obtenerPorIndice(1));
        assertEquals((Integer)7,  in.obtenerPorIndice(2));
        assertEquals((Integer)10, in.obtenerPorIndice(3));
        assertEquals((Integer)12, in.obtenerPorIndice(4));
        assertEquals((Integer)15, in.obtenerPorIndice(5));
        assertEquals((Integer)20, in.obtenerPorIndice(6));


        assertEquals(in.cantElementos(), pre.cantElementos());
        assertEquals(in.cantElementos(), post.cantElementos());


        for (int i = 0; i < in.cantElementos(); i++) {
            Integer x = in.obtenerPorIndice(i);
            assertNotNull(pre.buscar(x),  "pre no contiene " + x);
            assertNotNull(post.buscar(x), "post no contiene " + x);
        }


        for (int i = 0; i < pre.cantElementos(); i++) {
            Integer x = pre.obtenerPorIndice(i);
            assertNotNull(in.buscar(x), "pre tiene un extra: " + x);
        }


        for (int i = 0; i < post.cantElementos(); i++) {
            Integer x = post.obtenerPorIndice(i);
            assertNotNull(in.buscar(x), "post tiene un extra: " + x);
        }

        assertTrue(checkAVLInvariants(avl.getRaiz()));
    }

    @Test
    void no_duplicados_no_incrementan_tamano() {
        ArbolAVL<Integer> avl = new ArbolAVL<>();
        assertTrue(avl.insertar(10));
        assertTrue(avl.insertar(5));
        assertTrue(avl.insertar(15));
        int antes = avl.cantidadNodos();
        assertTrue(avl.insertar(10)); // devuelve true, pero no debe crecer
        assertEquals(antes, avl.cantidadNodos());
    }

    @Test
    void rotacion_LL() {
        ArbolAVL<Integer> avl = new ArbolAVL<>();
        avl.insertar(30);
        avl.insertar(20);
        avl.insertar(10); // desequilibra (LL)
        assertEquals(20, avl.getRaiz().getDato());
        assertTrue(checkAVLInvariants(avl.getRaiz()));
    }

    @Test
    void rotacion_RR() {
        ArbolAVL<Integer> avl = new ArbolAVL<>();
        avl.insertar(10);
        avl.insertar(20);
        avl.insertar(30); // RR
        assertEquals(20, avl.getRaiz().getDato());
        assertTrue(checkAVLInvariants(avl.getRaiz()));
    }

    @Test
    void rotacion_LR() {
        ArbolAVL<Integer> avl = new ArbolAVL<>();
        avl.insertar(30);
        avl.insertar(10);
        avl.insertar(20); // LR
        assertEquals(20, avl.getRaiz().getDato());
        assertTrue(checkAVLInvariants(avl.getRaiz()));
    }

    @Test
    void rotacion_RL() {
        ArbolAVL<Integer> avl = new ArbolAVL<>();
        avl.insertar(10);
        avl.insertar(30);
        avl.insertar(20); // RL
        assertEquals(20, avl.getRaiz().getDato());
        assertTrue(checkAVLInvariants(avl.getRaiz()));
    }
}
