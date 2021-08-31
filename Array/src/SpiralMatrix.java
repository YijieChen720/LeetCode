import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            List<Integer> spiralM = new ArrayList<Integer>();
            int row0 = 0;
            int col0 = 0;
            int rowN = rows - 1;
            int colN = cols - 1;

            while (row0 <= rowN && col0 <= colN) {
                printS(matrix, spiralM, row0, rowN, col0, colN);
                row0 += 1;
                col0 += 1;
                rowN -= 1;
                colN -= 1;
            }

            return spiralM;
        }

        private void printS(int[][] matrix, List<Integer> spiralM, int row0, int rowN, int col0, int colN) {
            for (int i = col0; i <= colN; i += 1) {
                spiralM.add(matrix[row0][i]);
            }

            for (int i = row0 + 1; i <= rowN; i += 1) {
                spiralM.add(matrix[i][colN]);
            }

            if (row0 == rowN) {
                return;
            }

            for (int i = colN - 1; i >= col0; i -= 1) {
                spiralM.add(matrix[rowN][i]);
            }

            if (col0 == colN) {
                return;
            }

            for (int i = rowN - 1; i > row0; i -= 1) {
                spiralM.add(matrix[i][col0]);
            }
        }

    }
}
