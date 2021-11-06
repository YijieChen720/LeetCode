import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int rowIdx, colIdx;
        int[][] res = new int[rows][cols];

        List<Integer> tempList;
        int count;

        for (int i = 0; i < cols; i++) {
            // Get and sort
            rowIdx = 0;
            colIdx = i;
            tempList = new LinkedList<>();
            while (rowIdx < rows && colIdx < cols) {
                tempList.add(mat[rowIdx++][colIdx++]);
            }
            Collections.sort(tempList);

            // put in res
            rowIdx = 0;
            colIdx = i;
            count = 0;
            while (rowIdx < rows && colIdx < cols) {
                res[rowIdx++][colIdx++] = tempList.remove(0);
                count++;
            }
        }
        for (int i = 1; i < rows; i++) {
            // Get and sort
            colIdx = 0;
            rowIdx = i;
            tempList = new LinkedList<>();
            while (rowIdx < rows && colIdx < cols) {
                tempList.add(mat[rowIdx++][colIdx++]);
            }
            Collections.sort(tempList);

            // put in res
            colIdx = 0;
            rowIdx = i;
            count = 0;
            while (rowIdx < rows && colIdx < cols) {
                res[rowIdx++][colIdx++] = tempList.remove(0);
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        SortMatrixDiagonally test = new SortMatrixDiagonally();
        int[][] res = test.diagonalSort(mat);
    }
}
