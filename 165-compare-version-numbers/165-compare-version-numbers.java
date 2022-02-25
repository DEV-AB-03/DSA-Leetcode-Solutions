class Solution 
{
    public int compareVersion(String version1, String version2) 
    {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int index = 0;    
        while (index < Math.max(nums1.length, nums2.length)) 
        {
            int digit1 = index < nums1.length ? Integer.parseInt(nums1[index]) : 0;
            int digit2 = index < nums2.length ? Integer.parseInt(nums2[index]) : 0;
            if (digit1 > digit2) 
            {
                return 1;
            }
            if (digit2 > digit1) 
            {
                return -1;
            }
            index++;
        }
        return 0;
    }
}