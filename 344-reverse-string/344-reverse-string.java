class Solution 
{
    public void swap(char[] s,int low,int high)
    {
        char ch=s[low];
        s[low]=s[high];
        s[high]=ch;
    }
    public void reverseString(char[] s) 
    {
        int n=s.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            swap(s,low,high);
            low++;
            high--;
        }
    }
}