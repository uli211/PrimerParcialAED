//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
// No se pueden crear arrays de tipo genérico directamente (new T[] ...).
// Por eso, se hace un cast desde Comparable[] hacia T[].
// Se utiliza @SuppressWarnings("unchecked") para evitar la advertencia de compilación,
// porque en tiempo de ejecución Java no puede verificar este cast (type erasure).

public class ArrayList<T extends  Comparable<T>> implements TDALista<T>{

    private T[] elementos;
    private int tamanio; //Cantidad de elementos existentes en el Array

    private static final int CAPACIDAD_INICIAL = 10; //Constante de clase

    @SuppressWarnings("unchecked")
    public ArrayList() {
        elementos = (T[]) new Comparable[CAPACIDAD_INICIAL]; // Creamos un array de Comparables, lo casteamos a T[] para que funcione con genéricos.
        tamanio = 0;
    }

    @SuppressWarnings("unchecked")
    private void asegurarCapacidad() {
        if (tamanio == elementos.length) {
            T[] nuevoArray = (T[]) new Comparable[elementos.length * 2];
            System.arraycopy(elementos, 0, nuevoArray, 0, elementos.length);
            elementos = nuevoArray;
            }
}

    @Override
    public boolean insertar(T data) {
        asegurarCapacidad(); // redimensiona si está lleno
        elementos[tamanio] = data; // lo pone en el próximo lugar libre
        tamanio++;
        System.out.println("Elemento insertado: " + data);
        return true;
    }

    public boolean insertarOrdenado(T data) {
        asegurarCapacidad();

        //Buscar posición de inserción
        int i = 0;
        while (i < tamanio && elementos[i].compareTo(data) < 0) {
            i++;
        }

        //Desplazar elementos hacia la derecha
        for (int j = tamanio; j > i; j--) {
            elementos[j] = elementos[j - 1];
        }

        //Insertar en la posición encontrada
        elementos[i] = data;

        //Actualizar tamaño
        tamanio++;

        System.out.println("Elemento insertado ordenado en posición " + i + ": " + data);
        return true;
    }


    @Override
    public T eliminar(Comparable<T> identificador) {
        int i = 0;

        // Buscar el índice del elemento
        while (i < tamanio && !elementos[i].equals(identificador)) {
            i++;
        }

        // Si no lo encontró
        if (i == tamanio) {
            System.out.println("Elemento NO encontrado");
            return null;
        }

        // Guardamos el eliminado
        T eliminado = elementos[i];
        System.out.println("Elemento eliminado: " + eliminado);

        // Corrimiento hacia la izquierda
        for (int j = i; j < tamanio - 1; j++) {
            elementos[j] = elementos[j + 1];
        }

        // Última posición queda libre
        elementos[tamanio - 1] = null;

        // Actualizamos tamaño
        tamanio--;

        return eliminado;
    }

/*
    @Override
    public boolean esVacia(){
        if (elementos[0] != null) {
            System.out.println("Lista NO vacia");
        } else {
            System.out.println("Lista vacia");
        }
        return (elementos[0] != null);
    }
*/
@Override
public boolean esVacia() {
    boolean vacia = (tamanio == 0);
    System.out.println(vacia ? "Lista vacia" : "Lista NO vacia");
    return vacia;
}

    @Override
    public int cantElementos(){
        System.out.println("Cantidad de elementos: " + this.tamanio);
        return(this.tamanio);
    }

    @Override
    public T buscar(Comparable<T> identificador) {
        for (int i = 0; i < tamanio; i++) {
            if (elementos[i].equals(identificador)) {
                System.out.println("Elemento encontrado en índice " + i + ": " + elementos[i]);
                return elementos[i];
            }
        }
        System.out.println("Elemento " + identificador + " NO encontrado");
        return null;
    }


    //Esta funcion SOLO funciona para los arrays ordenados.
    @SuppressWarnings("unchecked")
    public T buscarBinario(Comparable<T> identificador) {
        int izquierda = 0;
        int derecha = tamanio - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;

            int resultado = elementos[medio].compareTo((T) identificador);
            if (resultado == 0) {
                System.out.println("Elemento encontrado en índice " + medio + ": " + elementos[medio]);
                return elementos[medio];
            } else if (resultado < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        System.out.println("Elemento " + identificador + " NO encontrado");
        return null;
    }

    @Override
    public T obtenerPorIndice(int indice) {
        if (indice < 0 || indice >= tamanio) {
            System.out.println("Índice fuera de rango: " + indice);
            return null;
        }

        System.out.println("Elemento en índice " + indice + ": " + elementos[indice]);
        return elementos[indice];
    }

    @Override
    public String imprimir() {
        if (tamanio == 0) {
            System.out.println("Lista vacía");
            return "Lista vacía";
        }

        for (int i = 0; i < tamanio; i++) {
            System.out.println("Valor en índice " + i + ": " + elementos[i]);
        }

        return "Lista no vacía";
    }

    @Override
    public String imprimir(String delimitador) {
        if (tamanio == 0) {
            System.out.println("Lista vacía");
            return "Lista vacía";
        }

        for (int i = 0; i < tamanio; i++) {
            System.out.print(elementos[i]);
            if (i < tamanio - 1) {
                System.out.print(delimitador);
            }
        }
        System.out.println(); // salto de línea final

        return "Lista no vacía";
    }


    public void vaciar() {
        for (int i = 0; i < tamanio; i++) {
            elementos[i] = null;
        }

        tamanio = 0;

        System.out.println("La lista ha sido vaciada.");
    }



}
