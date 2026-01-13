class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0;
        double high = 2e9; 
        
        double totalArea = 0;
        for (int[] s : squares) {
            totalArea += (double) s[2] * s[2];
        }
        double target = totalArea / 2.0;

        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2;
            if (getAreaBelow(squares, mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return low;
    }

    private double getAreaBelow(int[][] squares, double y) {
        double area = 0;
        for (int[] s : squares) {
            double yi = s[1];
            double li = s[2];
            double top = yi + li;

            if (y <= yi) {
                continue; 
            } else if (y >= top) {
                area += li * li; 
            } else {
                area += (y - yi) * li; 
            }
        }
        return area;
    }
}