class Solution {
    public int numSub(String s) {
        // Counting sub strings on the basis of indices
        long count=0;

        int MODULO = 1000000007;

        // Count length of max consecutive 1's then apply formula to calculate number of substrings
        long length=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                length++;
            }
            else
            {
                // We got a zero so consecutive 1's end.
                count+=(length * (length + 1)/2) % MODULO ;
                
                // reset length
                length=0;
            }
        }
        // If all 1's check
        count+=(length * (length + 1)/2)% MODULO;
        return (int)count % MODULO;
    }
}