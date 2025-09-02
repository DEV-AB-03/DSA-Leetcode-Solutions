import java.util.*;

class Solution {
    // Function to calculate boost of adding 1 student
    private double calculateBoost(int pass, int total) {
        double curr = (double) pass / total;
        double newVal = (double) (pass + 1) / (total + 1);
        return newVal - curr;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double avgPass = 0.0;

        // Deep copy classes → so we don’t mutate original
        int[][] newClasses = new int[classes.length][];
        for (int i = 0; i < classes.length; i++) {
            newClasses[i] = Arrays.copyOf(classes[i], classes[i].length);
        }

        // Distribute students one by one
        while (extraStudents > 0) {
            double maxBoost = -1;
            int index = -1;

            // Find the class with the maximum boost
            for (int i = 0; i < newClasses.length; i++) {
                double boost = calculateBoost(newClasses[i][0], newClasses[i][1]);
                if (boost > maxBoost) {
                    maxBoost = boost;
                    index = i;
                }
            }

            // Add one student to that class
            newClasses[index][0]++;
            newClasses[index][1]++;
            extraStudents--;
        }

        // Compute average pass ratio
        for (int[] c : newClasses) {
            avgPass += (double) c[0] / c[1];
        }

        return avgPass / classes.length;
    }
}
