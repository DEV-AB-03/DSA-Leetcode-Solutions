class Solution 
{
    public boolean isPalindrome(int x) 
    {
        int y = x;
        int sum = 0, r;
        while(x > 0) 
        {
            r = x % 10;
            sum = sum*10 + r;
            x = x/10;
        }
        if(sum == y) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}