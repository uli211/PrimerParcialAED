package edu.ucu.aed.ut02.tda.lista;
//package src.test.java.edu.ucu.aed.ut02.tda.lista;
import org.junit.jupiter.api.Test;
import edu.ucu.aed.tda.lista.Nodo;
import edu.ucu.aed.tda.lista.TDANodo;
//import src.main.java.edu.ucu.aed.tda.lista.Nodo;
//import src.main.java.edu.ucu.aed.tda.lista.TDANodo;
import static org.junit.jupiter.api.Assertions.*;

public class NodoTest {

    @Test
    public void gettersYSetters() {
        Nodo<Integer> n1 = new Nodo<Integer>(10);
        Nodo<Integer> n2 = new Nodo<Integer>(20);
        Nodo<Integer> n3 = new Nodo<Integer>(30);

        assertEquals(10, n1.getDato());
        assertNull(n1.getSiguiente());
        assertNull(n1.getAnterior());

        n1.setSiguiente(n2);
        n2.setAnterior(n1);
        n2.setSiguiente(n3);
        n3.setAnterior(n2);

        assertEquals(20, ((TDANodo<Integer>) n1.getSiguiente()).getDato());
        assertEquals(10, ((TDANodo<Integer>) n2.getAnterior()).getDato());
        assertEquals(30, ((TDANodo<Integer>) n2.getSiguiente()).getDato());
        assertEquals(20, ((TDANodo<Integer>) n3.getAnterior()).getDato());
    }
}
