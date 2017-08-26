/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distaciapuntos;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cristianpreciadosanchez
 */
public class Distaciapuntos {
    
    static int [][] puntoscolumnas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int dimension=0, puntos = 0, contador = 0;
        Scanner teclado = new Scanner (System.in);
        System.out.println ("Cantidad de dimesiones: ");
        dimension = teclado.nextInt();
        System.out.println ("Numero de puntos: ");
        puntos = teclado.nextInt();
        int coordenadas[][]=new int [puntos][dimension];
        while(contador<puntos){
            int contadorCoordenadas=0;
            while (contadorCoordenadas<dimension) {
                System.out.println ("Escriba coordenada "+contadorCoordenadas+" del punto "+contador);
                coordenadas[contador][contadorCoordenadas]=teclado.nextInt();
                contadorCoordenadas++;
            }
            contador++;
        }
        armarcolumnas(coordenadas);
        distanciaPuntos();
        System.out.println(java.util.Arrays.deepToString(puntoscolumnas));
    }
    
    private static void armarcolumnas(int [][] coordenadas){
        puntoscolumnas= new int[coordenadas[0].length][coordenadas.length];
        for (int i = 0; i < coordenadas[0].length; i++) {
            for (int j = 0; j < coordenadas.length; j++) {
                puntoscolumnas[i][j]=coordenadas[j][i];
            }
        }
    }
    
    private static void distanciaPuntos(){
        double distaciaEntrePuntos = 0;
        for (int i = 0; i < puntoscolumnas.length; i++) {
            int[] puntosmenoramayor=puntoscolumnas[i];
            distaciaEntrePuntos+=pow(restar(puntosmenoramayor),2);
        }
        System.out.println("distancia: "+sqrt(distaciaEntrePuntos));
    }
    
    private static int restar(int [] numerosordenados){
        int resta = 0;
        for (int i = 0; i < numerosordenados.length; i++) {
            resta = numerosordenados[i] - resta;
        }
        return resta;
    }
}
