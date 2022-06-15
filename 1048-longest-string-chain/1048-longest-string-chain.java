class Solution {
    public int longestStrChain(String[] words) {
        
        //add into a HashMap<wordLength, words>
        HashMap<Integer, List<String> > map= new HashMap<>();
        for(int i=0; i<words.length; i++){
            String word= words[i];
            List<String> list= null;
            if(map.containsKey(word.length())){
                list= map.get(word.length());
            }else{
                list= new ArrayList<>();
            }
            list.add(word);
            map.put(word.length(),list);
        }
        
        //iterate across hashMap over all possible word lengths
        int maxChainLength=1;
        for(Integer wordLength: map.keySet()){
            
            List<String> list= map.get(wordLength);
            for(int i=0; i<list.size(); i++){
                
                HashMap<String,Integer> dp= new HashMap<>();
                int chainLength= longestStrChain(wordLength, list.get(i), dp, map);
                maxChainLength= Math.max(chainLength, maxChainLength);
            }
            
        }
        return maxChainLength;
    }
    
    private int longestStrChain(int wordLength,String str,HashMap<String,Integer> dp, HashMap<Integer, List<String> > map){
        
        
        if(dp.containsKey(str))
            return dp.get(str);
        
        int maxChainLength=0;
        if(map.containsKey(wordLength+1)){
            List<String> list= map.get(wordLength+1);
            for(int i=0; i<list.size(); i++){
                
                if(validStr(str,list.get(i))){
                    int chainLength=longestStrChain(wordLength+1,list.get(i),dp,map);
                    maxChainLength= Math.max(chainLength, maxChainLength);
                }
            }
            
            dp.put(str,1+maxChainLength);
        }else{
            return 1;
        }
        
        return dp.get(str);
        
    }
    
    private boolean validStr(String str, String bigString){
        
        int i=0, j=0, cnt=0;
        while(i<bigString.length()){
            if(j<str.length() && str.charAt(j)!= bigString.charAt(i)){
                i++;
                cnt++;
                if(cnt>1) return false;
                
            }else{
                i++;
                j++;
            }
        }
        return true;
    }
    
   
}