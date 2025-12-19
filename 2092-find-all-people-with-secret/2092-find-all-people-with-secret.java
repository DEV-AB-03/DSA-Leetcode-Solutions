class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Sort by meetings by time
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        List<Integer> people = new ArrayList<>();

        int m = meetings.length;

        // We need to construct a graph for the same time interval
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;

        int i = 0;
        while (i < m) {
            int currentTime = meetings[i][2];
            Map<Integer, List<Integer>> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            while (i < m && meetings[i][2] == currentTime) {
                //Create Adjacency List for graph
                int x = meetings[i][0];
                int y = meetings[i][1];

                map.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                map.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                set.add(x);
                set.add(y);

                i++;
            }
            //BFS Traversal on Graph
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> pq = new LinkedList<>();
            for (int p : set) {
                if (knowsSecret[p] && !visited.contains(p)) {
                    pq.offer(p);
                    visited.add(p);
                }
            }
            while (!pq.isEmpty()) {
                int node = pq.poll();
                if (!map.containsKey(node)) {
                    continue;
                }
                //Traverse Neighbours
                for (int neighb : map.get(node)) {
                    if (!visited.contains(neighb)) {
                        visited.add(neighb);
                        knowsSecret[neighb] = true;
                        pq.offer(neighb);
                    }
                }
            }

        }
        for (int p = 0; p < n; p++) {
            if (knowsSecret[p]) {
                people.add(p);
            }
        }
        return people;
    }
}