package experiments;

import task1.Task1;
import utilitary.Result;
import utilitary.Tools;

import java.util.ArrayList;
import java.util.List;

import task2.Task2;


//мені соромно за цей код(((
//але я можу все пояснити, правда


public class Tester {
    public static void main(String[] args) {

        List<int[][]> list = new ArrayList<int[][]>();
        for (int matrixSize = 50; matrixSize <= 500; matrixSize += 50) {
            int[][] matrixA = Tools.generateRandomMatrix(matrixSize, matrixSize);

            int[][] matrixB = Tools.generateRandomMatrix(matrixSize, matrixSize);

            list.add(matrixA);
            list.add(matrixB);
        }

        System.out.println("sequential: ");

        for (int i = 0; i < list.size(); i += 2) {


            int[][] matrixA = list.get(i);

            int[][] matrixB = list.get(i+1);


            Result result = new Result(matrixA.length, matrixB[0].length);

            long startTime;

            long endTime;

            startTime = System.currentTimeMillis();
            int[][] resultSequential = Tools.multiplySeq(matrixA, matrixB);
            endTime = System.currentTimeMillis();

            System.out.println((endTime - startTime));

        }

        for (int threads = 2; threads <= 12; threads += 2) {
            System.out.println(threads + " threads, row:");
            for (int i = 0; i < list.size(); i += 2) {


                int[][] matrixA = list.get(i);

                int[][] matrixB = list.get(i+1);


                Result result = new Result(matrixA.length, matrixB[0].length);

                long startTime;

                long endTime;

                startTime = System.currentTimeMillis();
                Task1.multiply(matrixA, matrixB, result, threads);
                endTime = System.currentTimeMillis();
                System.out.println((endTime - startTime));






            }
        }
    for (int threads = 2; threads <= 12; threads += 2) {
        System.out.println(threads + " threads, fox:");
        for (int i = 0; i < list.size(); i += 2) {


            int[][] matrixA = list.get(i);

            int[][] matrixB = list.get(i+1);


            Result result = new Result(matrixA.length, matrixB[0].length);

            long startTime;

            long endTime;




                startTime = System.currentTimeMillis();
                int[][] resultFox = Task2.multiply(matrixA, matrixB, threads);
                endTime = System.currentTimeMillis();
                System.out.println((endTime-startTime));



        }
    }
}
}

