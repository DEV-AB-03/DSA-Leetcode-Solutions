class Solution 
{
    public String reverse(String s)
    {
        String rev="";
        for(int i=s.length()-1;i>=0;i--)
        {
            rev+=s.charAt(i);
        }
        return rev;
    }
    public int lcs(int index1,int index2,String a,String b,int[][]dp)
    {
        //Base Case
        if(index1<0 || index2<0)
        {
            return 0;
        }
        if(dp[index1][index2]!=-1)
        {
            return dp[index1][index2];
        }
        //Recursion Calls
        //Match Condition
        if(a.charAt(index1)==b.charAt(index2))
        {
            return dp[index1][index2]=1+lcs(index1-1,index2-1,a,b,dp);
        }
        //Not Match Condition
        return dp[index1][index2]=0+Math.max(lcs(index1-1,index2,a,b,dp),lcs(index1,index2-1,a,b,dp));
    }
    public int longestPalindromeSubseq(String s) 
    {
        int l1=s.length();
        int[][]dp=new int[l1][l1];
        for(int i=0;i<l1;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return lcs(l1-1,l1-1,s,reverse(s),dp);
    }
}