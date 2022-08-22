class Solution {
    public int minSetSize(int[] arr) {
    
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        int n = arr.length;
        
        for(int a : arr){
            map.put(a, map.getOrDefault(a,0) + 1);
        }
        
        for(int v : map.values()){
            l.add(v);
        }
        
        Collections.sort(l);
        
        int len = l.size() - 1;
        int sum = 0;
        int count = 0;
        
        while(sum < n/2){
            sum += l.get(len--);
            count++;
        }
        
        return count;
        
    }
}
