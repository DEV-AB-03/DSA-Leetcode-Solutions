class Solution 
{
   public long minimumTime(int[] time, int totalTrips) 
   {
        Arrays.sort(time);
        int n = time.length;
    	long res = 0; 
       long small = time[0];
       long big = (long)totalTrips * time[n - 1];
    	while (small <= big) 
        {
    		long mid = (big - small) / 2 + small, sum = 0;
    		for (int i = 0; i < n && sum <= totalTrips; i++)
            {
    			sum += mid / time[i];
            }
    		if(sum >= totalTrips) 
            {
    			res = mid;
    			big = mid - 1;
    		}
            else
            {
    			small = mid + 1;
            }
    	}
        return res;
    }
}