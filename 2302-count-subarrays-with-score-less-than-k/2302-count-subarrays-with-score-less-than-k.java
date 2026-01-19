class Solution {
    public long countSubarrays(int[] nums, long k) {
        
        int left =0, right =0 , length =0 ;
        long ans =0;
        long sum  =0 ;
        long score = 0;

        while(right < nums.length){

            sum += nums[right];
            length = right -left+1;
            score = sum * length;

            while(score >= k && left <= right){
                sum -= nums[left];
                left++;
                length = right -left+1;
                score = sum * length;

            }
            ans += right - left +1;
            right++;
        }

        return ans;
    }
}