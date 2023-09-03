package org.example.producer_consumer_problem;

public class ProducerConsumerRunner {
    public static void main(String[] args) {
        Company c = new Company();
        Producer producer = new Producer(c);
        Consumer consumer = new Consumer(c);

        producer.start();
        consumer.start();
    }
}
