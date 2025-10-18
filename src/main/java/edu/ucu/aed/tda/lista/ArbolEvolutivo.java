package edu.ucu.aed.tda.lista;

public class ArbolEvolutivo extends ArbolBinarioBusqueda<Especie> {

    public ArbolEvolutivo(){
        this.setRaiz(null);
    }

    public Especie especieMasAntigua(ArbolBinarioBusqueda<Especie> a){
        if(a.getRaiz() == null){
            return null;
        } else {
            TElementoAB<Especie> masAntigua = a.getRaiz();
            while (masAntigua.getHijoDerecho()!= null) {
                masAntigua = masAntigua.getHijoDerecho();
            }
            return masAntigua.getDato();
        }
    }

    public Especie especieMasReciente(ArbolBinarioBusqueda<Especie> a){
        if(a.getRaiz() == null){
            return null;
        } else {
            TElementoAB<Especie> masReciente = a.getRaiz();
            while (masReciente.getHijoIzquierdo()!= null) {
                masReciente = masReciente.getHijoIzquierdo();
            }
            return masReciente.getDato();
        }
    }

    public void especiesCarnivoras(ListaEnlazada<Especie> l, TElementoAB<Especie> nodo){
        //caso base
        if(nodo == null) {
            return;
        } else {
            //caso recursivo
            if(nodo.getDato().getTipoAlimentacion().equalsIgnoreCase("carnivoro")){
                l.insertar(nodo.getDato());
            }
            especiesCarnivoras(l, nodo.getHijoIzquierdo());
            especiesCarnivoras(l, nodo.getHijoDerecho());
        }
    }

    public void menosDeVeinte(ListaEnlazada<String> lista, ArbolBinarioBusqueda<Especie> a) {
        // Si el árbol está vacío, no hacemos nada
        if (a == null || a.esVacio()) {
            return;
        }

        // Lista temporal para almacenar todas las especies del árbol
        ListaEnlazada<Especie> listaEspecies = new ListaEnlazada<>();

        // Recorremos el árbol en inOrden y agregamos cada especie a la lista temporal
        a.inOrder(e -> listaEspecies.insertar(e));

        // Doble bucle para comparar todos los pares posibles
        TDANodo<Especie> nodo1 = listaEspecies.encontrarNodoCabeza(); //
        while (nodo1 != null) {
            Especie e1 = nodo1.getDato();
            TDANodo<Especie> nodo2 = nodo1.getSiguiente();

            while (nodo2 != null) {
                Especie e2 = nodo2.getDato();

                // Calculamos la diferencia de antigüedad
                int diferencia = Math.abs(e1.getAntiguedad() - e2.getAntiguedad());

                if (diferencia < 20) {
                    // Construimos el string con los nombres científicos
                    String par = e1.getNombreCientifico() + " - " + e2.getNombreCientifico();
                    lista.insertar(par);
                }

                nodo2 = nodo2.getSiguiente();
            }
            nodo1 = nodo1.getSiguiente();
        }
    }



}