class Solution {
    public void dfs(int num, List<Integer> ans, int low, int high, int prevDigit) {
        // Base Case
        if (num > high) {
            // We cannot expand anymore
            return;
        }
        if (num >= low && num <= high) {
            // Add num to answer
            ans.add(num);
        }

        // Can't extend further if prevDigit is 9 (no valid next digit)
        if (prevDigit == 9) {
            return;
        }

        // Generate next number by appending prevDigit+1
        int newNum = num * 10 + (prevDigit + 1);
        if (newNum <= high) {
            // Recurse further
            dfs(newNum, ans, low, high, prevDigit + 1);
        }
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, ans, low, high, i);
        }
        Collections.sort(ans);
        return ans;
    }
}