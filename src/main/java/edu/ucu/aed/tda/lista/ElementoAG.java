
//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
public class ElementoAG<T extends Comparable<T>> implements TElementoAG<T> {

    private T dato;
    private TElementoAG<T> primerHijo;
    private TElementoAG<T> hermanoDerecho;

    public ElementoAG(T dato) {
        this.dato = dato;
        this.primerHijo = null;
        this.hermanoDerecho = null;
    }

    @Override
    public void setPrimerHijo(TElementoAG<T> primerHijo) {
        this.primerHijo = primerHijo;
    }

    @Override
    public void setHermanoDerecho(TElementoAG<T> hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

    @Override
    public TElementoAG<T> getPrimerHijo() {
        return this.primerHijo;
    }

    @Override
    public TElementoAG<T> getHermanoDerecho() {
        return this.hermanoDerecho;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public boolean esHoja() {
        if (this.primerHijo == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un nodo cuyo dato sea igual al criterio de búsqueda.
     * Se recorre primero el nodo actual, luego sus hijos y luego sus hermanos.
     */
    @Override
    public TElementoAG<T> buscar(Comparable<T> criterioBusqueda) {
        if (criterioBusqueda.compareTo(this.dato) == 0) {
            return this;
        }

        if (this.primerHijo != null) {
            TElementoAG<T> encontrado = this.primerHijo.buscar(criterioBusqueda);
            if (encontrado != null) {
                return encontrado;
            }
        }

        if (this.hermanoDerecho != null) {
            TElementoAG<T> encontrado = this.hermanoDerecho.buscar(criterioBusqueda);
            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    /**
     * Inserta un nuevo nodo como hijo de un nodo cuyo dato coincide con datoPadre.
     * Si el padre no existe, no hace nada.
     * Si el padre existe pero no tiene hijos, el nuevo nodo pasa a ser su primer hijo.
     * Si ya tiene hijos, el nuevo nodo se agrega como último hermano derecho.
     */
    @Override
    public void insertar(T datoPadre, T nuevoDato) {
        if (this.dato.compareTo(datoPadre) == 0) {
            TElementoAG<T> nuevo = new ElementoAG<T>(nuevoDato);

            if (this.primerHijo == null) {
                this.primerHijo = nuevo;
            } else {
                TElementoAG<T> actual = this.primerHijo;
                while (actual.getHermanoDerecho() != null) {
                    actual = actual.getHermanoDerecho();
                }
                actual.setHermanoDerecho(nuevo);
            }
        } else {
            if (this.primerHijo != null) {
                this.primerHijo.insertar(datoPadre, nuevoDato);
            }
            if (this.hermanoDerecho != null) {
                this.hermanoDerecho.insertar(datoPadre, nuevoDato);
            }
        }
    }

    /**
     * Devuelve la cantidad de nodos en el subárbol.
     */
    @Override
    public int cantidadNodos() {
        int total = 1; // este nodo

        if (this.primerHijo != null) {
            total = total + this.primerHijo.cantidadNodos();
        }

        if (this.hermanoDerecho != null) {
            total = total + this.hermanoDerecho.cantidadNodos();
        }

        return total;
    }

    /**
     * Devuelve la cantidad de hojas en el subárbol.
     * Una hoja es un nodo que no tiene hijos (primerHijo == null).
     * Se contabilizan también las hojas de los hermanos del nodo actual.
     */
    @Override
    public int cantidadHojas() {
        int total = 0;

        // Si este nodo es hoja, lo contamos
        if (this.esHoja()) {
            total = 1;
        } 
        // Si no es hoja, contamos las hojas de sus hijos
        else if (this.primerHijo != null) {
            total = total + this.primerHijo.cantidadHojas();
        }

        // Luego, sumamos las hojas de los hermanos (a nivel lateral)
        if (this.hermanoDerecho != null) {
            total = total + this.hermanoDerecho.cantidadHojas();
        }

        return total;
    }


    /**
     * Calcula la altura del subárbol con raíz en este nodo.
     * La altura de una hoja es 0.
     */
    @Override
    public int altura() {
        int alturaHijos = -1;

        if (this.primerHijo != null) {
            alturaHijos = this.primerHijo.altura();
        }

        int alturaHermanos = -1;

        if (this.hermanoDerecho != null) {
            alturaHermanos = this.hermanoDerecho.altura();
        }

        int alturaActual = alturaHijos + 1;

        if (alturaActual > alturaHermanos) {
            return alturaActual;
        } else {
            return alturaHermanos;
        }
    }

    /**
     * Recorre en preorden: primero el nodo actual, luego sus hijos, luego sus hermanos.
     */
    @Override
    public void preOrder(java.util.function.Consumer<TElementoAG<T>> consumidor) {
        consumidor.accept(this);

        if (this.primerHijo != null) {
            this.primerHijo.preOrder(consumidor);
        }

        if (this.hermanoDerecho != null) {
            this.hermanoDerecho.preOrder(consumidor);
        }
    }
    
    /**
     * Recorre en postorden: primero los hijos (de izquierda a derecha),
     * luego el nodo actual, y finalmente los hermanos.
     * Corrige el orden para respetar el pseudocódigo del curso.
     */
    @Override
    public void postOrder(java.util.function.Consumer<TElementoAG<T>> consumidor) {
        // Primero recorremos todos los hijos (rama descendente)
        if (this.primerHijo != null) {
            this.primerHijo.postOrder(consumidor);
        }

        // Luego procesamos este nodo (cuando ya se recorrieron sus hijos)
        consumidor.accept(this);

        // Finalmente, recorremos los hermanos a la derecha (rama lateral)
        if (this.hermanoDerecho != null) {
            this.hermanoDerecho.postOrder(consumidor);
        }
    }
}
