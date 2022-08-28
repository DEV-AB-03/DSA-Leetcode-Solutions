class Solution {
    public boolean isPerfectSquare(int num) {
        int low=0,high=num/2;
        long mid=0;
        
        if(num==1 || num==0) {
            return true;
        }
        
        while(low<=high) {
            mid=low+(high-low)/2;
            if(mid*mid==num) {
                return true;
            }
            else if(num>mid*mid) {
                low=(int)mid+1;
            }
            else {
                high=(int)mid-1;
            }
            
            
        }
        return false;
    }
}