//package src.main.java.edu.ucu.aed.tda.lista;
package edu.ucu.aed.tda.lista;
public class ElementoAB<T extends Comparable<T>> implements TElementoAB<T> {
    
    private TElementoAB<T> hijoIzquierdo;
    private TElementoAB<T> hijoDerecho;
    private T dato;
    private int altura; //Atributo pensado para AVL

    public ElementoAB(){
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.dato = null;
        this.altura = 0;
    }

    public ElementoAB(T dato){
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.dato = dato;
        this.altura = 0;
    }

    @Override
    public void setHijoIzquierdo(TElementoAB<T> hijoIzquierdo){
        this.hijoIzquierdo = hijoIzquierdo;
    }

    @Override
    public void setHijoDerecho(TElementoAB<T> hijoDerecho){
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public TElementoAB<T> getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }

    @Override
    public TElementoAB<T> getHijoDerecho(){
        return this.hijoDerecho;
    }

    @Override
    public void setDato(T dato){
        this.dato = dato;
    }

    @Override
    public T getDato(){
        return this.dato;
    }

    @Override
    public boolean esHoja(){
        return ((this.hijoIzquierdo == null) && (this.hijoDerecho == null));
    }

    @Override
    public int cantidadHojas(){

        if((this.hijoIzquierdo == null) && (this.hijoDerecho == null)){

            return 1; //Este nodo es hoja

        } else {

            int hojas = 0; //Nodo actual NO hoja

            if(this.hijoIzquierdo != null){
                hojas += hijoIzquierdo.cantidadHojas();
            }

            if (this.hijoDerecho != null){
                hojas += hijoDerecho.cantidadHojas();
            }

            return hojas;

        }
    }

    @Override
    public int cantidadNodosInternos(){
        
        if((this.hijoIzquierdo == null) && (this.hijoDerecho == null)){

            return 0; //Este nodo es hoja

        } else {

            int nodosInternos = 1; //Nodo actual NO hoja

            if(this.hijoIzquierdo != null){
                nodosInternos +=  hijoIzquierdo.cantidadNodosInternos();
            }

            if (this.hijoDerecho != null){
                nodosInternos += hijoDerecho.cantidadNodosInternos();
            }

            return nodosInternos;

        }
    }

    @Override
    public int cantidadNodos() {

        int total = 1; // contamos este nodo

        if (hijoIzquierdo != null) {

            total += hijoIzquierdo.cantidadNodos();

        }
        if (hijoDerecho != null) {

            total += hijoDerecho.cantidadNodos();

        }

        return total;

    }

    @Override
    public int altura() {
        // Caso base: si el nodo es hoja
        if (hijoIzquierdo == null && hijoDerecho == null) {
            return 0;
        }

        int alturaIzq = 0;
        int alturaDer = 0;

        // Si existe hijo izquierdo, calculo su altura recursivamente
        if (hijoIzquierdo != null) {
            alturaIzq = hijoIzquierdo.altura();
        }

        // Si existe hijo derecho, calculo su altura recursivamente
        if (hijoDerecho != null) {
            alturaDer = hijoDerecho.altura();
        }

        // Retorno 1 por raiz + la mayor de las dos alturas
        if (alturaIzq > alturaDer) {
            return 1 + alturaIzq;
        } else {
            return 1 + alturaDer;
        }
    }

    @Override
    public int obtenerNivel(Comparable<T> criterioBusqueda) {
        // Caso base: coincidencia
        if (criterioBusqueda.compareTo(this.dato) == 0) {
            return 0;
        }

        // Buscar en subárbol izquierdo
        if (hijoIzquierdo != null) {
            int nivelIzq = hijoIzquierdo.obtenerNivel(criterioBusqueda);
            if (nivelIzq != -1) {
                return nivelIzq + 1; // sumo 1 porque bajé un nivel
            }
        }

        // Buscar en subárbol derecho
        if (hijoDerecho != null) {
            int nivelDer = hijoDerecho.obtenerNivel(criterioBusqueda);
            if (nivelDer != -1) {
                return nivelDer + 1;
            }
        }

        // No lo encontré ni en izq ni en der
        return -1;
    }

