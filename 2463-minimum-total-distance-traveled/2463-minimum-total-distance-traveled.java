import java.util.*;

class Solution {
    long[][] memo;
    List<Integer> robots;
    int[][] factories;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        this.robots = robot;
        this.factories = factory;

        int n = robot.size();
        int m = factory.length;

        memo = new long[n][m];
        for (long[] row : memo)
            Arrays.fill(row, -1);

        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        // all robots assigned
        if (i == robots.size())
            return 0;

        // no factories left
        if (j == factories.length)
            return (long) 1e15;

        if (memo[i][j] != -1)
            return memo[i][j];

        long res = dfs(i, j + 1); // skip current factory

        long cost = 0;
        int pos = factories[j][0];
        int limit = factories[j][1];

        // try assigning k robots to this factory
        for (int k = 1; k <= limit && i + k - 1 < robots.size(); k++) {
            cost += Math.abs(robots.get(i + k - 1) - pos);

            long next = dfs(i + k, j + 1);
            res = Math.min(res, cost + next);
        }

        return memo[i][j] = res;
    }
}