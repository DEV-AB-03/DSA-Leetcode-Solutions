class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        return countEligible(g,s);
        
    }
    private int countEligible(int[] g , int[] s){
        
        int count =0 ;
        int gLength = g.length;
        int sLength = s.length;
        int g1=0,s1=0;
        while(g1 < gLength && s1 < sLength ){
            
            if(g[g1] <= s[s1]){
                count ++ ;
                g1++;
                s1++;
            }else if (g[g1]>s[s1]){
                s1++;
            }
        }
        return count ;
    }
}