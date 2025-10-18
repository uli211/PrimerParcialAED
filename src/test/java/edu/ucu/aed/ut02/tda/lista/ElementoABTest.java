//package src.test.java.edu.ucu.aed.ut02.tda.lista;
package edu.ucu.aed.ut02.tda.lista;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
//import src.main.java.edu.ucu.aed.tda.lista.ElementoAB;
//import src.main.java.edu.ucu.aed.tda.lista.TElementoAB;
import edu.ucu.aed.tda.lista.ElementoAB;
import edu.ucu.aed.tda.lista.TElementoAB;
public class ElementoABTest {

    @Test
    void hoja_conteos_niveles_altura() {
        ElementoAB<Integer> n10 = new ElementoAB<>(10);
        assertTrue(n10.esHoja());
        assertEquals(1, n10.cantidadNodos());
        assertEquals(1, n10.cantidadHojas());
        assertEquals(0, n10.cantidadNodosInternos()); // un nodo hoja no es interno
        assertEquals(0, n10.altura());

        // arma árbol
        ElementoAB<Integer> n5 = new ElementoAB<>(5);
        ElementoAB<Integer> n15 = new ElementoAB<>(15);
        n10.setHijoIzquierdo(n5);
        n10.setHijoDerecho(n15);

        ElementoAB<Integer> n2 = new ElementoAB<>(2);
        n5.setHijoIzquierdo(n2);

        assertFalse(n10.esHoja());
        assertEquals(4, n10.cantidadNodos());
        assertEquals(2, n10.cantidadHojas()); // 2 y 15
        assertEquals(2, n10.cantidadNodosInternos()); // 10 y 5
        assertEquals(2, n10.altura()); // 10->5->2

        assertEquals(0, n10.obtenerNivel(10));
        assertEquals(1, n10.obtenerNivel(5));
        assertEquals(2, n10.obtenerNivel(2));
        assertEquals(-1, n10.obtenerNivel(999));
    }

    @Test
    void insertar_buscar_eliminar_y_recorridos() {
        ElementoAB<Integer> raiz = new ElementoAB<>(10);
        raiz.insertar(5);
        raiz.insertar(15);
        raiz.insertar(7);

        assertNotNull(raiz.buscar(15));
        assertNull(raiz.buscar(99));

        // in-order
        List<Integer> in = new ArrayList<>();
        raiz.inOrder(n -> in.add(n.getDato()));
        assertEquals(List.of(5,7,10,15), in);

        // pre-order
        List<Integer> pre = new ArrayList<>();
        raiz.preOrder(n -> pre.add(n.getDato()));
        assertEquals(List.of(10,5,7,15), pre);

        // post-order
        List<Integer> post = new ArrayList<>();
        raiz.postOrder(n -> post.add(n.getDato()));
        assertEquals(List.of(7,5,15,10), post);

        // eliminar hoja
        raiz = (ElementoAB<Integer>) raiz.eliminar(7);
        assertNull(raiz.buscar(7));

        // eliminar con 2 hijos (10)
        raiz = (ElementoAB<Integer>) raiz.eliminar(10);
        assertNull(raiz.buscar(10));
        assertEquals(2, raiz.cantidadNodos()); // quedaron 5 y 15
    }

    @Test
    void sin_orden_insertar_buscar_eliminar() {
        ElementoAB<Integer> r = new ElementoAB<>(10);
        r.insertarSinOrden(5);  // izq
        r.insertarSinOrden(15); // der
        r.insertarSinOrden(2);  // recursivo por izq

        assertNotNull(r.buscarSinOrden(2));
        assertNull(r.buscarSinOrden(999));

        r = (ElementoAB<Integer>) r.eliminarSinOrden(5);
        assertNull(r.buscarSinOrden(5));
        assertEquals(3, r.cantidadNodos());
    }

    @Test
    void avl_altura_balance_y_rotaciones() {
        // armamos un mini subárbol para comprobar getters/setters de altura y balance
        ElementoAB<Integer> n = new ElementoAB<>(10);
        ElementoAB<Integer> izq = new ElementoAB<>(5);
        ElementoAB<Integer> der = new ElementoAB<>(15);
        n.setHijoIzquierdo(izq);
        n.setHijoDerecho(der);

        izq.setAltura(0);
        der.setAltura(0);
        n.actualizarAltura();
        assertEquals(1, n.getAltura());
        assertEquals(0, n.getBalance());

        // rotación simple derecha (LL)
        ElementoAB<Integer> n2 = new ElementoAB<>(7);
        izq.setHijoDerecho(n2);
        izq.actualizarAltura(); n.actualizarAltura();
        ElementoAB<Integer> nueva = (ElementoAB<Integer>) n.rotacionDerecha();
        assertEquals(5, nueva.getDato());

        // rotación simple izquierda (RR) sobre un árbol pequeño
        ElementoAB<Integer> a = new ElementoAB<>(1);
        ElementoAB<Integer> b = new ElementoAB<>(2);
        a.setHijoDerecho(b);
        a.actualizarAltura();
        ElementoAB<Integer> raiz = (ElementoAB<Integer>) a.rotacionIzquierda();
        assertEquals(2, raiz.getDato());

        // rotaciones dobles deben encadenar sin NPE
        ElementoAB<Integer> x = new ElementoAB<>(30);
        x.setHijoIzquierdo(new ElementoAB<>(10));
        x.getHijoIzquierdo().setHijoDerecho(new ElementoAB<>(20));
        x.getHijoIzquierdo().actualizarAltura(); x.actualizarAltura();
        TElementoAB<Integer> root = x.rotacionIzquierdaDerecha();
        assertNotNull(root);

        ElementoAB<Integer> y = new ElementoAB<>(10);
        y.setHijoDerecho(new ElementoAB<>(30));
        y.getHijoDerecho().setHijoIzquierdo(new ElementoAB<>(20));
        y.getHijoDerecho().actualizarAltura(); y.actualizarAltura();
        TElementoAB<Integer> root2 = y.rotacionDerechaIzquierda();
        assertNotNull(root2);
    }
}
