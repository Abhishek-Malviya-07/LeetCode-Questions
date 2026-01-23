import java.util.*;

class Solution {
    // Custom class to mimic the C++ pair<long long, int>
    class Node implements Comparable<Node> {
        long sum;
        int index;

        Node(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }

        @Override
        public int compareTo(Node other) {
            if (this.sum != other.sum) {
                return Long.compare(this.sum, other.sum);
            }
            // If sums are equal, choose the leftmost index (Example requirement)
            return Integer.compare(this.index, other.index);
        }
    }

    public int minimumPairRemoval(int[] nums1) {
        int n = nums1.length;
        if (n < 2) return 0;

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) nums[i] = nums1[i];

        int[] nextIndex = new int[n];
        int[] prevIndex = new int[n];

        for (int i = 0; i < n; i++) {
            nextIndex[i] = i + 1;
            prevIndex[i] = i - 1;
        }

        // TreeSet acts like std::set in C++ (ordered, unique, O(log N) operations)
        TreeSet<Node> pairSumSet = new TreeSet<>();
        int badPairCount = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) badPairCount++;
            pairSumSet.add(new Node(nums[i] + nums[i + 1], i));
        }

        int mergeOperations = 0;

        while (badPairCount > 0 && !pairSumSet.isEmpty()) {
            // Equivalent to pairSumSet.begin()
            Node first = pairSumSet.pollFirst();
            int currIdx = first.index;
            int nextIdx = nextIndex[currIdx];
            int prevIdx = prevIndex[currIdx];
            int nextNextIdx = nextIndex[nextIdx];

            // 1. Check if the pair we are merging was out of order
            if (nums[currIdx] > nums[nextIdx]) badPairCount--;

            // 2. Handle the left neighbor (prevIdx)
            if (prevIdx >= 0) {
                // If the old relation was bad, decrement count
                if (nums[prevIdx] > nums[currIdx]) badPairCount--;
                // If the NEW relation after merge will be bad, increment count
                if (nums[prevIdx] > nums[currIdx] + nums[nextIdx]) badPairCount++;
                
                // Remove old sum from set
                pairSumSet.remove(new Node(nums[prevIdx] + nums[currIdx], prevIdx));
            }

            // 3. Handle the right neighbor (nextNextIdx)
            if (nextNextIdx < n) {
                if (nums[nextIdx] > nums[nextNextIdx]) badPairCount--;
                if (nums[currIdx] + nums[nextIdx] > nums[nextNextIdx]) badPairCount++;
                
                // Remove old sum from set
                pairSumSet.remove(new Node(nums[nextIdx] + nums[nextNextIdx], nextIdx));
            }

            // 4. Perform Merge
            nums[currIdx] = nums[currIdx] + nums[nextIdx];
            nextIndex[currIdx] = nextNextIdx;
            if (nextNextIdx < n) prevIndex[nextNextIdx] = currIdx;

            // 5. Re-insert updated sums into the set
            if (prevIdx >= 0) {
                pairSumSet.add(new Node(nums[prevIdx] + nums[currIdx], prevIdx));
            }
            if (nextNextIdx < n) {
                pairSumSet.add(new Node(nums[currIdx] + nums[nextNextIdx], currIdx));
            }

            mergeOperations++;
        }

        return mergeOperations;
    }
}