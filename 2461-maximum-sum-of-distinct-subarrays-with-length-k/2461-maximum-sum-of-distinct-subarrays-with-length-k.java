class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long currSum =0;
        long maxSum = 0;
        int i = 0;

        HashSet<Integer> unique = new HashSet<>();

        for(int j=0; j<nums.length; j++ ){

            while(unique.contains(nums[j])){
                currSum -= nums[i];
                unique.remove(nums[i]);
                i++;
            }

            unique.add(nums[j]);
            currSum += nums[j];

            if(j-i+1 > k){

                currSum -= nums[i];
                unique.remove(nums[i]);
                i++;

            }

            if(j-i+1 == k){
                maxSum = Math.max(currSum , maxSum);
            }
        }

        return maxSum;
        
    }
}