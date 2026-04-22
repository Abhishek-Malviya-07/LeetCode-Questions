class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);

        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        
        Map<Integer, Map<Integer, Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            components.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> counts = components.get(root);
          
            counts.put(source[i], counts.getOrDefault(source[i], 0) + 1);
        }

        int hammingDistance = 0;
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            Map<Integer, Integer> counts = components.get(root);
            int targetVal = target[i];

            
            if (counts.getOrDefault(targetVal, 0) > 0) {
                counts.put(targetVal, counts.get(targetVal) - 1);
            } else {
               
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

    class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) parent[rootI] = rootJ;
        }
    }
}