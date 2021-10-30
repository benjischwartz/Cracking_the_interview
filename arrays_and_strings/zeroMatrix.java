import java.util.*;

public class zeroMatrix {
        public static int [][]zeroMatrix(int [][]matrix) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (matrix[i][j] == 0) {
                            rowSet.add(i);
                            colSet.add(j);
                        }
                    }
                }
                Iterator<Integer> rowItr = rowSet.iterator();
                while (rowItr.hasNext()) {
                    nullifyRow(matrix, rowItr.next());
                }

                Iterator<Integer> colItr = colSet.iterator();
                while (colItr.hasNext()) {
                    nullifyCol(matrix, colItr.next());
                }
                return matrix;
        }

        public static void nullifyRow(int [][]matrix, int row) {
            for (int j = 0; j < matrix[row].length; j++) {
                matrix[row][j] = 0;
            }
        }

        public static void nullifyCol(int [][]matrix, int col) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][col] = 0;
                }
        }

        public static void main(String[] args) {
                int [][]testMatrix = {{0, 1, 2, 3}, {1, 2, 0, 4}, {2, 3, 4, 5}, {6, 6, 6, 6}};
                prettyPrint(testMatrix);
                System.out.print('\n');
                zeroMatrix(testMatrix);
                prettyPrint(testMatrix);
        }

        public static void prettyPrint(int [][]matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length;j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.print('\n');
            }
        }
}








