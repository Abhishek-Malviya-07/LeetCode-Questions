// one more solution
​
class Solution {
public List<List<Integer>> combinationSum(int[] candidates, int target) {
List<List<Integer>> ans = new ArrayList<List<Integer>>();
List<Integer> currAns = new ArrayList<Integer>();
int currSum =0;
int index =0;
solve(candidates , target,ans , currAns , currSum , index);
return ans;
}
static void solve(int[] c , int target ,  List<List<Integer>> ans, List<Integer> currAns, int currSum,int                                                                                                           index){
if(currSum > target){
return;
}
if(index == c.length){
if(currSum == target){
ans.add(new ArrayList<Integer>(currAns));
}
return;
}
currSum += c[index];
currAns.add(c[index]);
solve(c , target , ans,currAns, currSum,index);
currSum -= c[index];
currAns.remove(currAns.size()-1);
solve(c , target , ans,currAns, currSum,index+1);
}
}