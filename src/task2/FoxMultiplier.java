package task2;

public class FoxMultiplier implements Runnable{

    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int[][] result;
    private final int row;
    private final int step;


    public FoxMultiplier(int[][] matrixA, int[][] matrixB, int[][] result, int row, int step) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.row = row;
        this.step = step;
    }

    @Override
    public void run() {
        int n = matrixA.length;
        int col = (row + step) % n;
        for (int k = 0; k < n; k++) {
            result[row][col] += matrixA[row][k] * matrixB[k][col];
            col = (col + 1) % n;
        }
    }
}
