package utilitary;

import utilitary.Tools;
public class Result {
    private final int[][] resultMatrix;

    public Result(int rows, int cols) {
        resultMatrix = new int[rows][cols];
    }

    public synchronized void addToCell(int row, int col, int value) {
        resultMatrix[row][col] += value;
    }

    public void print() {
        Tools.printMatrix(resultMatrix);
    }
}
