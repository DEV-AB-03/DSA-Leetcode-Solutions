class Solution {
  public int lengthOfLongestSubstring(String s) {
      boolean[] visited = new boolean[256];
      int j = 0;
      int ret = 0;
      for (int i = 0; i < s.length(); i++) {
          while (visited[s.charAt(i)]) {
              visited[s.charAt(j++)] = false;
          }
          visited[s.charAt(i)] = true;
          // [j, i] is the sliding window
          ret = Math.max(ret, i - j + 1);
      }
      return ret;
  }
}