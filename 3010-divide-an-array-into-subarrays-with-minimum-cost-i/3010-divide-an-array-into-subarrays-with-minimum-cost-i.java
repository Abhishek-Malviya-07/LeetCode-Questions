class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        
        int firstCost = nums[0];
        
        int[] remaining = new int[n - 1];
        for (int i = 1; i < n; i++) {
            remaining[i - 1] = nums[i];
        }
        
        Arrays.sort(remaining);
        
        return firstCost + remaining[0] + remaining[1];
    }
}