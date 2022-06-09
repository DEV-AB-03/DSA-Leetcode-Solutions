class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int index=0;
        int value=values[0];
        int curr=Integer.MIN_VALUE;
        for(int i=1;i<values.length;++i){
            curr=Math.max(value+values[i]+index-i,curr);
            if(values[i]+i-index>=value){
                index=i;
                value=values[i];
            }
        }
        return curr;
    }
}