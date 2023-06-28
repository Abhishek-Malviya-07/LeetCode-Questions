class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int count = 1;
        int check = 1;

        for(int i=1; i<size; i++){
          if(check <2 && nums[i] == nums[i-1]){
            nums[count] = nums[i];
            check++; count++; 
          }else if(nums[i] != nums[i-1]){
            nums[count] = nums[i];
            check =1; count++;
          }
             
          

        }
        return count;
    }
}