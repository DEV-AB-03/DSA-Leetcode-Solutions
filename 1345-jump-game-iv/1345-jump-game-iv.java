class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;

        // value -> list of indices with same value
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>(); // {index, jumps}
        queue.offer(new int[] { 0, 0 });
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], jumps = curr[1];

            // try i+1
            if (i + 1 < n && !visited[i + 1]) {
                if (i + 1 == n - 1)
                    return jumps + 1;
                visited[i + 1] = true;
                queue.offer(new int[] { i + 1, jumps + 1 });
            }

            // try i-1
            if (i - 1 >= 0 && !visited[i - 1]) {
                if (i - 1 == n - 1)
                    return jumps + 1;
                visited[i - 1] = true;
                queue.offer(new int[] { i - 1, jumps + 1 });
            }

            // try all same-value indices
            if (map.containsKey(arr[i])) {
                for (int idx : map.get(arr[i])) {
                    if (!visited[idx]) {
                        if (idx == n - 1)
                            return jumps + 1;
                        visited[idx] = true;
                        queue.offer(new int[] { idx, jumps + 1 });
                    }
                }
                map.remove(arr[i]); // clear to avoid re-processing
            }
        }

        return -1; // unreachable
    }
}