class Solution {
    public int finalValueAfterOperations(String[] operations) {
     
        int sum=0;
        for(int i=0;i<operations.length;i++)
        {
            if(operations[i].contains("+"))
            {
                sum=sum+1;
            }
            else
            {
                sum=sum-1;
            }
        }
        return sum;
    }
}