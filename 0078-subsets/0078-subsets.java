class Solution {
    
    static void solve(int index , int[] nums,List<Integer> currAns,List<List<Integer>> ans){
        
        if(index >= nums.length){

            ans.add(new ArrayList<>(currAns));
            return;
        }
        solve(index+1,nums,currAns,ans);
        
        int n = nums[index];
        currAns.add(n);
        solve(index+1,nums,currAns,ans);
        currAns.remove(currAns.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> currAns = new ArrayList<Integer>();
        int  index =0;
        solve(index, nums, currAns, ans);
        return ans;
    }
}