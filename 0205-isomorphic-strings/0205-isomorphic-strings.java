class Solution {
    public boolean isIsomorphic(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if (l1 != l2) {
            return false;
        }
        //Hashing Approach
        //Character indices should match always as we are replacing them
        //If we are getting a new character in both string then it is valid else not
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (!map1.containsKey(ch1)) {
                map1.put(ch1, i);
            }
            if (!map2.containsKey(ch2)) {
                map2.put(ch2, i);
            }
            int val1 = map1.get(ch1);
            int val2 = map2.get(ch2);
            if (val1 != val2) {
                return false;
            }
        }
        return true;
    }
}