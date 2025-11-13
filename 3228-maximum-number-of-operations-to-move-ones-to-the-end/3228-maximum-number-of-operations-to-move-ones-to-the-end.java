class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int count = 0;          // Number of '1's seen so far
        int operations = 0;     // Total number of operations
        int i = 0;

        while(i < n){
            if(s.charAt(i) == '0'){
                // All previous '1's can move past this block of '0's
                operations += count;

                // Skip all consecutive '0's
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
            } else {
                // Count '1's for future operations
                count++;
                i++;
            }
        }

        return operations;
    }
}