    @Override
    public TElementoAB<T> buscar(Comparable<T> criterioBusqueda) {

        if (criterioBusqueda.compareTo(this.dato) == 0) {
            //Encuentro dato
            return this;

        } else if (criterioBusqueda.compareTo(this.dato) < 0) {

            if (hijoIzquierdo != null) {
                //Si es menor busco en izq
                return hijoIzquierdo.buscar(criterioBusqueda);

            } else {

                return null;

            }
        } else {

            if (hijoDerecho != null) {
                //Si es mayor busco en der
                return hijoDerecho.buscar(criterioBusqueda);
                
            } else {
                //No lo encuentro
                return null;
            }
        }
    }

    @Override
    public void insertar(T nuevoDato) {

        if (nuevoDato.compareTo(this.dato) < 0) {

            if (hijoIzquierdo == null) {

                hijoIzquierdo = new ElementoAB<>(nuevoDato);

            } else {

                hijoIzquierdo.insertar(nuevoDato);

            }
        } else if (nuevoDato.compareTo(this.dato) > 0) {

            if (hijoDerecho == null) {

                hijoDerecho = new ElementoAB<>(nuevoDato);

            } else {

                hijoDerecho.insertar(nuevoDato);
            }
        } else {
            // Si es igual no hacemos nada (no se permiten duplicados)
        }
    }


    @Override
    public TElementoAB<T> eliminar(Comparable<T> criterioBusqueda) {
        // Caso 1: buscar en subárbol izquierdo
        if (criterioBusqueda.compareTo(this.dato) < 0) {
            if (hijoIzquierdo != null) {
                hijoIzquierdo = hijoIzquierdo.eliminar(criterioBusqueda);
            }
            return this;
        }
        // Caso 2: buscar en subárbol derecho
        else if (criterioBusqueda.compareTo(this.dato) > 0) {
            if (hijoDerecho != null) {
                hijoDerecho = hijoDerecho.eliminar(criterioBusqueda);
            }
            return this;
        }
        // Caso 3: lo encontré (this.dato == criterioBusqueda)
        else {
            // Caso 3.1: es hoja
            if (hijoIzquierdo == null && hijoDerecho == null) {
                return null;
            }
            // Caso 3.2: solo hijo derecho
            else if (hijoIzquierdo == null) {
                return hijoDerecho;
            }
            // Caso 3.3: solo hijo izquierdo
            else if (hijoDerecho == null) {
                return hijoIzquierdo;
            }
            // Caso 3.4: dos hijos
            else {
                // Busco el mayor del subárbol izquierdo
                TElementoAB<T> maxIzq = hijoIzquierdo;
                while (maxIzq.getHijoDerecho() != null) {
                    maxIzq = maxIzq.getHijoDerecho();
                }
                // Copio su dato al nodo actual
                this.dato = maxIzq.getDato();
                // Y elimino ese nodo del subárbol izquierdo
                hijoIzquierdo = hijoIzquierdo.eliminar(maxIzq.getDato());
                return this;
            }
        }
    }

    @Override
    public void inOrder(java.util.function.Consumer<TElementoAB<T>> consumidor) {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.inOrder(consumidor);
        }

        consumidor.accept(this);

