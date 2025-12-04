class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;

        // Skip all L's on the left side (they move left forever)
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }

        // Skip all R's on the right side (they move right forever)
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int collisions = 0;
        // Count all L and R in the "middle" segment
        for (int i = left; i <= right; i++) {
            char c = directions.charAt(i);
            if (c == 'L' || c == 'R') {
                collisions++;
            }
        }

        return collisions;
    }
}
