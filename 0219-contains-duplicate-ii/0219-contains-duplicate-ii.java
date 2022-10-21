class Solution 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        //Hashing Approach
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int idx=map.get(nums[i]);
                if(Math.abs(idx-i)<=k)
                {
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}