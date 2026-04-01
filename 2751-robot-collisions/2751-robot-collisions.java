class Solution {
    class Robot {
        int pos;
        char dir;
        int health;
        int orig_i;

        Robot(int pos, char dir, int health, int orig_i) {
            this.pos = pos;
            this.dir = dir;
            this.health = health;
            this.orig_i = orig_i;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(
                    positions[i],
                    directions.charAt(i),
                    healths[i],
                    i);
        }
        Arrays.sort(robots, (a, b) -> Integer.compare(a.pos, b.pos));
        Stack<Robot> stack = new Stack<>();
        for (Robot curr : robots) {
            while (!stack.isEmpty() && curr.dir == 'L' && stack.peek().dir == 'R') {
                Robot top = stack.peek();
                if (top.health > curr.health) {
                    top.health -= 1;
                    curr.health = 0;
                    break;
                } else if (top.health < curr.health) {
                    stack.pop();
                    curr.health -= 1;
                } else {
                    stack.pop();
                    curr.health = 0;
                    break;
                }
            }
            if (curr.health > 0) {
                stack.push(curr);
            }
        }
        stack.sort((a, b) -> Integer.compare(a.orig_i, b.orig_i));
        List<Integer> res = new ArrayList<>();
        for (Robot r : stack) {
            res.add(r.health);
        }
        return res;
    }
}