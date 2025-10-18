package edu.ucu.aed.tda.lista;

/**
 * Representa el resultado de una búsqueda en el Trie.
 * 
 * estado:
 * -1 → la palabra no se encuentra en el Trie.
 *  0 → existe el prefijo pero no es palabra completa.
 *  1 → palabra completa encontrada.
 *
 * dato:
 * valor genérico asociado a la palabra (si la hay).
 */
public class Resultado<T> {

    private int estado;
    private T dato;

    public Resultado(int estado, T dato) {
        this.estado = estado;
        this.dato = dato;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "Resultado{estado=" + estado + ", dato=" + dato + "}";
    }
}
