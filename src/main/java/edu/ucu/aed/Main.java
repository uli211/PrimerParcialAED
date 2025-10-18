//package src.main.java.edu.ucu.aed;
package edu.ucu.aed;
import java.nio.channels.Pipe;


import edu.ucu.aed.tda.lista.Cola;
import edu.ucu.aed.tda.lista.Conjunto;
import edu.ucu.aed.tda.lista.ElementoAB;
import edu.ucu.aed.tda.lista.Especie;
import edu.ucu.aed.tda.lista.ListaEnlazada;
import edu.ucu.aed.tda.lista.ManejadorArchivosGenerico;
import edu.ucu.aed.tda.lista.Pila;
import edu.ucu.aed.tda.lista.Resultado;
import edu.ucu.aed.tda.lista.Trie;
import edu.ucu.aed.utils.FileUtils;
import edu.ucu.aed.tda.lista.ArbolAVL;
import edu.ucu.aed.tda.lista.ArbolBinario;
import edu.ucu.aed.tda.lista.ArbolBinarioBusqueda;
import edu.ucu.aed.tda.lista.ArbolEvolutivo;
import edu.ucu.aed.tda.lista.ArbolGenerico;
import edu.ucu.aed.tda.lista.ArbolGenericoLE;
import edu.ucu.aed.tda.lista.ArrayList;

import java.nio.channels.Pipe;

import edu.ucu.aed.tda.lista.Cola;
import edu.ucu.aed.tda.lista.Conjunto;
import edu.ucu.aed.tda.lista.ElementoAB;
import edu.ucu.aed.tda.lista.ListaEnlazada;
import edu.ucu.aed.tda.lista.Pila;


import edu.ucu.aed.utils.FileUtils;
import edu.ucu.aed.tda.lista.ArbolAVL;
import edu.ucu.aed.tda.lista.ArbolBinario;
import edu.ucu.aed.tda.lista.ArbolBinarioBusqueda;
import edu.ucu.aed.tda.lista.ArbolGenerico;
import edu.ucu.aed.tda.lista.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileUtils.leerLineas("./test.txt", x -> {
            System.out.println(x);
        });
        //CREAR E INSERTAR ARBOL
        ArbolEvolutivo a = new ArbolEvolutivo();
        Especie Trilobite = new Especie(520, "Trilobite", "herbidoro");
        Especie Tiktaalik = new Especie(375, "Tiktaalik", "carnivoro");
        Especie Archaeopteryx = new Especie(150, "Archaeopteryx", "carnivoro");
        Especie HomoSampiens = new Especie(0, "HomosSapiens", "omnivoro");
        Especie Austrolopithecus = new Especie(4, "Austrolopithecus", "omnivoro");

        a.insertar(Trilobite);
        a.insertar(Tiktaalik);
        a.insertar(Austrolopithecus);
        a.insertar(HomoSampiens);
        a.insertar(Archaeopteryx);

        a.inOrder(e -> System.out.println(e.getNombreCientifico() + " (" + e.getAntiguedad() + " millones de años, " + e.getTipoAlimentacion() + ")"));

        //CARGAR ARBOL A PARTR DE ARCHIVO
        ArbolEvolutivo arbol = new ArbolEvolutivo();

        // Leer las líneas del archivo
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("/home/joaco/Desktop/UCU/Algoritmos/ut02-equipodiez/TDAS/src/main/java/edu/ucu/aed/tda/lista/especies.txt");

        // Recorrer cada línea y crear Especie
        for (String linea : lineas) {
            String[] datos = linea.split(";");
            int antiguedad = Integer.parseInt(datos[0].trim());
            String nombre = datos[1].trim();
            String tipoAlimentacion = datos[2].trim();

            Especie especie = new Especie(antiguedad, nombre, tipoAlimentacion);
            arbol.insertar(especie);
        }

        System.out.println("=== Árbol Evolutivo cargado desde archivo ===");
        arbol.inOrder(e -> System.out.println(
            e.getNombreCientifico() + " (" +
            e.getAntiguedad() + " millones de años, " +
            e.getTipoAlimentacion() + ")"
        ));

        //INSERTAR CONTENIDO DE ARBOL EN LISTA

        // Crear la lista vacía
        ListaEnlazada<Especie> listaEspecies = new ListaEnlazada<>();

        // Usar inOrder con una lambda que inserta en la lista
        arbol.inOrder(e -> listaEspecies.insertar(e));

        listaEspecies.imprimir(",");
    }
    
}