package Caso3;

public class Dominio {
    public static void Dominio() {
        soladoSuperficie();
        seleccionarBaldosa();
        buscarIndiceTamanioBaldosa();
        mostrarResultado();

    }

    private static void soladoSuperficie(int n, int[] tamaniosBaldosas) {
        List<Integer> colaBaldosas = crearColaBaldosas(tamaniosBaldosas);
        int[] cantidadesBaldosas = new int[tamaniosBaldosas.length];
        int areaRestante = n * n;
        while (areaRestante > 0) {
            int baldosa = seleccionarBaldosa(colaBaldosas, areaRestante);
            int cantidadBaldosas = areaRestante / baldosa;
            int indiceTamanioBaldosa = buscarIndiceTamanioBaldosa(tamaniosBaldosas, baldosa);
            cantidadesBaldosas[indiceTamanioBaldosa] += cantidadBaldosas;
            areaRestante -= baldosa * cantidadBaldosas;
        }
        mostrarResultado(cantidadesBaldosas, tamaniosBaldosas);
    }

    private static int seleccionarBaldosa(List<Integer> colaBaldosas, int areaRestante) {
        for (int i = colaBaldosas.size() - 1; i >= 0; i--) {
            if (colaBaldosas.get(i) <= areaRestante) {
                return colaBaldosas.get(i);
            }
        }
        return -1; // En caso de error
    }

    private static int buscarIndiceTamanioBaldosa(int[] tamaniosBaldosas, int baldosa) {
        for (int i = 0; i < tamaniosBaldosas.length; i++) {
            if (tamaniosBaldosas[i] == baldosa) {
                return i;
            }
        }
        return -1; // En caso de error
    }

    private static void mostrarResultado(int[] cantidadesBaldosas, int[] tamaniosBaldosas) {
        System.out.println("Baldosas utilizadas:");
        for (int i = 0; i < tamaniosBaldosas.length; i++) {
            if (cantidadesBaldosas[i] > 0) {
                System.out.println("- " + cantidadesBaldosas[i] + " baldosas de " + tamaniosBaldosas[i] + " metros de lado");
            }
        }
        System.out.println("Solado resultante:");
        for (int i = 0; i < cantidadesBaldosas.length; i++) {
            if (cantidadesBaldosas[i] > 0) {
                int tamanoBaldosa = tamaniosBaldosas[i];
                for (int j = 0; j < cantidadesBaldosas[i]; j++) {
                    for (int k = 0; k < tamanoBaldosa; k++) {
                        for (int l = 0; l < tamanoBaldosa; l++) {
                            System.out.print("# ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

}