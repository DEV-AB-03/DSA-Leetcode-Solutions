class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if(s == null) return 0;
        for(int i = 0; i < s.length(); i++){
            isSubstring(s, i, i);
            isSubstring(s, i, i + 1);
        }
        return count;
    }
    public void isSubstring(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
    }
}