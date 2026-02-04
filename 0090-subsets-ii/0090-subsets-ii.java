class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<>();

        subset(nums , 0 , ans , output);
        return ans;
    }

    public static void subset(int[] nums , int index , List<List<Integer>> ans ,       List<Integer> output){
     
       
        if(index == nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }

        output.add(nums[index]);
        subset(nums ,index+1, ans , output);

        output.remove(output.size() - 1);

        while(index+1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        subset(nums ,index+1, ans , output);
    }
}