package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    private static final int QUEUE_CAPACITY = 10;
    private static final int PRODUCER_COUNT = 2;
    private static final int CONSUMER_COUNT = 2;
    private static final int PRODUCE_COUNT = 100;

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        Long start = System.nanoTime();
        // Consumidor 1
        Consumer consumer1 = new Consumer(new ArrayBlockingQueue<>(QUEUE_CAPACITY));
        List<Consumer> listConsumer1 = new ArrayList<>();
        listConsumer1.add(consumer1);
        Producer producer1 = new Producer(listConsumer1);
        producer1.run();
        System.out.println(consumer1.suma);

        Long end1 = System.nanoTime();

        // Consumidor 2
        Consumer consumer2 = new Consumer(new ArrayBlockingQueue<>(QUEUE_CAPACITY));
        List<Consumer> listConsumer2 = new ArrayList<>();
        listConsumer2.add(consumer2);
        Producer producer2 = new Producer(listConsumer2);
        producer2.run();
        System.out.println(consumer2.suma);

        Long end2 = System.nanoTime();

        System.out.println("Tiempo de corrida de 1 consumidor: " + (end1 - start));
        System.out.println("Tiempo de corrida de 2 consumidores: " + (end2 - start));

    }

    static class Producer implements Runnable {
        List<Consumer> consumers;

        public Producer(List<Consumer> consumers) {
            this.consumers = consumers;

        }

        @Override
        public void run() {

            Random rand = new Random();
            rand.setSeed(100);
            for (int i = 0; i < PRODUCE_COUNT; i++){
                for(Consumer consumer : consumers){
                    consumer.send(rand.nextInt());
                }
            }

        }
    }

    static class Consumer implements Runnable {

        BlockingQueue<Integer> queue;
        int suma = 0;
        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                suma += queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void send(int value) {
            queue.add(value);
            run();
        }
    }
}

