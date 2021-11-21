// Subproblems;
// Define opt(x, y) as the problem of determining the number of possible
// unique paths from (x, y) to (n, -m) travelling only down and right

// Base Cases:
//  ON THE EDGE:
//      if (y == -m + 1) {return 1}
//      if (x == n - 1) {return 1}

// Recursion:
//      return (opt(x, y - 1) + opt(x + 1, y));

// Use a 2x2 array to store results

class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] resultMatrix = populateMatrix(m, n);
        return resultMatrix[0][0];
    }
    
    public int[][] populateMatrix(int m, int n) {
        
        // Populate our opt matrix
        int[][] matrix = new int[n][m];
        for (int y = 0; y < m; y++) {
            matrix[n - 1][y] = 1;
        }
        for (int x = 0; x < n; x++) {
            matrix[x][m - 1] = 1;
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
            }
        }
        return matrix;        
        
    }
}

// [][][][][]
// [][][][][]
// [][][][][]
