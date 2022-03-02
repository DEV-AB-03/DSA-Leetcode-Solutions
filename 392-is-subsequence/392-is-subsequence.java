class Solution 
{
    public boolean isSubsequence(String s, String t) 
    {
        //2 POINTER APPROACH
        int l1=s.length();
        int l2=t.length();
        int j=0;
        int i=0;
        while(i<l2 && j<l1)
        {
            if(s.charAt(j)==t.charAt(i))
            {
                j++;
                i++;
            }
            else
            {
                i++;
            }
        }
        if(j==l1)
        {
            return true;
        }
        return false;
    }
}