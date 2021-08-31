public class SpiralMatrix2 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] spiralMatrix = new int[n][n];
            int[] squareArray = new int[n * n];

            for (int i = 0; i < n * n; i += 1) {
                squareArray[i] = i + 1;
            }

            int row0 = 0;
            int rowN = n - 1;
            int col0 = 0;
            int colN = n - 1;
            int index = 0;

            while (row0 <= rowN && col0 <= colN) {
                for (int i = col0; i <= colN; i += 1) {
                    spiralMatrix[row0][i] = squareArray[index];
                    index += 1;
                }
                for (int i = row0 + 1; i <= rowN; i += 1) {
                    spiralMatrix[i][colN] = squareArray[index];
                    index += 1;
                }
                for (int i = colN - 1; i >= col0; i -= 1) {
                    spiralMatrix[rowN][i] = squareArray[index];
                    index += 1;
                }
                for (int i = rowN - 1; i > row0; i -= 1) {
                    spiralMatrix[i][col0] = squareArray[index];
                    index += 1;
                }

                row0 += 1;
                col0 += 1;
                rowN -= 1;
                colN -= 1;
            }
            return spiralMatrix;
        }
    }
}
