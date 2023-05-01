package becasDeColaboracion;

import java.util.ArrayList;
import java.util.List;

public class PlanificadorBecas {	
    private List<Beca> becas;
    private List<Beca> solucionActual;
    private int salarioMaximo;
    private int salarioTotal;
    /**
     * Constructor del planificador de becas
     * @param becas
     */
    public PlanificadorBecas(List<Beca> becas) {
        this.becas = becas;
        this.solucionActual = new ArrayList<>();
        this.salarioMaximo = 0;
        this.salarioTotal = 0;
    }
    /**
     * Devuelve la solucion.
     * @return solucion
     */
    public List<Beca> getSolucion() {
        resolver(new ArrayList<Beca>(), 0);
        return solucionActual;
    }
    /**
     * Busca la solucion de la lista disponible
     * @param candidatos
     * @param salarioActual
     */
    public void resolver(List<Beca> candidatos, int salarioActual) {
        if (esSolucion(candidatos, salarioActual)) {
            procesarSolucion(candidatos, salarioActual);
        } else {
            for (int i = 0; i < becas.size(); i++) {
                Beca beca = becas.get(i);
                if (esValido(beca, candidatos) && !seSolapa(beca, candidatos)) {
                    candidatos.add(beca);
                    resolver(candidatos, salarioActual + beca.getSalario());
                    candidatos.remove(beca);
                }
            }
        }
    }
    
    /**
     * Busca la disponibilidad de compatibilidad entre becas
     * @param beca
     * @param candidatos
     * @return boolean
     */
    public boolean seSolapa(Beca beca, List<Beca> candidatos) {
        int mesInicioBeca = beca.getMesInicio();
        int mesFinBeca = beca.getMesFin();

        for (Beca candidata : candidatos) {
            int mesInicioCandidata = candidata.getMesInicio();
            int mesFinCandidata = candidata.getMesFin();

            if (mesInicioBeca >= mesInicioCandidata && mesInicioBeca <= mesFinCandidata) {
                return true;
            }

            if (mesFinBeca >= mesInicioCandidata && mesFinBeca <= mesFinCandidata) {
                return true;
            }
        }

        return false;
    }

    /**
     * Devuelve el salario más alto actualizado
     * @param candidatos
     * @param salarioActual
     * @return salarioActual > salarioMaximo
     */
    public boolean esSolucion(List<Beca> candidatos, int salarioActual) {
    	return salarioActual > salarioMaximo;
    }
	/**
	 * Proceso que calcula el beneficio maximo por beca 
	 * @param candidatos
	 * @param salarioActual
	 */
    public void procesarSolucion(List<Beca> candidatos, int salarioActual) {
        solucionActual = new ArrayList<>(candidatos);
        salarioMaximo = salarioActual;
        salarioTotal += salarioActual; // Suma el salario actual al salario total existente
        if (salarioActual > salarioMaximo) {
        	salarioMaximo = salarioActual;
        }
    }

    /**
     * Comprueba si las fechas disponibles son validas.
     * @param beca
     * @param candidatos
     * @return boolean
     */
    public boolean esValido(Beca beca, List<Beca> candidatos) {
        int mesInicioBeca = beca.getMesInicio();
        int mesFinBeca = beca.getMesFin();

        for (Beca candidata : candidatos) {
            int mesInicioCandidata = candidata.getMesInicio();
            int mesFinCandidata = candidata.getMesFin();            
            if ((mesInicioBeca >= mesInicioCandidata && mesInicioBeca <= mesFinCandidata) ||
                (mesFinBeca >= mesInicioCandidata && mesFinBeca <= mesFinCandidata) ) {
                return false;
            }
        }

        return true;
    }
    /**
     * Devuelve el salario total obtenido.
     * @return salarioTotal
     */
    public int getSalarioTotal() {
        return salarioTotal;
    }
}



