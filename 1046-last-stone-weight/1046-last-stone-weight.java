class Solution 
{
    public int lastStoneWeight(int[] stones) 
    {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++)
        {
		//Add elements to the priority queue
            q.add(stones[i]);
        }
        int i = q.peek();
        int j = i;
        while(!q.isEmpty())
        {
            //Get max element
            i = q.poll();
            if(q.isEmpty())
            {
                break;
            }
            else
            {
                // get second max element
                j = q.poll();
            }
            // check if x != y
            if(i != j)
            {
                // y = y - x
                i = i-j;
                q.add(i);
            }
            else if(i == j && q.isEmpty())
            {
                return 0;
            }
        }
        return i;
    }
}