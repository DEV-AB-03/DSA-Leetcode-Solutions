class Node {
    int x, y, val;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = grid.get(0).get(0);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        pq.offer(new Node(0, 0, dist[0][0]));

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int r = curr.x, c = curr.y, value = curr.val;

            if (value > dist[r][c])
                continue; // stale entry

            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k], nc = c + dy[k];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int newDist = value + grid.get(nr).get(nc);
                if (newDist < dist[nr][nc]) {
                    dist[nr][nc] = newDist;
                    pq.offer(new Node(nr, nc, newDist));
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}