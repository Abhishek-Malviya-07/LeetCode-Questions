class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> h = new ArrayList<>();
        h.add(1);
        h.add(m);
        for (int f : hFences) h.add(f);
        Collections.sort(h);

        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                hGaps.add(h.get(j) - h.get(i));
            }
        }

        List<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(n);
        for (int f : vFences) v.add(f);
        Collections.sort(v);

        long maxSide = -1;
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                int gap = v.get(j) - v.get(i);
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        if (maxSide == -1) return -1;
        
        long mod = 1_000_000_007;
        return (int) ((maxSide * maxSide) % mod);
    }
}