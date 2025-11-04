import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        // build first window
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        ans[0] = getXSum(freq, x);

        // slide window
        for (int i = k; i < n; i++) {
            int remove = nums[i - k];
            int add = nums[i];

            // remove old
            freq.put(remove, freq.get(remove) - 1);
            if (freq.get(remove) == 0)
                freq.remove(remove);

            // add new
            freq.put(add, freq.getOrDefault(add, 0) + 1);

            ans[i - k + 1] = getXSum(freq, x);
        }

        return ans;
    }

    private int getXSum(Map<Integer, Integer> freq, int x) {
        // max-heap by freq desc, value desc
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1])
                return b[1] - a[1]; // higher freq first
            return b[0] - a[0]; // higher value first
        });

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[] { e.getKey(), e.getValue() });
        }

        int sum = 0;
        int count = 0;
        while (!pq.isEmpty() && count < x) {
            int[] top = pq.poll();
            sum += top[0] * top[1];
            count++;
        }

        return sum;
    }
}
