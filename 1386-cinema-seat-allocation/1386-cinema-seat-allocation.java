import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Map row -> set of reserved seats
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            map.putIfAbsent(seat[0], new HashSet<>());
            map.get(seat[0]).add(seat[1]);
        }

        int result = 0;

        // Rows with no reservations → 2 groups each
        result += (n - map.size()) * 2;

        // Process rows with reservations
        for (Set<Integer> reserved : map.values()) {

            boolean left = !(reserved.contains(2) || reserved.contains(3) ||
                    reserved.contains(4) || reserved.contains(5));

            boolean middle = !(reserved.contains(4) || reserved.contains(5) ||
                    reserved.contains(6) || reserved.contains(7));

            boolean right = !(reserved.contains(6) || reserved.contains(7) ||
                    reserved.contains(8) || reserved.contains(9));

            if (left && right) {
                result += 2;
            } else if (left || middle || right) {
                result += 1;
            }
        }

        return result;
    }
}