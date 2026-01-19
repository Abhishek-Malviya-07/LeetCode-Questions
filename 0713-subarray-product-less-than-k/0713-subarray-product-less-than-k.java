class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left =0 , right =0 ,ans =0;
        long prod =1 ;


        while(right < nums.length){

            prod *= nums[right];

            while(prod >= k && left <= right){
              prod = prod/ nums[left];
              left++;

            }
          
            ans = ans + (right-left+1);

            right++;
            
        }

        return ans;
    }
}