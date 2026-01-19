class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int left =0 , right =0 , currSum =0 , maxSum = 0;

        HashSet<Integer> set = new HashSet<>();

        while(right < nums.length){

            while(set.contains(nums[right])){
                currSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            currSum += nums[right];
            set.add(nums[right]);

            right++;

            maxSum = Math.max(maxSum , currSum);

        }

        return maxSum;
    }
}