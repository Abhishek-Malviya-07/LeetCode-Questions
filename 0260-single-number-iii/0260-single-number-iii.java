class Solution {
    public int[] singleNumber(int[] nums) {
       int sum = 0;
        for(int i : nums){
            sum = (sum^i);
        }
        
        sum = (sum & -sum);
        
        int x = 0;
        int y = 0;
        
        for(int i=0; i<nums.length; i++){
            if((nums[i] & sum) > 0){
               x = x^nums[i];
            }else{
                y = y^nums[i];
            }
        }
        int[] a = new int[2];
        a[0] = x;
        a[1]= y;
        
        return a;
    }
}