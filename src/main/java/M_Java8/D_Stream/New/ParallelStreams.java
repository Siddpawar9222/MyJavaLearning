package M_Java8.D_Stream.New;

import java.util.stream.IntStream;

public class ParallelStreams {
    public static void main(String[] args) {

        // To See Clear difference between sequential and parallel stream, took big data
        int dataSize = (int) Math.pow(10,8);

        long startTime = System.nanoTime();

        int sum = IntStream.range(1, dataSize)
                .sum();

        long endTime = System.nanoTime();
        System.out.println("Work done in " +  (double)(endTime-startTime)/dataSize + " ms");

        System.out.println("--------------------------");

        startTime = System.nanoTime();

        int sum1 = IntStream.range(1, dataSize)
                .parallel()
                .sum();

        endTime = System.nanoTime();
        System.out.println("Work done in " +  (double)(endTime-startTime)/dataSize + " ms");
        //System.out.println("Work done in " +  endTime-startTime);

        /*
           ******In Depth********
        * */

        // Parallel stream (multiple at the same time)
        IntStream.range(1, 10)
                .parallel() // Convert to parallel
                .forEach(i -> System.out.println(Thread.currentThread().getName() + " - " + i));


    }
}
/*
Understand parallel stream once you learn advance multithreading topics
* */