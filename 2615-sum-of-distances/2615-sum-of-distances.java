class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

      
        for (int i = 0; i < n; i++) {
            indexMap.putIfAbsent(nums[i], new ArrayList<>());
            indexMap.get(nums[i]).add(i);
        }

        
        for (List<Integer> indices : indexMap.values()) {
            int k = indices.size();
            if (k <= 1) continue;

            long totalSum = 0;
            for (int idx : indices) {
                totalSum += idx;
            }

            long prefixSum = 0;
            for (int i = 0; i < k; i++) {
                long currentIdx = indices.get(i);
                
                
                
                long leftSide = (long) i * currentIdx - prefixSum;
                long suffixSum = totalSum - prefixSum - currentIdx;
                long rightSide = suffixSum - (long) (k - 1 - i) * currentIdx;
                
                result[(int) currentIdx] = leftSide + rightSide;
                
                prefixSum += currentIdx;
            }
        }

        return result;
    }
}