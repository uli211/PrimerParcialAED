//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
public class Conjunto<T extends Comparable<T>> implements TDAConjunto<T> {

    private ListaEnlazada<T> listaInterna;

    public Conjunto() {
        this.listaInterna = new ListaEnlazada<>();
    }

    @Override
    public T obtenerPorIndice(int indice){
        return listaInterna.obtenerPorIndice(indice);
    }

    public TDANodo<T> encontrarNodoCabeza(){
        return this.listaInterna.encontrarNodoCabeza(); //Claramente no es lo ideal, pero soluciona el problema facil che!
    }

    public ListaEnlazada<T> getListaInterna() {
        return this.listaInterna;
    }

    @Override
    public boolean insertar(T data) {
        // Evitamos duplicados
        if (listaInterna.buscar(data) == null) {
            return listaInterna.insertar(data);
        } else {
            System.out.println("Elemento ya existente en el conjunto");
            return false;
        }
    }

    @Override
    public T buscar(Comparable<T> identificador) {
        return listaInterna.buscar(identificador);
    }

    @Override
    public T eliminar(Comparable<T> identificador) {
        return listaInterna.eliminar(identificador);
    }

    @Override
    public String imprimir() {
        return listaInterna.imprimir();
    }

    @Override
    public String imprimir(String delimitador) {
        return listaInterna.imprimir(delimitador);
    }

    @Override
    public int cantElementos() {
        return listaInterna.cantElementos();
    }

    @Override
    public boolean esVacia() {
        return listaInterna.esVacia();
    }

    // Métodos propios de Conjunto

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otroConjunto) {
        Conjunto<T> conjuntoUnion = new Conjunto<>();

        // Recorrer este conjunto
        TDANodo<T> temporal1 = this.listaInterna.encontrarNodoCabeza();
        TDANodo<T> temporal2 = otroConjunto.encontrarNodoCabeza();

        while (temporal1 != null) {

            if(conjuntoUnion.buscar(temporal1.getDato()) == null){ //si no existe en el conjunto lo ingreso
                conjuntoUnion.insertar(temporal1.getDato());
            }

            temporal1 = temporal1.getSiguiente();   
        }

        while (temporal2 != null) {

            if(conjuntoUnion.buscar(temporal2.getDato()) == null){ //si no existe en el conjunto lo ingreso
                conjuntoUnion.insertar(temporal2.getDato());
            }

            temporal2 = temporal2.getSiguiente();   
        }

        System.out.println("La union de conjuntos es: " +   conjuntoUnion.imprimir());
        return conjuntoUnion;

    }


    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otroConjunto) {
        Conjunto<T> conjuntoInterseccion = new Conjunto<>();

        // Recorrer este conjunto
        TDANodo<T> temporal1 = this.listaInterna.encontrarNodoCabeza();
        //TDANodo<T> temporal2 = otroConjunto.getNodoCabeza();

        while (temporal1 != null) {

            if((conjuntoInterseccion.buscar(temporal1.getDato()) == null) && (otroConjunto.buscar(temporal1.getDato()) != null)){ //si no existe en el conjunto  y ademas esta en el otro
                conjuntoInterseccion.insertar(temporal1.getDato());
            }

            temporal1 = temporal1.getSiguiente();   
        }

        System.out.println("La interseccion de conjuntos es: " +   conjuntoInterseccion.imprimir());
        return conjuntoInterseccion;

    }


    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otroConjunto) {
        Conjunto<T> conjuntoDiferencia = new Conjunto<>();

        // Recorrer este conjunto
        TDANodo<T> temporal1 = this.listaInterna.encontrarNodoCabeza();

        while (temporal1 != null) {

            if(otroConjunto.buscar(temporal1.getDato()) == null){ //si el elemento no existe en el otro conjunto entonces lo agrego
                conjuntoDiferencia.insertar(temporal1.getDato());
            }

            temporal1 = temporal1.getSiguiente();   
        }

        System.out.println("La diferencia de conjuntos es: " +   conjuntoDiferencia.imprimir());
        return conjuntoDiferencia;

    }

}