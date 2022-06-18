class WordFilter {
  HashMap<String,Integer> map;
    public WordFilter(String[] words) {
        map=new HashMap<>();
        for(int idx=0;idx<words.length;idx++){
            for(int i=0;i<words[idx].length();i++){
                String pre=words[idx].substring(0,i+1);
                for(int j=words[idx].length()-1;j>=0;j--){
                    String suf=words[idx].substring(j);
                    String s=pre+"#"+suf;
                    map.put(s,idx);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        String s=prefix+"#"+suffix;
        return map.getOrDefault(s,-1);
    }
}