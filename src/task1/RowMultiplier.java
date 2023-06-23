package task1;

import utilitary.Result;

public class RowMultiplier implements Runnable {
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final Result result;
    private final int row;

    public RowMultiplier(int[][] matrixA, int[][] matrixB, Result result, int row) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.row = row;
    }

    @Override
    public void run() {
        for (int j = 0; j < matrixB[0].length; j++) {
            for (int k = 0; k < matrixA[0].length; k++) {
                result.addToCell(row, j, matrixA[row][k] * matrixB[k][j]);
            }
        }
    }
}
