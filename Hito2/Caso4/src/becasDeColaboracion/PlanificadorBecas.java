package becasDeColaboracion;

import java.util.ArrayList;
import java.util.List;
/*
public class PlanificadorBecas {
    private List<int[]> becas;
    private List<Beca> solucionActual;
    private int salarioMaximo;
    private int salarioTotal;

    public PlanificadorBecas(ArrayList<int[]> becas2) {
        this.becas = becas2;
        this.solucionActual = new ArrayList<>();
        this.salarioMaximo = 0;
        this.salarioTotal = 0;
    }

    public List<Beca> getSolucion() {
        resolver(new ArrayList<Beca>(), 0);
        return solucionActual;
    }

    public void resolver(List<Beca> candidatos, int salarioActual) {
        if (esSolucion(candidatos, salarioActual)) {
            procesarSolucion(candidatos, salarioActual);
        } else {
            for (int i = 0; i < becas.size(); i++) {
                int[] beca = becas.get(i);
                if (esValido(beca, candidatos) && !seSolapa(beca, candidatos)) {
                    candidatos.add(beca);
                    resolver(candidatos, salarioActual + beca.getSalario());
                    candidatos.remove(beca);
                }
            }
        }
    }

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


    public boolean esSolucion(List<Beca> candidatos, int salarioActual) {
    	return salarioActual > salarioMaximo;
    }

    public void procesarSolucion(List<Beca> candidatos, int salarioActual) {
        solucionActual = new ArrayList<>(candidatos);
        salarioMaximo = salarioActual;
        //salarioTotal += salarioActual; // Suma el salario actual al salario total existente
    }


    public boolean esValido(int[] beca, List<Beca> candidatos) {
        int mesInicioBeca = beca.getMesInicio();
        int mesFinBeca = beca.getMesFin();

        for (Beca candidata : candidatos) {
            int mesInicioCandidata = candidata.getMesInicio();
            int mesFinCandidata = candidata.getMesFin();

            if ((mesInicioBeca >= mesInicioCandidata && mesInicioBeca <= mesFinCandidata) ||
                (mesFinBeca >= mesInicioCandidata && mesFinBeca <= mesFinCandidata)) {
                return false;
            }
        }

        return true;
    }

    public int getSalarioTotal() {
        return salarioTotal;
    }
}
*/