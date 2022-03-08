class Solution 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        //MERGE SORT IMPLEMENTATION
        //WE WILL START FROM LAST INDEX
        int index=nums1.length-1;
        while(m>0 && n>0)
        {
            if(nums1[m-1]>nums2[n-1])
            {
                nums1[index]=nums1[m-1];
                index--;
                m--;
            }
            else
            {
                nums1[index]=nums2[n-1];
                index--;
                n--;
            }
        }
        //ALL REMAINING ELEMENTS OF NUMS1
        while(m>0)
        {
            nums1[index]=nums1[m-1];
            index--;
            m--;
        }
        while(n>0)
        {
            nums1[index]=nums2[n-1];
            index--;
            n--;
        }
    }
}