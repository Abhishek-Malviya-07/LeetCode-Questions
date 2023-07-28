
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates array to optimize pruning
        solve(candidates, target, ans, currAns, 0);
        return ans;
    }

    static void solve(int[] c, int target, List<List<Integer>> ans, List<Integer> currAns, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(currAns));
            return;
        }

        for (int i = start; i < c.length && c[i] <= target; i++) {
            currAns.add(c[i]);
            solve(c, target - c[i], ans, currAns, i); // Use i instead of index+1 to avoid duplicates
            currAns.remove(currAns.size() - 1);
        }
    }
}
