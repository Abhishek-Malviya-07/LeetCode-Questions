class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int size = nums.length;
        
        int ans = 0; 
        int update =0;
        for(int i=0; i<size; i++){
           
            
            
           if(nums[i] == 1){
                update++;
           }else{
             update =0;
               
           }
            if(update > ans) ans = update;
            
        }  
       return ans; 
    }
}