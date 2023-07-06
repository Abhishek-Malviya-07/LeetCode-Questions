class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        if (length == 0)
            return 0;

        while (right < length) {
            if (sum < target) {
                sum += nums[right];
                right++;
            } else {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left];
                left++;
            }
        }
        
        while (sum >= target) {
            minLength = Math.min(minLength, right - left);
            sum -= nums[left];
            left++;
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
