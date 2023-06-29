class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static class State {
        int x;
        int y;
        int keys;
        int steps;

        public State(int x, int y, int keys, int steps) {
            this.x = x;
            this.y = y;
            this.keys = keys;
            this.steps = steps;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int startX = 0;
        int startY = 0;
        int totalKeys = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startX = i;
                    startY = j;
                } else if (Character.isLowerCase(c)) {
                    totalKeys++;
                }
            }
        }

        PriorityQueue<State> queue = new PriorityQueue<>((a, b) -> a.steps - b.steps);
        Set<String> visited = new HashSet<>();
        queue.offer(new State(startX, startY, 0, 0));
        visited.add(startX + "," + startY + ",0");

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.keys == (1 << totalKeys) - 1) {
                return curr.steps;
            }

            for (int[] dir : DIRECTIONS) {
                int newX = curr.x + dir[0];
                int newY = curr.y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    char nextCell = grid[newX].charAt(newY);

                    if (nextCell == '#' || (Character.isUpperCase(nextCell) && !hasKey(curr.keys, nextCell))) {
                        continue; // Skip if it's a wall or a locked door without a key
                    }

                    int nextKeys = curr.keys;
                    if (Character.isLowerCase(nextCell)) {
                        nextKeys |= (1 << (nextCell - 'a')); // Collect the key
                    }

                    String nextState = newX + "," + newY + "," + nextKeys;
                    if (!visited.contains(nextState)) {
                        queue.offer(new State(newX, newY, nextKeys, curr.steps + 1));
                        visited.add(nextState);
                    }
                }
            }
        }

        return -1; // If we couldn't collect all the keys
    }

    private boolean hasKey(int keys, char lock) {
        int keyBit = 1 << (Character.toLowerCase(lock) - 'a');
        return (keys & keyBit) != 0;
    }
}