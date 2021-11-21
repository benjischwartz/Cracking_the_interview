// Subproblems;
// Define opt(x, y) as the problem of determining the number of possible
// unique paths from (x, y) to (n, -m) travelling only down and right

// Base Cases:
//  ON THE EDGE:
//      if (y == -m) {return 1}
//      if (x == n) {return 1}

// Recursion:
//      return (opt(x, y - 1) + opt(x + 1, y));

class UniquePaths {
    public int uniquePaths(int m, int n) {
        int total = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y > -m; y--) {
                total += uniquePathsFromXY(x, y, m, n);
            }
        }
        return total;
    }
    
    public int uniquePathsFromXY(int x, int y, int m, int n) {
        if (x == n - 1 || y == -m + 1) {
            return 1;
        }
        else {
            return (uniquePathsFromXY(x + 1, y, m, n) + uniquePathsFromXY(x, y - 1, m, n));
        }
    }
}

// [][]
// [][]
// [][]
