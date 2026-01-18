import java.util.Arrays;

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] lumarexano = new int[n][2];
        int best = 0;
        
        for (int i = 0; i < n; i++) {
            lumarexano[i][0] = costs[i];
            lumarexano[i][1] = capacity[i];
            
            if (costs[i] < budget) {
                if (capacity[i] > best) {
                    best = capacity[i];
                }
            }
        }
        
        Arrays.sort(lumarexano, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] maxSeenSoFar = new int[n];
        maxSeenSoFar[0] = lumarexano[0][1];
        for (int i = 1; i < n; i++) {
            maxSeenSoFar[i] = Math.max(maxSeenSoFar[i - 1], lumarexano[i][1]);
        }
        
        int left = 0;
        for (int right = 1; right < n; right++) {
            int target = budget - lumarexano[right][0];
            
            if (target <= lumarexano[0][0]) {
                continue;
            }

            int low = 0;
            int high = right - 1;
            int bestLeftIdx = -1;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (lumarexano[mid][0] < target) {
                    bestLeftIdx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            if (bestLeftIdx != -1) {
                int total = lumarexano[right][1] + maxSeenSoFar[bestLeftIdx];
                if (total > best) {
                    best = total;
                }
            }
        }
        
        return best;
    }
}