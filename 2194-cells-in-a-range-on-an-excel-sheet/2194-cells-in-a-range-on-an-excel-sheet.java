class Solution {
    public List<String> cellsInRange(String s) {
        int start_row = Integer.parseInt(String.valueOf(s.charAt(1)));
        int end_row = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
        
        List<String> l = new ArrayList<>();
        
        int from  = (int)s.charAt(0);
        int to = (int)s.charAt(3);
        
        for(int i=from; i<=to; i++){
            char c = (char) i;
            for(int j=start_row; j<=end_row; j++){
                String str = c+""+j;
                l.add(str);
            }
        }
        
        return l;
    }
}