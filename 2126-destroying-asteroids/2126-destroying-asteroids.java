class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Sorting
        Arrays.sort(asteroids);
        long currentMass = mass;
        for (int i = 0; i < asteroids.length; i++) {
            // Check breaking condition
            if (currentMass < asteroids[i]) {
                return false;
            } else {
                currentMass += asteroids[i];
            }
        }

        return true;
    }
}