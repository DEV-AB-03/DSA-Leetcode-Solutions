class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        //MIN HEAP IMPLEMENTATION
        int n=nums.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<k;i++)
        {
            pq.add(nums[i]);
        }
        for(int i=k;i<n;i++)
        {
            if(pq.peek()<nums[i])
            {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}