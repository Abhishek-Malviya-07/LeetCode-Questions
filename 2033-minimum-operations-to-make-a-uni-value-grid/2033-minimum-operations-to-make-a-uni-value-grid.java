class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;
       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = grid[i][j];
            }
        }
        
      
        int remainder = arr[0] % x;
        for (int val : arr) {
            if (val % x != remainder) {
                return -1;
            }
        }
        
       
        Arrays.sort(arr);
        int median = arr[arr.length / 2];
        
       
        int totalOps = 0;
        for (int val : arr) {
            totalOps += Math.abs(val - median) / x;
        }
        
        return totalOps;
    }
}