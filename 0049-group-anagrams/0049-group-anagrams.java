class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Hashing Solution
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if (map.containsKey(sorted)) {
                List<String> group = map.get(sorted);
                group.add(s);
                map.put(sorted, group);
            } else {
                List<String> group = new ArrayList<>();
                group.add(s);
                map.put(sorted, group);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> groups : map.values()) {
            ans.add(groups);
        }
        return ans;
    }
}