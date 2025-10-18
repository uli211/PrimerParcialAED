package edu.ucu.aed.tda.lista;

public class Especie implements Comparable<Especie>{

    private int antiguedad;
    private String nombreCientifico;
    private String tipoAlimentacion;

    public Especie(int antiguedad, String nombreCientifico, String tipoAlimentacon){
        this.antiguedad = antiguedad;
        this.nombreCientifico = nombreCientifico;
        this.tipoAlimentacion = tipoAlimentacon;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
    public String getNombreCientifico() {
        return nombreCientifico;
    }
    
    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    @Override
    public int compareTo(Especie e) {
        //Comparamos por antigüedad
        if (this.antiguedad < e.antiguedad) {
            return -1;  // this es más reciente
        } else if (this.antiguedad > e.antiguedad) {
            return 1;   // this es más antigua
        } else {
            return 0;   // misma antigüedad
        }
    }
}
