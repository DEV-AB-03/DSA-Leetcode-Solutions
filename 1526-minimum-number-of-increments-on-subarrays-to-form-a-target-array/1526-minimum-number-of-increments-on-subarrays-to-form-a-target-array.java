public class Solution {
    public int minNumberOperations(int[] target) {
        int ops = target[0];
        for (int i = 1; i < target.length; i++) {
            ops += Math.max(0, target[i] - target[i - 1]);
        }
        return ops;
    }
}
