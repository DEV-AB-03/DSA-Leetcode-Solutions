// Added using AI
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] mpl = new int[26];
        int[] mpu = new int[26];
        java.util.Arrays.fill(mpl, -1);
        java.util.Arrays.fill(mpu, -1);
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char a = word.charAt(i);
            if (Character.isLowerCase(a)) {
                mpl[a - 'a'] = i;
            } else {
                int idx = a - 'A';
                if (mpu[idx] == -1)
                    mpu[idx] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (mpl[i] != -1 && mpu[i] != -1 && mpl[i] < mpu[i])
                ans++;
        }
        return ans;
    }
}