        if (hijoDerecho != null) {
            hijoDerecho.inOrder(consumidor);
        }
    }

    @Override
    public void preOrder(java.util.function.Consumer<TElementoAB<T>> consumidor) {
        consumidor.accept(this);

        if (hijoIzquierdo != null) {
            hijoIzquierdo.preOrder(consumidor);
        }

        if (hijoDerecho != null) {
            hijoDerecho.preOrder(consumidor);
        }
    }

    @Override
    public void postOrder(java.util.function.Consumer<TElementoAB<T>> consumidor) {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.postOrder(consumidor);
        }

        if (hijoDerecho != null) {
            hijoDerecho.postOrder(consumidor);
        }

        consumidor.accept(this);
    }


    //Inserta un nuevo dato en el árbol sin respetar ningún criterio de orden.
    //Si el hijo izquierdo está libre, lo asigna ahi, sino prueba con el hijo derecho, si ambos están ocupados continúa recursivamente en el hijo izquierdo
    @Override
    public void insertarSinOrden(T nuevoDato) {
        if (this.hijoIzquierdo == null) {
            this.hijoIzquierdo = new ElementoAB<>(nuevoDato);
        } else if (this.hijoDerecho == null) {
            this.hijoDerecho = new ElementoAB<>(nuevoDato);
        } else {
            // En este ejemplo, siempre seguimos expandiendo por la izquierda
            this.hijoIzquierdo.insertarSinOrden(nuevoDato);
        }
    }

    //Busca un nodo con el dato especificado recorriendo todo el árbol.
    //Primero izquierda desp derecha.
    @Override
    public TElementoAB<T> buscarSinOrden(Comparable<T> criterioBusqueda) {
        if (criterioBusqueda.compareTo(this.dato) == 0) {
            return this;
        }

        if (hijoIzquierdo != null) {
            TElementoAB<T> nodoIzq = hijoIzquierdo.buscarSinOrden(criterioBusqueda);
            if (nodoIzq != null) {
                return nodoIzq;
            }
        }

        if (hijoDerecho != null) {
            TElementoAB<T> nodoDer = hijoDerecho.buscarSinOrden(criterioBusqueda);
            if (nodoDer != null) {
                return nodoDer;
            }
        }

        return null; // No lo encontré en ningún lado
    }


    @Override
    public TElementoAB<T> eliminarSinOrden(Comparable<T> criterioBusqueda) {
        // Caso base: el nodo actual es el que debe eliminarse
        if (criterioBusqueda.compareTo(this.dato) == 0) {
            if (hijoIzquierdo == null && hijoDerecho == null) {
                return null; // caso 1: hoja
            } else if (hijoIzquierdo == null) {
                return hijoDerecho; // caso 2: un solo hijo derecho
            } else if (hijoDerecho == null) {
                return hijoIzquierdo; // caso 2: un solo hijo izquierdo
            } else {
                // caso 3: dos hijos
                TElementoAB<T> maxIzq = hijoIzquierdo;
                while (maxIzq.getHijoDerecho() != null) {
                    maxIzq = maxIzq.getHijoDerecho();
                }
                this.dato = maxIzq.getDato();
                hijoIzquierdo = hijoIzquierdo.eliminarSinOrden(maxIzq.getDato());
                return this;
            }
        }

        // Si no soy el nodo buscado, recorro mis hijos
        if (hijoIzquierdo != null) {
            hijoIzquierdo = hijoIzquierdo.eliminarSinOrden(criterioBusqueda);
        }
        if (hijoDerecho != null) {
            hijoDerecho = hijoDerecho.eliminarSinOrden(criterioBusqueda);
        }

        return this;
    }
    //Funciones para AVL

    @Override
    public int getAltura() {
        return altura;
    }

    @Override
    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public void actualizarAltura() {
        int alturaIzq;
        int alturaDer;

        if (hijoIzquierdo != null) {
            alturaIzq = hijoIzquierdo.getAltura();
        } else {
            alturaIzq = -1;
        }

        if (hijoDerecho != null) {
            alturaDer = hijoDerecho.getAltura();
        } else {
            alturaDer = -1;
        }

        if (alturaIzq > alturaDer) {
            this.altura = 1 + alturaIzq;
        } else {
            this.altura = 1 + alturaDer;
        }
    }

    @Override
    public int getBalance() {
        int alturaIzq;
        int alturaDer;

        if (hijoIzquierdo != null) {
            alturaIzq = hijoIzquierdo.getAltura();
        } else {
            alturaIzq = -1;
        }

        if (hijoDerecho != null) {
            alturaDer = hijoDerecho.getAltura();
        } else {
            alturaDer = -1;
        }

        return alturaIzq - alturaDer;
    }

    //Rotación simple a la derecha.
    @Override
    public TElementoAB<T> rotacionDerecha() {
        TElementoAB<T> nuevaRaiz = this.hijoIzquierdo;
        this.hijoIzquierdo = nuevaRaiz.getHijoDerecho();
        nuevaRaiz.setHijoDerecho(this);

        this.actualizarAltura();
        nuevaRaiz.actualizarAltura();

        return nuevaRaiz;
    }

    //Rotación simple a la izquierda.
    @Override
    public TElementoAB<T> rotacionIzquierda() {
        TElementoAB<T> nuevaRaiz = this.hijoDerecho;
        this.hijoDerecho = nuevaRaiz.getHijoIzquierdo();
        nuevaRaiz.setHijoIzquierdo(this);

        this.actualizarAltura();
        nuevaRaiz.actualizarAltura();

        return nuevaRaiz;
    }


    //Rotación doble izquierda-derecha.
    @Override
    public TElementoAB<T> rotacionIzquierdaDerecha() {
        this.hijoIzquierdo = this.hijoIzquierdo.rotacionIzquierda();
        return this.rotacionDerecha();
    }

    //Rotación doble derecha-izquierda.
    @Override
    public TElementoAB<T> rotacionDerechaIzquierda() {
        this.hijoDerecho = this.hijoDerecho.rotacionDerecha();
        return this.rotacionIzquierda();
    }


}
