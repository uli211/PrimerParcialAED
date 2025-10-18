//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
import java.util.function.Consumer;

/**
 * Implementación de un Árbol AVL.
 * 
 * Es un árbol binario de búsqueda auto-balanceado.
 * Cada inserción y eliminación actualiza alturas y
 * mantiene el factor de balance entre -1 y 1.
 */
public class ArbolAVL<T extends Comparable<T>> implements TDAArbolBinario<T> {

    private TElementoAB<T> raiz;

    public ArbolAVL() {
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
    public boolean insertar(T dato) {
        if (raiz == null) {
            raiz = new ElementoAB<>(dato);
            return true;
        }
        raiz = insertarAVL(raiz, dato);
        return true;
    }

    private TElementoAB<T> insertarAVL(TElementoAB<T> nodo, T dato) {
        if (nodo == null) {
            return new ElementoAB<>(dato);
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setHijoIzquierdo(insertarAVL(nodo.getHijoIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setHijoDerecho(insertarAVL(nodo.getHijoDerecho(), dato));
        } else {
            // no se permiten duplicados
            return nodo;
        }

        nodo.actualizarAltura();
        return balancear(nodo);
    }

    @Override
    public boolean eliminar(Comparable<T> criterioBusqueda) {
        if (raiz != null) {
            raiz = eliminarAVL(raiz, criterioBusqueda);
            return true;
        }
        return false;
    }

    private TElementoAB<T> eliminarAVL(TElementoAB<T> nodo, Comparable<T> criterioBusqueda) {
        if (nodo == null) {
            return null;
        }

        if (criterioBusqueda.compareTo(nodo.getDato()) < 0) {
            nodo.setHijoIzquierdo(eliminarAVL(nodo.getHijoIzquierdo(), criterioBusqueda));
        } else if (criterioBusqueda.compareTo(nodo.getDato()) > 0) {
            nodo.setHijoDerecho(eliminarAVL(nodo.getHijoDerecho(), criterioBusqueda));
        } else {
            // caso encontrado
            if (nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null) {
                return null;
            } else if (nodo.getHijoIzquierdo() == null) {
                return nodo.getHijoDerecho();
            } else if (nodo.getHijoDerecho() == null) {
                return nodo.getHijoIzquierdo();
            } else {
                // reemplazo con el mayor del subárbol izquierdo
                TElementoAB<T> maxIzq = nodo.getHijoIzquierdo();
                while (maxIzq.getHijoDerecho() != null) {
                    maxIzq = maxIzq.getHijoDerecho();
                }
                nodo.setDato(maxIzq.getDato());
                nodo.setHijoIzquierdo(eliminarAVL(nodo.getHijoIzquierdo(), maxIzq.getDato()));
            }
        }

        nodo.actualizarAltura();
        return balancear(nodo);
    }

    private TElementoAB<T> balancear(TElementoAB<T> nodo) {
        int balance = nodo.getBalance();

        // Caso Izquierda-Izquierda (LL)
        if (balance > 1 && nodo.getHijoIzquierdo().getBalance() >= 0) {
            return nodo.rotacionDerecha();
        }

        // Caso Derecha-Derecha (RR)
        if (balance < -1 && nodo.getHijoDerecho().getBalance() <= 0) {
            return nodo.rotacionIzquierda();
        }

        // Caso Izquierda-Derecha (LR)
        if (balance > 1 && nodo.getHijoIzquierdo().getBalance() < 0) {
            return nodo.rotacionIzquierdaDerecha();
        }

        // Caso Derecha-Izquierda (RL)
        if (balance < -1 && nodo.getHijoDerecho().getBalance() > 0) {
            return nodo.rotacionDerechaIzquierda();
        }

        return nodo; // ya balanceado
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
}
