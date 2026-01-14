import java.util.*;

class Solution {
    class Event implements Comparable<Event> {
        int y, x1, x2, type;
        Event(int y, int x1, int x2, int type) {
            this.y = y; this.x1 = x1; this.x2 = x2; this.type = type;
        }
        public int compareTo(Event other) { return Integer.compare(this.y, other.y); }
    }

    int[] count;
    long[] length;
    int[] xCoords;

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        TreeSet<Integer> xSet = new TreeSet<>();
        for (int[] s : squares) {
            events.add(new Event(s[1], s[0], s[0] + s[2], 1));
            events.add(new Event(s[1] + s[2], s[0], s[0] + s[2], -1));
            xSet.add(s[0]);
            xSet.add(s[0] + s[2]);
        }
        Collections.sort(events);

        xCoords = new int[xSet.size()];
        int idx = 0;
        for (int x : xSet) xCoords[idx++] = x;
        int n = xCoords.length;
        count = new int[4 * n];
        length = new long[4 * n];

        double totalArea = 0;
        for (int i = 0; i < events.size() - 1; i++) {
            update(1, 0, n - 2, events.get(i).x1, events.get(i).x2, events.get(i).type);
            totalArea += (double)length[1] * (events.get(i+1).y - events.get(i).y);
        }
        
        double target = totalArea / 2.0;
        double currentArea = 0;
        Arrays.fill(count, 0);
        Arrays.fill(length, 0);

        for (int i = 0; i < events.size() - 1; i++) {
            update(1, 0, n - 2, events.get(i).x1, events.get(i).x2, events.get(i).type);
            double segmentArea = (double)length[1] * (events.get(i+1).y - events.get(i).y);
            
            if (currentArea + segmentArea >= target) {
                double needed = target - currentArea;
                return events.get(i).y + (needed / length[1]);
            }
            currentArea += segmentArea;
        }
        
        return events.get(events.size()-1).y;
    }

    private void update(int node, int start, int end, int qx1, int qx2, int val) {
        if (xCoords[end + 1] <= qx1 || xCoords[start] >= qx2) return;
        if (xCoords[start] >= qx1 && xCoords[end + 1] <= qx2) {
            count[node] += val;
        } else {
            int mid = (start + end) / 2;
            update(2 * node, start, mid, qx1, qx2, val);
            update(2 * node + 1, mid + 1, end, qx1, qx2, val);
        }
        
        if (count[node] > 0) {
            length[node] = xCoords[end + 1] - xCoords[start];
        } else {
            length[node] = (start == end) ? 0 : length[2 * node] + length[2 * node + 1];
        }
    }
}