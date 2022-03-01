class Solution {
    
    public String bit(int n){
        
        StringBuilder b = new StringBuilder();
        
        while(n != 0){
            
            int temp = n % 2;
            b.append(temp);
            n = n / 2;
        }
        
        return b.reverse().toString();
    }
    
    public int[] countBits(int n) {
        
        String[] array = new String[n+1];
        int[] answer = new int[array.length];
        
        for(int i=0; i<=n; i++){
            array[i] = bit(i);
        }
        
        
        for(int i=0; i<array.length; i++){
            
            int count = 0;
            for(int j=0; j<array[i].length(); j++){
                
                if(array[i].charAt(j) == '1'){
                    count++;
                }  
            }
            
            answer[i] = count;
            
        }
                
        return answer;
    }
}