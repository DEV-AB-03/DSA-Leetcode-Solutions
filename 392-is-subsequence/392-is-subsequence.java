class Solution 
{
    public boolean isSubsequence(String s, String t) 
    {
        //Map s to t
        //2 pointer approach
        int l1=s.length();
        int l2=t.length();
        
        //Declare Pointers
        int spointer=0;
        int tpointer=0;
        
        while(spointer<l1 && tpointer<l2)
        {
            char ch1=s.charAt(spointer);
            char ch2=t.charAt(tpointer);
            if(ch1==ch2)
            {
                spointer++;
                tpointer++;
            }
            else
            {
                tpointer++;
            }
        }
        if(spointer==l1)
        {
            return true;
        }
        return false;
    }
}