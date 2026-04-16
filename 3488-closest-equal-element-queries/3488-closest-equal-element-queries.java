import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Store value -> list of indices where it appears
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            // If only one occurrence exists
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            // Find current index position in sorted list
            int pos = Collections.binarySearch(list, q);

            int m = list.size();

            // Previous same element index (circular in occurrence list)
            int prev = list.get((pos - 1 + m) % m);

            // Next same element index
            int next = list.get((pos + 1) % m);

            // Circular distance function
            int distPrev = Math.min(Math.abs(q - prev), n - Math.abs(q - prev));
            int distNext = Math.min(Math.abs(q - next), n - Math.abs(q - next));

            ans.add(Math.min(distPrev, distNext));
        }

        return ans;
    }
}