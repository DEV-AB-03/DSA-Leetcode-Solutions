class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>>answer=new ArrayList<>();
        ArrayList<Integer>row,pre=null;
        for(int i=0;i<numRows;i++)
        {
            row=new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                {
                    row.add(1);
                }
                else
                {
                    row.add(pre.get(j)+pre.get(j-1));
                }
            }
            pre=row;
            answer.add(row);
        }
        return answer;
    }
}