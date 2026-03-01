class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int idx = curr - 'a';

            int lastIndex = lastPos[idx];

            // Check distance in current string
            if (lastIndex != -1 && sb.length() - lastIndex <= k) {
                // merge -> skip current character
                continue;
            }

            // otherwise append
            lastPos[idx] = sb.length();
            sb.append(curr);
        }

        return sb.toString();
    }
}