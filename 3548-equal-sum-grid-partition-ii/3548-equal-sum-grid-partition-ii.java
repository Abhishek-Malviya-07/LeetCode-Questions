class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;
        Map<Integer, Integer> totalFreq = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += (long) grid[i][j];
                totalFreq.put(grid[i][j], totalFreq.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        
        if (check(grid, m, n, totalSum, totalFreq, true)) return true;
        
        if (check(grid, m, n, totalSum, totalFreq, false)) return true;

        return false;
    }

    private boolean check(int[][] grid, int m, int n, long totalSum, Map<Integer, Integer> totalFreq, boolean isHorizontal) {
        int limit = isHorizontal ? m : n;
        long s1 = 0;
        Map<Integer, Integer> s1Freq = new HashMap<>();

        for (int i = 0; i < limit - 1; i++) {
           
            if (isHorizontal) {
                for (int j = 0; j < n; j++) {
                    s1 += grid[i][j];
                    s1Freq.put(grid[i][j], s1Freq.getOrDefault(grid[i][j], 0) + 1);
                }
            } else {
                for (int j = 0; j < m; j++) {
                    s1 += grid[j][i];
                    s1Freq.put(grid[j][i], s1Freq.getOrDefault(grid[j][i], 0) + 1);
                }
            }

            long s2 = totalSum - s1;
            if (s1 == s2) return true;

            
            long diff1 = s1 - s2;
            if (diff1 > 0 && diff1 <= 100000 && s1Freq.containsKey((int)diff1)) {
                if (isSafe(isHorizontal ? i + 1 : m, isHorizontal ? n : i + 1, (int)diff1, grid, 0, i, isHorizontal, true)) return true;
            }

          
            long diff2 = s2 - s1;
            if (diff2 > 0 && diff2 <= 100000) {
                int v = (int)diff2;
                if (totalFreq.getOrDefault(v, 0) - s1Freq.getOrDefault(v, 0) > 0) {
                    if (isSafe(isHorizontal ? m - (i + 1) : m, isHorizontal ? n : n - (i + 1), v, grid, i + 1, limit - 1, isHorizontal, false)) return true;
                }
            }
        }
        return false;
    }

    private boolean isSafe(int H, int W, int val, int[][] grid, int start, int end, boolean isHorizontal, boolean isS1) {
        if (H > 1 && W > 1) return true;
        
        
        if (isHorizontal) {
            if (W == 1) { 
                return val == grid[start][0] || val == grid[end][0];
            } else { 
                for (int j = 0; j < W; j++) {
                    if (grid[start][j] == val && (j == 0 || j == W - 1)) return true;
                }
            }
        } else { 
            if (H == 1) { 
                return val == grid[0][start] || val == grid[0][end];
            } else { 
                for (int i = 0; i < H; i++) {
                    if (grid[i][start] == val && (i == 0 || i == H - 1)) return true;
                }
            }
        }
        return false;
    }
}