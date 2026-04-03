class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> robots[a] - robots[b]);

        int[] R = new int[n], D = new int[n];
        for (int i = 0; i < n; i++) { R[i] = robots[idx[i]]; D[i] = distance[idx[i]]; }

        int[] W = walls.clone();
        Arrays.sort(W);
        int[] lLo = new int[n], lHi = new int[n];
        int[] rLo = new int[n], rHi = new int[n];

        for (int i = 0; i < n; i++) {
            int lb = R[i] - D[i];
            if (i > 0) lb = Math.max(lb, R[i-1] + 1);
            lLo[i] = lowerBound(W, lb);
            lHi[i] = upperBound(W, R[i]);

            int rb = R[i] + D[i];
            if (i < n-1) rb = Math.min(rb, R[i+1] - 1);
            rLo[i] = lowerBound(W, R[i]);
            rHi[i] = upperBound(W, rb);
        }
        int[] ov = new int[n];
        for (int i = 1; i < n; i++) {
            int lo = Math.max(rLo[i-1], lLo[i]);
            int hi = Math.min(rHi[i-1], lHi[i]);
            ov[i] = Math.max(0, hi - lo);
        }

        int[] dp = new int[]{
            lHi[0] - lLo[0],
            rHi[0] - rLo[0]
        };

        for (int i = 1; i < n; i++) {
            int lC = lHi[i] - lLo[i];
            int rC = rHi[i] - rLo[i];
            int[] ndp = new int[2];
            ndp[0] = Math.max(
                dp[0] + lC,           
                dp[1] + lC - ov[i]    
            );
            ndp[1] = Math.max(
                dp[0] + rC,
                dp[1] + rC
            );
            ndp[1] = dp[0] > dp[1] ? dp[0] + rC : dp[1] + rC; 
            ndp[1] = Math.max(dp[0], dp[1]) + rC;

            dp = ndp;
        }

        return Math.max(dp[0], dp[1]);
    }

    private int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}