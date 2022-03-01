class Solution 
{
    public List<Integer> findDuplicates(int[] nums) 
    {
        //SINCE WE HAVE NUMBERS BOUNDED BY ARRAY SIZE WE CAN TREAT THEM AS POSITIONS ALSO
        //IF WE COME BACK TO THE SAME POSTION AGAIN AND WE FIND THE NUMBER ALREADY NEGATIVE THEN WE CAN SAY NUMBERS ARE REPEATED
        int n=nums.length;
        List<Integer>answer=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int pos=Math.abs(nums[i])-1;
            if(nums[pos]<0)
            {
                answer.add(Math.abs(nums[i]));
            }
            nums[pos]=nums[pos]*(-1);
        }
        return answer;
    }
}