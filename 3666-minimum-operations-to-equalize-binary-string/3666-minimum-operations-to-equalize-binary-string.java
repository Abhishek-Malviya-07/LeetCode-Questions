class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (char c : s.toCharArray()) if (c == '0') initialZeros++;
        
        if (initialZeros == 0) return 0;

        TreeSet<Integer> evenUnvisited = new TreeSet<>();
        TreeSet<Integer> oddUnvisited = new TreeSet<>();
        
        for (int i = 0; i <= n; i++) {
            if (i == initialZeros) continue;
            if (i % 2 == 0) evenUnvisited.add(i);
            else oddUnvisited.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(initialZeros);
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int z = queue.poll();
                
                int L = z + k - 2 * Math.min(z, k);
                int R = z + k - 2 * Math.max(0, k - (n - z));
                
                TreeSet<Integer> targetSet = ((z + k) % 2 == 0) ? evenUnvisited : oddUnvisited;
                
                Integer current = targetSet.ceiling(L);
                while (current != null && current <= R) {
                    if (current == 0) return steps;
                    queue.add(current);
                    targetSet.remove(current); 
                    current = targetSet.ceiling(L);
                }
            }
        }

        return -1;
    }
}