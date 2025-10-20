import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        String smallest = s;
        int n = s.length();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(smallest) < 0) {
                smallest = cur;
            }

            // Operation 1: add 'a' to all odd indices
            char[] arr = cur.toCharArray();
            for (int i = 1; i < n; i += 2) {
                arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
            }
            String added = new String(arr);
            if (visited.add(added)) {
                q.offer(added);
            }

            // Operation 2: rotate right by b
            String rotated = cur.substring(n - b) + cur.substring(0, n - b);
            if (visited.add(rotated)) {
                q.offer(rotated);
            }
        }

        return smallest;
    }
}
