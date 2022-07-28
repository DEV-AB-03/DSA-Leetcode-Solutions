class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
        HashMap<Character,Integer> map2=new HashMap<Character,Integer>();
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++)
        {
            char ch1=s.charAt(i);
            if(!map1.containsKey(ch1))
                map1.put(ch1,1);
            else
                map1.put(ch1,map1.get(ch1)+1);   
             
        }
        for(int i=0;i<t.length();i++)
        {
            char ch2=t.charAt(i);
            if(map1.containsKey(ch2))
            {
                 int val=map1.get(ch2);
                map1.put(ch2,val-1);
            }
            else
                return false;
             
        }
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(map1.get(ch)!=0)
                return false;
        }
        return true;
    }
    
}
