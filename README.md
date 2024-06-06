# Primer Parcial - ICC-303 - Programación Paralela y Concurrente

## Instrucciones Generales

1. **Fecha de Entrega:** A completar en el tiempo designado durante el examen.
2. **Lenguaje de Programación:** Java
3. **Formato de Entrega:** Hacer un fork de este repositorio, trabajar en su propio fork y subir el código con las
   soluciones a GitHub.
4. **Código Original:** El código debe ser 100% de producción original. No se permite copiar ni generar código de otras
   fuentes.

## Problema 1: Paralelización de Búsqueda en una Matriz

### Descripción

Se pide implementar un programa en Java que busque un número específico en una matriz grande utilizando una arquitectura
de memoria compartida. El programa debe dividir la matriz entre varios hilos, cada uno de los cuales buscará el número
en su porción asignada.

### Requerimientos

1. Implementar un programa que divida una matriz en partes iguales entre varios hilos.
2. Cada hilo debe buscar el número en su parte de la matriz.
3. Utilizar mecanismos de sincronización para informar si el número ha sido encontrado y detener la búsqueda si se
   encuentra.
4. Medir el tiempo de ejecución de la búsqueda paralela y compararlo con la ejecución secuencial.

```java
public class ParallelMatrixSearch {
    private static final int MATRIX_SIZE = 1000;
    private static final int THREAD_COUNT = 4;
    private static final int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
    private static final int TARGET = 256; // Número a buscar

    public static void main(String[] args) {
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
        //...
    }

    private static void parallelSearch() {
        //...
    }
}
```

## Problema 2: Implementación de un Algoritmo Concurrente de Productor-Consumidor

### Descripción

Se pide implementar el clásico problema del productor-consumidor utilizando colas bloqueantes en Java. Los productores
generarán números aleatorios y los pondrán en una cola, mientras que los consumidores los tomarán de la cola y los
procesarán.

### Requerimientos

1. Implementar una clase de productor que genere números y los ponga en una cola.
2. Implementar una clase de consumidor que tome números de la cola y los procese (por ejemplo, sumarlos).
3. Utilizar una cola bloqueante para sincronizar la producción y el consumo.
4. Medir el rendimiento del sistema con múltiples productores y consumidores.

```java
public class ProducerConsumer {
    private static final int QUEUE_CAPACITY = 10;
    private static final int PRODUCER_COUNT = 2;
    private static final int CONSUMER_COUNT = 2;
    private static final int PRODUCE_COUNT = 100;

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    }

    static class Producer implements Runnable {

        @Override
        public void run() {

        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {

        }
    }
}

```

### Instrucciones

1. Hacer un fork de este repositorio en GitHub.
2. Importa el proyecto en tu IDE favorito.
3. Trabajar en su propio fork y resolver los problemas en los archivos indicados.
4. Asegurarse de que el código funcione correctamente y cumpla con los requisitos.
5. Subir el código al repositorio y hacer un pull request antes de la fecha límite.

### ¡Buena suerte y feliz codificación!

Este archivo `readme.md` proporciona una guía clara y detallada para que los estudiantes comprendan y completen los
problemas del examen. El código proporcionado incluye comentarios básicos para ayudar a guiar a los estudiantes en su
implementación.
