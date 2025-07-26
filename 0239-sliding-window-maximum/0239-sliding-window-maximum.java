class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // Make the current window valid
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }
            // Now remove all elements smaller then incoming element as they cannever be maximum for further sub arrays
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);

            // If we are in a valid window, record the max element
            if (i >= k - 1) {
                ans[ri++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}