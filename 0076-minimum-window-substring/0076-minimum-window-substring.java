class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int sIdx = -1;

        while (right < s.length()) {
            char chRight = s.charAt(right);
            if (map.containsKey(chRight)) {
                map.put(chRight, map.get(chRight) - 1);
                if (map.get(chRight) >= 0) { // valid match
                    count++;
                }
            }

            while (count == t.length()) { // all chars matched
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    sIdx = left;
                }

                char chLeft = s.charAt(left);
                if (map.containsKey(chLeft)) {
                    map.put(chLeft, map.get(chLeft) + 1);
                    if (map.get(chLeft) > 0) { // losing a needed char
                        count--;
                    }
                }
                left++;
            }
            right++;
        }

        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minLen);
    }
}
