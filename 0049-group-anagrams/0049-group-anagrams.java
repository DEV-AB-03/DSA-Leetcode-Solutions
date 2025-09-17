class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Sorting Approach
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            // Convert to char array
            char[] chars = str.toCharArray();
            // Sort the char array
            Arrays.sort(chars);
            // Convert back to string
            String sortedStr = new String(chars);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<String>());
            }
            map.get(sortedStr).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}