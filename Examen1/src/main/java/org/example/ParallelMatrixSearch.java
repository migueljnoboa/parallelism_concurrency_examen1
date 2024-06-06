
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMatrixSearch {
    private static final int MATRIX_SIZE = 1000;
    private static final int THREAD_COUNT = 4;
    private static final int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
    private static final int TARGET = 256; // Número a buscar

    public static void main(String[] args) {

        Random random = new Random();
        random.setSeed(50);

        for (int i = 0; i < MATRIX_SIZE; i++){
            for (int j = 0; j < MATRIX_SIZE; j++){
                matrix[i][j] = (int) (Math.random() * 1000);
            }
        }

        Long start = System.nanoTime();
        System.out.println(sequentialSearch());
        Long end = System.nanoTime();
        System.out.println("Tiempo secuencial: " + (end - start) + " nano");

        Long inicio = System.nanoTime();
        parallelSearch();
        Long fin = System.nanoTime();
        System.out.println("Tiempo paralelo: " + (fin - inicio) + " nano");



        // Inicializar la matriz con valores aleatorios
        //...

        // Medir el tiempo de ejecución de la búsqueda secuencial
        //...
        // System.out.println("Resultado búsqueda secuencial: " + ...);
        // System.out.println("Tiempo búsqueda secuencial: " + (endTime - startTime) + "ms");

        // Medir el tiempo de ejecución de la búsqueda paralela
        //...
        // System.out.println("Resultado búsqueda paralela: " + ...);
        // System.out.println("Tiempo búsqueda paralela: " + (endTime - startTime) + "ms");
    }

    private static boolean sequentialSearch() {
        for (int i = 0; i < MATRIX_SIZE ; i++){
            for (int j = 0; j < MATRIX_SIZE ; j++){
                if (matrix[i][j] == TARGET) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void parallelSearch() {
        final boolean[] encontrado = {false};

        int cantidadItems = MATRIX_SIZE*MATRIX_SIZE/THREAD_COUNT;

        class Busqueda extends RecursiveTask<Integer>{

            private int x;
            private int y;

            public Busqueda(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            protected Integer compute() {

                int itemsChecked = 0;

                for (int i = x; i < MATRIX_SIZE; i++){
                    for (int j = y; j < MATRIX_SIZE; j++){
                        if (matrix[i][j] == TARGET) {
                            encontrado[0] = true;
                            return 0;
                        }
                        itemsChecked++;
                        if (itemsChecked >= cantidadItems) {
                            return 0;
                        }
                    }
                }

                return 0;
            }
        }

        List<Busqueda> busquedas = new ArrayList<Busqueda>();
        for (int i = 0; i < THREAD_COUNT; i++) {

            int x = MATRIX_SIZE/THREAD_COUNT * i;
            int y = MATRIX_SIZE/THREAD_COUNT * i;

            Busqueda busqueda = new Busqueda(x, y);
            busqueda.fork();
            busquedas.add(busqueda);
        }
        for (Busqueda busqueda : busquedas) {
            busqueda.join();
        }
        if(encontrado[0]) {
            System.out.println("Encontrado");
        }else{
            System.out.println("No encontrado");
        }
    }




}