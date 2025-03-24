class Solution 
{
    public int maxProduct(int[] nums) 
    {
        int n=nums.length;
        int max_product1=Integer.MIN_VALUE;
        int product_so_far=1;
        int max_product2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            product_so_far*=nums[i];
            if(product_so_far>max_product1)
            {
                max_product1=product_so_far;
            }
            if(product_so_far==0)
            {
                product_so_far=1;
            }
        }
        int product_so_far1=1;
        for(int i=n-1;i>=0;i--)
        {
            product_so_far1*=nums[i];
            if(product_so_far1>max_product2)
            {
                max_product2=product_so_far1;
            }
            if(product_so_far1==0)
            {
                product_so_far1=1;
            }
        }
        return Math.max(max_product1,max_product2);
    }
}