class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long INF = Long.MIN_VALUE / 2;
        long ans = INF;

        // Representing the DP states for index i+1
        long[] next = new long[4];
        
        // Base case: at index n (end of array)
        for (int state = 0; state < 4; state++) {
            next[state] = (state == 3) ? 0 : INF;
        }

        // Tabulation: Moving backwards from n-1 to 0
        for (int i = n - 1; i >= 0; i--) {
            long[] curr = new long[4];
            
            // STATE 3: Final Increasing (The "Tail")
            // Can be just the current number or extended if increasing
            curr[3] = nums[i]; 
            if (i + 1 < n && nums[i] < nums[i + 1])
                curr[3] = Math.max(curr[3], nums[i] + next[3]);

            // STATE 2: Strictly Decreasing (The "Valley")
            // Must transition to State 3 (starting the second climb)
            curr[2] = INF;
            if (i + 1 < n && nums[i] > nums[i + 1])
                curr[2] = Math.max(curr[2], nums[i] + next[2]);
            if (i + 1 < n && nums[i] < nums[i + 1])
                curr[2] = Math.max(curr[2], nums[i] + next[3]);

            // STATE 1: Strictly Increasing (The "Peak")
            // Must transition to State 2 (starting the descent)
            curr[1] = INF;
            if (i + 1 < n && nums[i] < nums[i + 1])
                curr[1] = Math.max(curr[1], nums[i] + next[1]);
            if (i + 1 < n && nums[i] > nums[i + 1])
                curr[1] = Math.max(curr[1], nums[i] + next[2]);

            // STATE 0: The Start (Initiating the first climb)
            curr[0] = INF;
            if (i + 1 < n && nums[i] < nums[i + 1])
                curr[0] = nums[i] + next[1];

            // Every curr[0] represents a valid trionic subarray starting at index i
            ans = Math.max(ans, curr[0]);

            // Move current values to 'next' for the next iteration (index i-1)
            next = curr;
        }

        return ans;
    }
}