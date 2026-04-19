class Node {
    int x, y, color, time;

    Node(int x, int y, int color, int time) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.time = time;
    }
}

class Solution {

    boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public int[][] colorGrid(int n, int m, int[][] sources) {

        int[][] ans = new int[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<Node> q = new LinkedList<>();

        for (int[] s : sources) {
            int r = s[0], c = s[1], color = s[2];
            ans[r][c] = color;
            dist[r][c] = 0;
            q.offer(new Node(r, c, color, 0));
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (!isValid(nx, ny, n, m))
                    continue;

                int nt = cur.time + 1;

                if (dist[nx][ny] > nt) {
                    dist[nx][ny] = nt;
                    ans[nx][ny] = cur.color;
                    q.offer(new Node(nx, ny, cur.color, nt));
                } else if (dist[nx][ny] == nt && ans[nx][ny] < cur.color) {
                    ans[nx][ny] = cur.color;
                    q.offer(new Node(nx, ny, cur.color, nt));
                }
            }
        }

        return ans;
    }
}