package becasDeColaboracion;

import java.util.ArrayList;
import java.util.List;

public class PlanificadorBecas {
	//creamos las 
    private List<Beca> becas; //creamos una lista becas que es donde nos mostrara la lista de las becas disponibles 
    private List<Beca> solucionActual;//otra lista de las becas donde guardaremos la solucion actual mas conveniente
    private int salarioMaximo;//el salaraio maximo encontrado hasat el momento
    private int salarioTotal; // el total de todas las becas asignadas 
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
    public List<Beca> getSolucion() {//creamos un metodo de tipo lista que nos devolvera las becas asignadas
        resolver(new ArrayList<Beca>(), 0);//llamos al metodo resolver 
        return solucionActual;//devolvemos la solucion actual, el cual como declaramoses un array de las becas asignadas
    }
    /**
     * Busca la solucion de la lista disponible
     * @param candidatos
     * @param salarioActual
     */
    //en este metodo es donde ya llevamos acabo el backtracking para encontrar la solucion 
    public void resolver(List<Beca> candidatos, int salarioActual) {//le pasamos la lista de las becas y el salario actual
    	//Ahora verificamos si los candidatos actuales y el salario actual forman una soluci�n. 
    	//Si es as�, se llama al m�todo procesarSolucion
    	if (esSolucion(salarioActual)) {
            procesarSolucion(candidatos, salarioActual);
            //si no es el caso entramos al else
        } else {
            for (int i = 0; i < becas.size(); i++) {//iteramos sobre las becas disponibles 
                Beca beca = becas.get(i);//tomamos un beca y la guardamos en la varible beca 
                //para comprobar el siguiente if llamamos a los metodos es valido y sesolapa 
                if (esValido(beca, candidatos) && !seSolapa(beca, candidatos)) {//si es valida y no se solapa
                    candidatos.add(beca);//a�adimos a la lista candidatos que corresponde a nuestra lista beca 
                    resolver(candidatos, salarioActual + beca.getSalario());//llamaos el metodo de nuevo para realizar la recursividad con el salario y las becas actualziadas
                    candidatos.remove(beca);//eliminamos esa beca de la lista para probar con otras becas y no caer en la misma
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
    	//obtenemos el mes de inicio y fin de la beca 
        int mesInicioBeca = beca.getMesInicio();
        int mesFinBeca = beca.getMesFin();

        for (Beca candidata : candidatos) {//recorremos las becas candidatas que tenemos
        	//inicializamos dos nuevas variables pero con el mes de inicio y fin de la beca candidata 
            int mesInicioCandidata = candidata.getMesInicio();
            int mesFinCandidata = candidata.getMesFin();
            
            //comprobamos si las becas no chocan con su inicio y fin
            if (mesInicioBeca >= mesInicioCandidata && mesInicioBeca <= mesFinCandidata) {
                return true;//si solapan pasamos true
            }

            if (mesFinBeca >= mesInicioCandidata && mesFinBeca <= mesFinCandidata) {
                return true;//si solapan pasamos true
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
    //comprobar si la asignaci�n actual es una soluci�n. Devuelve verdadero si el salario actual es mayor 
    //que el salario m�ximo y falso en caso contrario.
    public boolean esSolucion(int salarioActual) {
    	return salarioActual > salarioMaximo;
    }
	/**
	 * Proceso que calcula el beneficio maximo por beca 
	 * @param candidatos
	 * @param salarioActual
	 */
    public void procesarSolucion(List<Beca> candidatos, int salarioActual) {
        solucionActual = new ArrayList<>(candidatos);//creamos una nueva lista con una copia de lista de becas candidatas
        salarioMaximo = salarioActual;
        salarioTotal += salarioActual; // Suma el salario actual al salario total existente
        //Si el salario actual es mayor que el salario m�ximo, se actualiza el valor
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
    	//tenemos los meses de inicio y fin 
    	int mesInicioBeca = beca.getMesInicio();
        int mesFinBeca = beca.getMesFin();

        for (Beca candidata : candidatos) {//recorremos la lista de candidatos
        	//tomamos los meses de inicio y fin de la beca candidata 
            int mesInicioCandidata = candidata.getMesInicio();
            int mesFinCandidata = candidata.getMesFin();
            //comprobamos si no es valida ya siendo por una u otra
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



