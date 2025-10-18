//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;

public class ListaEnlazada<T extends Comparable<T>> implements TDALista<T> { //Se implementa sin tener en cuenta que Nodo tiene un puntero al anterior, esta pensada como una lista donde los nosdos solo tienen siguiente 

    private TDANodo<T> cabeza;
    private TDANodo<T> finalLista;
    private int tamanio;
    
    public ListaEnlazada(){

        this.cabeza = null;
        this.tamanio = 0;
    }
    
    public boolean insertarOrdenado(T data) {
        TDANodo<T> nuevoNodo = new Nodo<T>(data);

        // Caso 1: lista vacía
        if (this.cabeza == null) {
            this.cabeza = nuevoNodo;
            this.finalLista = nuevoNodo;
            this.tamanio++;
            System.out.println("Elemento insertado al inicio (lista vacía): " + data);
            return true;
        }

        // Caso 2: el nuevo nodo va antes de la cabeza
        if (data.compareTo(this.cabeza.getDato()) <= 0) {
            nuevoNodo.setSiguiente(this.cabeza);
            this.cabeza = nuevoNodo;
            this.tamanio++;
            System.out.println("Elemento insertado al inicio: " + data);
            return true;
        }

        // Caso 3: recorrer hasta encontrar la posición correcta
        TDANodo<T> temporal = this.cabeza;
        while (temporal.getSiguiente() != null && data.compareTo(temporal.getSiguiente().getDato()) > 0) {
            temporal = temporal.getSiguiente();
        }

        // Insertar el nuevo nodo después de 'temporal'
        nuevoNodo.setSiguiente(temporal.getSiguiente());
        temporal.setSiguiente(nuevoNodo);

        // Actualizar finalLista si corresponde
        if (nuevoNodo.getSiguiente() == null) {
            this.finalLista = nuevoNodo;
        }

        this.tamanio++;
        System.out.println("Elemento insertado ordenado: " + data);
        return true;
    }

    
    @Override 
    public boolean insertar(T data){ //Inserta Al final!
        
        TDANodo<T> nuevoNodo = new Nodo<T>(data);
        TDANodo<T> temporal = this.cabeza;

        if(temporal == null){

            System.out.println("Elemento insertado : "  + nuevoNodo.getDato().toString());

            this.cabeza = nuevoNodo;
            
        } else {

            while (temporal.getSiguiente() != null) {

                temporal = temporal.getSiguiente();

            }
            
        temporal.setSiguiente(nuevoNodo);

        System.out.println("Elemento insertado : "  + temporal.getSiguiente().getDato().toString());
        }

        this.tamanio++;

        this.finalLista = nuevoNodo;

        return true;

    }

    @Override 
    public T buscar(Comparable<T> identificador){

        TDANodo<T> temporal = this.cabeza;

        if(temporal == null){

            return null;

        } else {

            while (temporal != null && !temporal.getDato().equals(identificador)) {

                temporal = temporal.getSiguiente();
            }
            
        if(temporal == null){

            System.out.println("Elemento " + identificador + " NO encontrado");

            return null;

        } else {

            System.out.println("Elemento encontrado : "  + temporal.getDato().toString());

            return temporal.getDato();
            
            }
        }

    }

    @Override 
    public T eliminar(Comparable<T> identificador){
        
        TDANodo<T> temporal = this.cabeza;

        if (temporal == null){ //Caso de lista vacia

            System.out.println("Lista vacia, nada para eliminar.");

            return null;

        } else if(temporal.getDato().equals(identificador)) { //Caso en que el elemento esta en el primer lugar

            System.out.println("Elemento eliminado : "  + temporal.getDato().toString());

            this.cabeza = this.cabeza.getSiguiente();

            if (this.cabeza == null) { //Si eliminamos el único nodo, actualizamos finalLista
                
                this.finalLista = null;

            }

            this.tamanio--;

            return temporal.getDato(); //Elemento eliminado

        } else { //Caso de lista NO vacia donde NO tenemos el elemento en el primer lugar

            while ((temporal.getSiguiente() != null) && (!temporal.getSiguiente().getDato().equals(identificador))) {
                
                temporal = temporal.getSiguiente();
            }

            if(temporal.getSiguiente() != null){ //Caso de elemento encontrado NO en el primer lugar.

                T eliminado = temporal.getSiguiente().getDato();

                System.out.println("Elemento eliminado : "  + eliminado.toString());

                //Si el que vamos a eliminar es el último nodo redirigimos finalLista al anterior
                if (temporal.getSiguiente().getSiguiente() == null) {

                    this.finalLista = temporal; 
            }
                
                temporal.setSiguiente(temporal.getSiguiente().getSiguiente());

                this.tamanio--;

                return eliminado;

            } else { // Caso de elemento NO encontrado

                System.out.println("Elemento no existe en la lista");

                return null;

            }
        
        }
        
    }

    @Override 
    public String imprimir(){

        TDANodo<T> temporal = this.cabeza;

        if (temporal == null) {

            System.out.println("Lista vacia");

            return "Lista vacia";

        } else {
        
            while (temporal != null) {
                
                System.out.println("Valor en lista: " + temporal.getDato().toString());

                temporal = temporal.getSiguiente();
            }

            return "Lista no vacia";
        }
    }

    @Override
    public String imprimir(String delimitador) {
        TDANodo<T> temporal = this.cabeza;

        if (temporal == null) {
            System.out.println("Lista vacía");
            return "Lista vacía";
        }

        System.out.print("Elementos de la lista: ");
        while (temporal != null) {
            System.out.print(temporal.getDato());
            temporal = temporal.getSiguiente();
            if (temporal != null) {
                System.out.print(delimitador);
            }
        }
        System.out.println();

        return "Impresión completa";
    }


    @Override 
    public int cantElementos(){

        System.out.println("Cantidad de elementos: " + this.tamanio);

        return this.tamanio;
    }

    @Override 
    public boolean esVacia(){

        if(this.cabeza == null){

            System.out.println("Lista vacia");

        } else {

            System.out.println("Lista NO vacia");

        }

        return (this.cabeza == null);

    }

    public T getCabeza(){

        System.out.println("Cabeza de lista: " + this.cabeza.getDato());

        return this.cabeza.getDato();

    }

    public TDANodo<T> encontrarNodoCabeza(){

        return this.cabeza;

    }

    public TDANodo<T> getFinalLista() {

        System.out.println("Final de lista: " + this.finalLista.getDato());

        return finalLista;
    }

    public boolean insertarAlPrincipio(T data) {

        TDANodo<T> nuevoNodo = new Nodo<T>(data);
        TDANodo<T> temporal = this.cabeza;

        if (this.finalLista == null) {
            this.finalLista = nuevoNodo;
        }

        nuevoNodo.setSiguiente(temporal);
        this.cabeza = nuevoNodo;
        tamanio++;

        return true;
    }

    public T obtenerPorIndice(int indice){

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

    public int getTamanio(){
        return this.tamanio;
    }

}
