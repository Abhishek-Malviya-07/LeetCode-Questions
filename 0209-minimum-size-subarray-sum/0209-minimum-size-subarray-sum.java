class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int minLength = Integer.MAX_VALUE;
        int left =0 , right = 0 , sum = 0;

        while(right < nums.length){
            sum += nums[right];

            while(sum >= target){
                sum -= nums[left];
                minLength = Math.min(minLength , right -left +1);
                left++;
            }

            right++;
        }

        if(minLength == Integer.MAX_VALUE) return 0;

        return minLength;
    }
}