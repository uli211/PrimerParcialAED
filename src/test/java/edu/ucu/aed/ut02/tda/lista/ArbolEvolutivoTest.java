package edu.ucu.aed.ut02.tda.lista;

import java.beans.Transient;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.ucu.aed.tda.lista.ListaEnlazada;
import edu.ucu.aed.tda.lista.ArbolEvolutivo;
import edu.ucu.aed.tda.lista.Especie;

public class ArbolEvolutivoTest {
    
    @Test
    void especieMasAntiguaTest(){
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

        assertEquals(Trilobite, a.especieMasAntigua(a));  
    }

    @Test
    void especieMasRecienteTest(){
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

        assertEquals(HomoSampiens, a.especieMasReciente(a));  
    }

    @Test
    void especiesCarnivorasTest(){
        ArbolEvolutivo a = new ArbolEvolutivo();
        Especie Trilobite = new Especie(520, "Trilobite", "herbidoro");
        Especie Tiktaalik = new Especie(375, "Tiktaalik", "carnivoro");
        Especie Archaeopteryx = new Especie(150, "Archaeopteryx", "carnivoro");
        Especie HomoSampiens = new Especie(0, "HomosSapiens", "omnivoro");
        Especie Austrolopithecus = new Especie(4, "Austrolopithecus", "omnivoro");
        System.out.println("Raíz: " + a.getRaiz());

        a.insertar(Trilobite);
        a.insertar(Tiktaalik);
        a.insertar(Austrolopithecus);
        a.insertar(HomoSampiens);
        a.insertar(Archaeopteryx);

        ListaEnlazada<Especie> l = new ListaEnlazada<>();
        ListaEnlazada<Especie> listaEsperada = new ListaEnlazada<>();
        listaEsperada.insertar(Tiktaalik);
        listaEsperada.insertar(Archaeopteryx);
        a.especiesCarnivoras(l, a.getRaiz());

        //Comprobamos cantidad
        assertEquals(listaEsperada.cantElementos(), l.cantElementos());

        //Comprobamos elemento por elemento
        for (int i = 0; i < l.cantElementos(); i++) {
            Especie esperada = listaEsperada.obtenerPorIndice(i);
            Especie obtenida = l.obtenerPorIndice(i);

            assertEquals(esperada.getNombreCientifico(),obtenida.getNombreCientifico(),"Error en elemento " + i);
        }
    }

}
