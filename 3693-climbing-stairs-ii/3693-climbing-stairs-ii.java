class Solution {
    public int climbStairs(int n, int[] costs) {
        
        int prev3 = 0; 
        int prev2 = 0;
        int prev1 = 0;
        
        for (int i = 1; i <= n; i++) {
            
            int curr = Integer.MAX_VALUE;
            
            curr = Math.min(curr, prev1 + costs[i - 1] + 1);
            
            if (i - 2 >= 0)
                curr = Math.min(curr, prev2 + costs[i - 1] + 4);
            
            if (i - 3 >= 0)
                curr = Math.min(curr, prev3 + costs[i - 1] + 9);
            
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}