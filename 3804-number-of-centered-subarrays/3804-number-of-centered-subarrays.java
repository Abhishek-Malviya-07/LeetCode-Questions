class Solution {
    public int centeredSubarrays(int[] nums) {
        int centered = 0;
        int length = nums.length;

        for(int i=0; i<length; i++){

            long sum = 0;
            for(int j=i; j<length; j++){
                sum += nums[j];

                for(int c =i; c<= j; c++){
                    if(nums[c] == sum){
                        centered++;
                        break;
                    }
                }
            }
        }
        return centered;
    }
}