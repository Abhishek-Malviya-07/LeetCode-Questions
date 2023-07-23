class Solution {
    public List<List<Integer>> permute(int[] nums) {
     
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
    //  List<Integer> currAns = new ArrayList<Integer>();
      List<Integer> input = new ArrayList<Integer>();  
        for(int i : nums){
            input.add(i);
        }
      int index = 0;
        
      solve(input,ans, index); 
       return ans; 
        
    }
   static void solve(List<Integer> input, List<List<Integer>> ans, int index){
       
       if(index >= input.size()){
           ans.add(new ArrayList<>(input));
           return;
       }
       
       for(int i=index; i<input.size(); i++){
           Collections.swap(input , index , i);
           solve(input,ans, index+1);
           Collections.swap(input , index , i);    
       }
   }
    
    
}