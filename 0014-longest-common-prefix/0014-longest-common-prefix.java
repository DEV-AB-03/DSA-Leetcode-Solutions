class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        int n=strs.length;
        int shortest=Integer.MAX_VALUE;
        for(String s:strs)
        {
            shortest=Math.min(s.length(),shortest);
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<shortest;i++)
        {
            char p=strs[0].charAt(i);
            for(int j=1;j<n;j++)
            {
                if(p!=strs[j].charAt(i))
                {
                    return ans.toString();
                }
            }
            ans.append(p);
        }
        return ans.toString();
    }
}