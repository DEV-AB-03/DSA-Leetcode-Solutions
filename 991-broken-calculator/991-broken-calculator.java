class Solution 
{
    public int brokenCalc(int startValue, int target) 
    {
        //MOVE BACKWARD THAT IS FROM TARGET TO START VALUE
        int steps=0;
        while(target>startValue)
        {
            if(target%2==0)
            {
                target=target/2;
                steps++;
            }
            else
            {
                target=target+1;
                steps++;
            }
        }
        return steps+startValue-target;
    }
}