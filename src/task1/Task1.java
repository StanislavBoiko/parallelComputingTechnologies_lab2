package task1;


import utilitary.Result;
import utilitary.Tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task1 {

    public static void main(String[] args) {
        int[][] matrixA = Tools.generateRandomMatrix(5, 5);

        int[][] matrixB = Tools.generateRandomMatrix(5, 5);

        System.out.println("Matrix a:");
        Tools.printMatrix(matrixA);

        System.out.println("Matrix b:");
        Tools.printMatrix(matrixB);

        Result result = new Result(matrixA.length, matrixB[0].length);

        long startTime = System.currentTimeMillis();
        multiply(matrixA, matrixB, result, Runtime.getRuntime().availableProcessors());
        long endTime = System.currentTimeMillis();
        System.out.println("time parallel: "+(endTime-startTime) + " ms");
        System.out.println("Resulting matrix is:");
        result.print();


        startTime = System.currentTimeMillis();
        int[][] resultSequential = Tools.multiplySeq(matrixA, matrixB);
        endTime = System.currentTimeMillis();
        System.out.println("time sequential: "+(endTime-startTime) + " ms");
        System.out.println("Resulting matrix is:");
        Tools.printMatrix(resultSequential);
        }

    public static void multiply(int[][] matrixA, int[][] matrixB, Result result, int threads) {
        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException("Two matrices' dimensions are incompatible.");
        }

//        int numOfThreads = Runtime.getRuntime().availableProcessors();
        int numOfThreads = threads;

        ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);

        for (int i = 0; i < matrixA.length; i++) {
            executor.execute(new RowMultiplier(matrixA, matrixB, result, i));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}