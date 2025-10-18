//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
import java.util.function.Consumer;

/**
 * Implementación de un Arbol Binario Busqeuda (AB).
 * 
 * A diferencia de un AB:
 * - Mantiene orden en la inserción de elementos.
 * - Las busquedas NO recorren necesariamente todo el árbol.
 * - La eliminación aprovecha ordenamientos.
 * 
 */

public class ArbolBinarioBusqueda<T extends Comparable<T>> implements TDAArbolBinario<T> {

        private TElementoAB<T> raiz;

        public ArbolBinarioBusqueda(TElementoAB<T> raiz){
            this.raiz = raiz;
        }

        public ArbolBinarioBusqueda() {
            this.raiz = null;
        }

        public TElementoAB<T> getRaiz() {
            return raiz;
        }


        @Override
        public T buscar(Comparable<T> criterioBusqueda) {
            if (raiz != null) {
                TElementoAB<T> nodo = raiz.buscar(criterioBusqueda);
                if (nodo != null) {
                    return nodo.getDato();
                }
            }
            return null;
        }

        @Override
        public boolean eliminar(Comparable<T> criterioBusqueda) {
            if (raiz != null) {
                raiz = raiz.eliminar(criterioBusqueda);
                return true;
            }
            return false;
        }

        @Override
        public boolean insertar(T dato) {
            if (raiz == null) {
                raiz = new ElementoAB<>(dato);
                return true;
            } else {
                if (raiz.buscar(dato) == null) { // no existe
                    raiz.insertar(dato);
                    return true;
                } else {
                    return false; // ya estaba en el árbol
                }
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
            return raiz == null;
        }

        @Override
        public int cantidadNodos() {
            if (raiz != null) {
                return raiz.cantidadNodos();
            }
            return 0;
        }

        @Override
        public int cantidadHojas() {
            if (raiz != null) {
                return raiz.cantidadHojas();
            }
            return 0;
        }

        @Override
        public int cantidadNodosInternos() {
            if (raiz != null) {
                return raiz.cantidadNodosInternos();
            }
            return 0;
        }

        public void setRaiz(TElementoAB<T> raiz){
            this.raiz = raiz;
        }
    }

