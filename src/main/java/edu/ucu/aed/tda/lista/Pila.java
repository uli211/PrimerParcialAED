//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
public class Pila<T extends Comparable<T>> implements TDAPila<T> {

    private ListaEnlazada<T> listaInterna;

    public Pila() {
        this.listaInterna = new ListaEnlazada<>();
    }

    @Override
    public T obtenerPorIndice(int indice){
        return listaInterna.obtenerPorIndice(indice);
    }

    @Override
    public boolean insertar(T data) {

        return listaInterna.insertarAlPrincipio(data); //usamos insertar al principio para que sea pila
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

    // Métodos propios de pila
    @Override
    public T tope() {

        System.out.println("Elemento tope de la pila :" + listaInterna.getCabeza());
        return listaInterna.getCabeza();

    }

    @Override
    public T sacar() {

        if (listaInterna.esVacia()) {

            return null;

        } else {
            
            // Eliminar el primero (cabeza)
            return listaInterna.eliminar(listaInterna.getCabeza());
        }
        
    }
}

