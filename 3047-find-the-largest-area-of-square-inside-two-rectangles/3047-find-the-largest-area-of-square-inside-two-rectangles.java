class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                long xStart = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long yStart = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                long xEnd = Math.min(topRight[i][0], topRight[j][0]);
                long yEnd = Math.min(topRight[i][1], topRight[j][1]);

                if (xEnd > xStart && yEnd > yStart) {
                    long width = xEnd - xStart;
                    long height = yEnd - yStart;
                    
                    long currentSide = Math.min(width, height);
                    maxSide = Math.max(maxSide, currentSide);
                }
            }
        }

        return maxSide * maxSide;
    }
}