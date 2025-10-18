//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
public class LinkedList<T extends Comparable<T>> implements TDALista<T> {

    private TDANodo<T> cabeza;
    private TDANodo<T> finalLista;
    private int tamanio;

    public LinkedList() {
        this.cabeza = null;
        this.finalLista = null;
        this.tamanio = 0;
    }

    @Override
    public boolean insertar(T data) { //O(1) a diferencia de en ListaEnlazada
        TDANodo<T> nuevoNodo = new Nodo<>(data);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            finalLista = nuevoNodo;
        } else {
            finalLista.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(finalLista);
            finalLista = nuevoNodo;
        }

        tamanio++;
        System.out.println("Insertado al final: " + data);
        return true;
    }

    @Override
    public T eliminar(Comparable<T> identificador) {
        TDANodo<T> temporal = cabeza;

        while (temporal != null && !temporal.getDato().equals(identificador)) {
            temporal = temporal.getSiguiente();
        }

        if (temporal == null) {
            System.out.println("Elemento no encontrado");
            return null;
        }

        // Caso 1: eliminar cabeza
        if (temporal == cabeza) {
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) cabeza.setAnterior(null);
            else finalLista = null; // si lista queda vacía
        }
        // Caso 2: eliminar final
        else if (temporal == finalLista) {
            finalLista = finalLista.getAnterior();
            finalLista.setSiguiente(null);
        }
        // Caso 3: nodo intermedio
        else {
            temporal.getAnterior().setSiguiente(temporal.getSiguiente());
            temporal.getSiguiente().setAnterior(temporal.getAnterior());
        }

        tamanio--;
        System.out.println("Elemento eliminado: " + temporal.getDato());
        return temporal.getDato();
    }

    @Override
    public String imprimir() {
        TDANodo<T> temp = cabeza;
        StringBuilder sb = new StringBuilder();

        while (temp != null) {
            sb.append(temp.getDato()).append(" ");
            temp = temp.getSiguiente();
        }

        System.out.println("Lista: " + sb);
        return sb.toString();
    }

    public String imprimirReverso() {
        TDANodo<T> temp = finalLista;
        StringBuilder sb = new StringBuilder();

        while (temp != null) {
            sb.append(temp.getDato()).append(" ");
            temp = temp.getAnterior();
        }

        System.out.println("Lista inversa: " + sb);
        return sb.toString();
    }

    @Override
    public int cantElementos() {
        return tamanio;
    }

    @Override
    public boolean esVacia() {
        return tamanio == 0;
    }

    @Override
    public T buscar(Comparable<T> identificador) {
        TDANodo<T> temporal = this.cabeza;

        while (temporal != null && !temporal.getDato().equals(identificador)) {
            temporal = temporal.getSiguiente();
        }

        if (temporal == null) {
            System.out.println("Elemento NO encontrado: " + identificador);
            return null;
        } else {
            System.out.println("Elemento encontrado: " + temporal.getDato());
            return temporal.getDato();
        }
    }

    @Override
    public T obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= this.tamanio) {
            System.out.println("Índice fuera de rango");
            return null;
        }

        TDANodo<T> temporal = this.cabeza;
        int contador = 0;

        while (contador < indice) {
            temporal = temporal.getSiguiente();
            contador++;
        }

        System.out.println("Elemento en índice " + indice + ": " + temporal.getDato());
        return temporal.getDato();
    }

    @Override
    public String imprimir(String delimitador) {
        TDANodo<T> temporal = this.cabeza;
        if (temporal == null) {
            return "Lista vacía";
        }

        StringBuilder sb = new StringBuilder();
        while (temporal != null) {
            sb.append(temporal.getDato().toString());
            temporal = temporal.getSiguiente();
            if (temporal != null) {
                sb.append(delimitador);
            }
        }

        System.out.println("Elementos de la lista: " + sb);
        return sb.toString();
    }



}
