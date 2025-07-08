class Solution 
{
    public void countseq(int index,int target,int[]a, List<List<Integer>> answer,List<Integer>ds)
    {
        //Base Case
        if(index==a.length)
        {
            if(target==0)
            {
                answer.add(new ArrayList<>(ds));
            }
            return;
        }
        
        //Take Condition
        if(a[index]<=target)
        {
            ds.add(a[index]);
            countseq(index,target-a[index],a,answer,ds);
            ds.remove(ds.size()-1);  //BackTracking Here
        }
        
        //Not Take Condition
        countseq(index+1,target,a,answer,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        //Coin Change Problem
        List<List<Integer>> answer=new ArrayList<>();
        countseq(0,target,candidates,answer,new ArrayList<>());
        return answer;
    }
}