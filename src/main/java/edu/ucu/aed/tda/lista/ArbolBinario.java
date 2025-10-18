//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
import java.util.function.Consumer;

/**
 * Implementación de un Arbol Binario genérico (AB).
 * 
 * A diferencia de un ABB o AVL:
 * - No mantiene orden en la inserción de elementos.
 * - Las busqueda recorren todo el arbol.
 * - La eliminación no aprovecha ordenamientos.
 * 
 */
public class ArbolBinario<T extends Comparable<T>> implements TDAArbolBinario<T> {

    private TElementoAB<T> raiz;

    // Constructor vacío
    public ArbolBinario() {
        this.raiz = null;
    }

    // Constructor con raíz inicial
    public ArbolBinario(TElementoAB<T> raiz) {
        this.raiz = raiz;
    }

    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    @Override
    public T buscar(Comparable<T> criterioBusqueda) {
        if (raiz != null) {
            TElementoAB<T> nodo = raiz.buscarSinOrden(criterioBusqueda);
            if (nodo != null) {
                return nodo.getDato();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        if (raiz != null) {
            raiz = raiz.eliminarSinOrden(criterioBusqueda);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insertar(T dato) {
        if (raiz == null) {
            raiz = new ElementoAB<>(dato);
            return true;
        } else {
            raiz.insertarSinOrden(dato);
            return true;
        }
    }

    @Override
    public void inOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.inOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    @Override
    public void preOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.preOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    @Override
    public void postOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.postOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    @Override
    public boolean esVacio() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int cantidadNodos() {
        if (raiz != null) {
            return raiz.cantidadNodos();
        } else {
            return 0;
        }
    }

    @Override
    public int cantidadHojas() {
        if (raiz != null) {
            return raiz.cantidadHojas();
        } else {
            return 0;
        }
    }

    @Override
    public int cantidadNodosInternos() {
        if (raiz != null) {
            return raiz.cantidadNodosInternos();
        } else {
            return 0;
        }
    }
}
