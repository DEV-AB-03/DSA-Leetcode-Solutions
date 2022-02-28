class Solution 
{
    public List<Integer> findDuplicates(int[] nums) 
    {
        int n=nums.length;
        List<Integer>answer=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                answer.add(nums[i]);
            }
        }
        return answer;
    }
}