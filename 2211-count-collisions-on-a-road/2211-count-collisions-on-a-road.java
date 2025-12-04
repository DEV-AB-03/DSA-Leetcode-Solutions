class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int collisions = 0;

        for (char c : directions.toCharArray()) {

            if (c == 'R') {
                // Just push, no collision yet
                stack.push('R');
            } else if (c == 'S') {
                // All previous R become S with +1 collision each
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    collisions += 1;
                    stack.pop();
                }
                stack.push('S');
            } else { // c == 'L'
                     // Case: R ... meets L
                if (!stack.isEmpty() && stack.peek() == 'R') {
                    // First collision R-L → +2
                    collisions += 2;
                    stack.pop();

                    // Convert this L to S
                    // Now clear remaining R’s
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        collisions += 1;
                        stack.pop();
                    }

                    stack.push('S'); // finally push stationary
                } else if (!stack.isEmpty() && stack.peek() == 'S') {
                    // S-L → +1
                    collisions += 1;
                    stack.push('S');
                } else {
                    // Leading L → nothing happens
                    stack.push('L');
                }
            }
        }

        return collisions;
    }
}
