class Solution 
{
    public void decrementinMap(Map<Integer,Integer>map,int key)
    {
        if(map.get(key)==1)
        {
            map.remove(key);
        }
        else
        {
            map.put(key,map.get(key)-1);
        }
    }
    public int[] findOriginalArray(int[] changed) 
    {
        if(changed.length%2!=0)
        {
            return new int[]{};
        }
        //Hashing Approach
        //So the idea is that if we find a pair such that element and its double exist in the aray then we remove it.
        
        //We keep on doing so such that there exists no element in the array
        //Then we return the array is such case is achieved
        //Else even if one element exists in the array then we return empty array as it doesnt match the conditions
        
        //So first we sort the array so that we can get the smallest elements first
        //Smallest elements are the ones whose halves wont exist in array as they are the first ones in array
        
        //Now sort the array
        Arrays.sort(changed);
        HashMap<Integer,Integer>map=new HashMap<>();
        int[]originalArray=new int[changed.length/2];
        int idx=0;
        //Now iterate over the array to satisfy the conditions
        for(int ele:changed)
        {
            if(ele%2==0 && map.containsKey(ele/2))
            {
                decrementinMap(map,ele/2);
                originalArray[idx]=ele/2;
                idx++;
            }
            else if(map.containsKey(2*ele))
            {
                decrementinMap(map,2*ele);
                originalArray[idx]=ele;
                idx++;
            }
            else
            {
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
        }
        if(idx==originalArray.length)
        {
            return originalArray;
        }
        return new int[]{};
        
    }
}