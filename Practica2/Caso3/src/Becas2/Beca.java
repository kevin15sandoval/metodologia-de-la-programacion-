package Becas2;

/**
 * Clase beca que contiene los atributos de la beca, constructor y getters/setters.
 * @version 1.0
 * @author Paulino Bermudez, Kevin Gomez, Andres Diaz, German Pajarero
 */

public class Beca {
    private int mesInicio;
    private int mesFin;
    private int salario;

    /**
     * Constructor de la clase beca
     * @param mesInicio
     * @param mesFin
     * @param salario
     */

    public Beca(int mesInicio, int mesFin, int salario) {
        this.mesInicio = mesInicio;
        this.mesFin = mesFin;
        this.salario = salario;
    }

    /**
     * Getters y setters de la clase beca
     * @return
     */

    public int getMesInicio() {
        return mesInicio;
    }

    public int getMesFin() {
        return mesFin;
    }

    public int getSalario() {
        return salario;
    }
    public String toString() {
        return "Iniciando en el mes " + mesInicio + " hasta el mes " + mesFin + " con un salario de " + salario + "€" ;
    }
}