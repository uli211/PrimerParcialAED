package edu.ucu.aed.tda.lista;

import java.util.function.Consumer;

/**
 * Árbol Genérico implementado mediante Lista Enlazada de hijos.
 */
public class ArbolGenericoLE<T extends Comparable<T>> {

    private TElementoAGLE<T> raiz;

    public ArbolGenericoLE() {
        this.raiz = null;
    }

    public ArbolGenericoLE(TElementoAGLE<T> raiz) {
        this.raiz = raiz;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public TElementoAGLE<T> getRaiz() {
        return raiz;
    }

    public boolean insertar(T datoPadre, T nuevoDato) {
        if (raiz == null) {
            // Si no hay raíz, el nuevoDato será la raíz
            raiz = new ElementoAGLE<>(nuevoDato);
            return true;
        }

        TElementoAGLE<T> nodoPadre = raiz.buscar(datoPadre);
        if (nodoPadre != null) {
            nodoPadre.getHijos().insertar(new ElementoAGLE<>(nuevoDato));
            return true;
        }

        return false;
    }

    public TElementoAGLE<T> buscar(Comparable<T> criterioBusqueda) {
        if (raiz != null) {
            return raiz.buscar(criterioBusqueda);
        }
        return null;
    }

    public int cantidadNodos() {
        if (raiz == null) return 0;
        return raiz.cantidadNodos();
    }

    public int cantidadHojas() {
        if (raiz == null) return 0;
        return raiz.cantidadHojas();
    }

    public int altura() {
        if (raiz == null) return 0;
        return raiz.altura();
    }

    public void preOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.preOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    public void postOrder(Consumer<T> consumidor) {
        if (raiz != null) {
            raiz.postOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

        /**
     * Devuelve el nivel (profundidad) del nodo que contiene el dato especificado.
     * Si el dato no existe, retorna -1.
     */
    public int nivel(T dato) {
        if (raiz == null) return -1;
        return nivelRec(raiz, dato, 0);
    }

    private int nivelRec(TElementoAGLE<T> nodo, T dato, int nivelActual) {
        if (nodo.getDato().compareTo(dato) == 0) {
            return nivelActual;
        }

        NodoAG<TElementoAGLE<T>> hijo = nodo.getHijos().getCabeza();
        while (hijo != null) {
            int nivelEncontrado = nivelRec(hijo.getDato(), dato, nivelActual + 1);
            if (nivelEncontrado != -1) {
                return nivelEncontrado;
            }
            hijo = hijo.getSiguiente();
        }
        return -1;
    }


    /**
     * Elimina el nodo (y todo su subárbol) que contiene el dato especificado.
     * Si el nodo es la raíz, el árbol queda vacío.
     */
    public boolean eliminar(T dato) {
        if (raiz == null) return false;

        // Caso 1: la raíz es el nodo a eliminar
        if (raiz.getDato().compareTo(dato) == 0) {
            raiz = null;
            return true;
        }

        // Caso 2: buscar entre los hijos de la raíz
        return eliminarRec(raiz, dato);
    }

    private boolean eliminarRec(TElementoAGLE<T> nodo, T dato) {
        NodoAG<TElementoAGLE<T>> anterior = null;
        NodoAG<TElementoAGLE<T>> actual = nodo.getHijos().getCabeza();

        while (actual != null) {
            if (actual.getDato().getDato().compareTo(dato) == 0) {
                // Eliminamos el nodo actual de la lista de hijos
                if (anterior == null) {
                    // El primero de la lista
                    nodo.getHijos().getCabeza().setDato(null); // Limpiar dato (opcional)
                    nodo.getHijos().getCabeza().setSiguiente(actual.getSiguiente());
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return true;
            } else {
                // Buscar recursivamente en los subárboles de los hijos
                if (eliminarRec(actual.getDato(), dato)) {
                    return true;
                }
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false; // No se encontró el dato
    }

}
