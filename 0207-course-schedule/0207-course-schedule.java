class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Kahn's Algorithm
        // Similar to detecting cycle in Directed Graph
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
        }
        Queue<Integer> pq = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }
        int count = 0;
        while (!pq.isEmpty()) {
            Integer it = pq.poll();
            count++;
            // Reduce Indegree Count
            for (int[] edge : prerequisites) {
                if (edge[1] == it) {
                    indegree[edge[0]]--;
                    if (indegree[edge[0]] == 0) {
                        pq.offer(edge[0]);
                    }
                }
            }
        }
        return count == numCourses;
    }
}