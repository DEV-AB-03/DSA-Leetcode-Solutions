class Solution {
    public int minimumDistance(int[] nums) {
        // HashMap
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                List<Integer> idx = map.get(key);
                idx.add(i);
                map.put(key, idx);
            } else {
                List<Integer> idx = new ArrayList<>();
                idx.add(i);
                map.put(key, idx);
            }
        }
        for (List<Integer> set : map.values()) {
            if (set.size() >= 3) {
                for (int i = 0; i + 2 < set.size(); i++) {
                    int dis = 2 * (set.get(i + 2) - set.get(i));
                    dist = Math.min(dist, dis);
                }
            }
        }
        if (dist != Integer.MAX_VALUE) {
            return dist;
        }
        return -1;

    }
}