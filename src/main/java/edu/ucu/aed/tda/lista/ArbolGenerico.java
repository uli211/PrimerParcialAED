//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
import java.util.function.Consumer;

/**
 * Implementa un Árbol Genérico (n hijos por nodo)
 * utilizando la representación Primer Hijo / Siguiente Hermano.
 */
public class ArbolGenerico<T extends Comparable<T>> {

    private TElementoAG<T> raiz;

    /**
     * Constructor vacío: crea un árbol sin nodos.
     */
    public ArbolGenerico() {
        this.raiz = null;
    }

    /**
     * Constructor con nodo raíz.
     */
    public ArbolGenerico(TElementoAG<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Devuelve la raíz del árbol.
     */
    public TElementoAG<T> getRaiz() {
        return raiz;
    }

    /**
     * Devuelve true si el árbol está vacío.
     */
    public boolean esVacio() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserta un nuevo nodo en el árbol.
     * Si el árbol está vacío, el nuevo nodo será la raíz.
     * Si no está vacío, busca el datoPadre y agrega el nuevo nodo como hijo.
     */
    public void insertar(T datoPadre, T nuevoDato) {
        if (this.raiz == null) {
            // Si el árbol está vacío, el primer dato insertado será la raíz.
            this.raiz = new ElementoAG<T>(nuevoDato);
        } else {
            this.raiz.insertar(datoPadre, nuevoDato);
        }
    }

    /**
     * Busca un nodo cuyo dato coincida con el criterio dado.
     * Si el árbol está vacío o el dato no existe, retorna null.
     */
    public TElementoAG<T> buscar(Comparable<T> criterioBusqueda) {
        if (this.raiz == null) {
            return null;
        } else {
            return this.raiz.buscar(criterioBusqueda);
        }
    }

    /**
     * Recorre el árbol en preorden, aplicando la acción indicada
     * sobre cada nodo visitado.
     */
    public void preOrder(Consumer<T> consumidor) {
        if (this.raiz != null) {
            this.raiz.preOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    /**
     * Recorre el árbol en postorden, aplicando la acción indicada
     * sobre cada nodo visitado.
     */
    public void postOrder(Consumer<T> consumidor) {
        if (this.raiz != null) {
            this.raiz.postOrder(nodo -> consumidor.accept(nodo.getDato()));
        }
    }

    /**
     * Devuelve la cantidad total de nodos del árbol.
     */
    public int cantidadNodos() {
        if (this.raiz == null) {
            return 0;
        } else {
            return this.raiz.cantidadNodos();
        }
    }

    /**
     * Devuelve la cantidad de hojas (nodos sin hijos) del árbol.
     */
    public int cantidadHojas() {
        if (this.raiz == null) {
            return 0;
        } else {
            return this.raiz.cantidadHojas();
        }
    }

    /**
     * Devuelve la altura del árbol.
     * Si el árbol está vacío, la altura es -1.
     */
    public int altura() {
        if (this.raiz == null) {
            return -1;
        } else {
            return this.raiz.altura();
        }
    }

    /**
     * Muestra el recorrido PreOrder del árbol por consola.
     */
    public void imprimirPreOrder() {
        System.out.print("PreOrder: ");
        this.preOrder(dato -> System.out.print(dato + " "));
        System.out.println();
    }

    /**
     * Muestra el recorrido PostOrder del árbol por consola.
     */
    public void imprimirPostOrder() {
        System.out.print("PostOrder: ");
        this.postOrder(dato -> System.out.print(dato + " "));
        System.out.println();
    }
}
