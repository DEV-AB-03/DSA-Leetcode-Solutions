class Solution 
{
    public List<Integer> findDuplicates(int[] nums) 
    {
        int n=nums.length;
        List<Integer>answer=new ArrayList<>();
        int[]freq=new int[n+1];
        for(int num:nums)
        {
            freq[num]++;
        }
        for(int i=0;i<n+1;i++)
        {
            if(freq[i]==2)
            {
                answer.add(i);
            }
        }
        return answer;
    }
}