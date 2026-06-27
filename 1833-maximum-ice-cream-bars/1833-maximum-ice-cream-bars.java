class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Count Sort
        // We can buy more ice cream costing less
        int count = 0;
        int max = -1;
        for (int cost : costs) {
            max = Math.max(max, cost);
        }
        int[] arr = new int[max + 1];

        for (int cost : costs) {
            arr[cost]++;
        }
        for (int i = 1; i <= max; i++) {
            if (arr[i] == 0) {
                continue;
            }
            int canBuy = Math.min(arr[i], coins / i);
            count += canBuy;
            coins -= canBuy * i;
        }
        return count;
    }
}