class Pair {
    char ch;
    int freq;

    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (st.isEmpty() || st.peek().ch != curr) {
                st.push(new Pair(curr, 1));
            } else {
                st.peek().freq++;

                if (st.peek().freq == k) {
                    st.pop(); // remove k duplicates
                }
            }
        }

        // Build result string
        StringBuilder sb = new StringBuilder();

        for (Pair p : st) {
            for (int i = 0; i < p.freq; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }
}