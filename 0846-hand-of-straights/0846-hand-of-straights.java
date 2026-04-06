class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Fill Map
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        Arrays.sort(hand);

        for (int num : hand) {
            if (map.get(num) == 0) {
                continue;
            }
            // Try to form Groups
            for (int i = 0; i < groupSize; i++) {
                int curr = num + i;
                if (map.getOrDefault(curr, 0) == 0) {
                    return false;
                }
                map.put(curr, map.get(curr) - 1);
            }
        }
        return true;
    }
}