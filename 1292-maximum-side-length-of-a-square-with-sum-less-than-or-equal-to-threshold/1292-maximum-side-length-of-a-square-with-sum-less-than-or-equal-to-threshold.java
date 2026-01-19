class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] p = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                p[i][j] = mat[i - 1][j - 1] + p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1];
            }
        }

        int ans = 0;
    
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                int k = ans + 1; 
                if (i >= k && j >= k) {
                    int sum = p[i][j] - p[i - k][j] - p[i][j - k] + p[i - k][j - k];
                    if (sum <= threshold) {
                        ans = k; 
                    }
                }
            }
        }

        return ans;
    }
}