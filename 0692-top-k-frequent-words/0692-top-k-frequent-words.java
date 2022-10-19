class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list=new ArrayList<>();
        Queue<Map.Entry<String,Integer>> queue=new PriorityQueue<>((a,b)->(a.getValue()==b.getValue()
                                                                           ?(a.getKey().compareToIgnoreCase(b.getKey()))
                                                                           :b.getValue()-a.getValue()));
        Map<String,Integer> hashMap=new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            String word=words[i];
            Integer occurence=hashMap.get(word);
            if(occurence==null)
                hashMap.put(word,1);
            else 
                hashMap.put(word,occurence+1);
        }
        for(Map.Entry<String,Integer> entry:hashMap.entrySet())
        { 
            queue.add(entry);
        }
        
        while(k>0)
        {
            list.add(queue.poll().getKey());
            k--;
        }
        return list;
    }
}