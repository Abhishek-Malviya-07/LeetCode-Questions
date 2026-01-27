class Solution {
    // Change return type to int if the problem signature requires it
    public int minCost(int n, int[][] edges) {
        List<long[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj[u].add(new long[]{v, w});
            adj[v].add(new long[]{u, 2L * w});
        }
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];
            
            if (d > dist[u]) continue;
            
            for (long[] neighbor : adj[u]) {
                int v = (int) neighbor[0];
                long weight = neighbor[1];
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new long[]{v, dist[v]});
                }
            }
        }
        
        if (dist[n - 1] == Long.MAX_VALUE) return -1;
        return (int) dist[n - 1]; 
    }
}