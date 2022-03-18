class Solution {
    public String removeDuplicateLetters(String s) {
      int[] lastIndex=new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        boolean[] seen=new boolean[26];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            if(seen[c]) continue;
            
            while(!st.isEmpty() && st.peek()>c && i<lastIndex[st.peek()])
            seen[st.pop()]=false;
            
            st.push(c);
            seen[c]=true;
        }
        
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            
            res.append((char) (st.pop()+'a'));
        }
       return res.reverse().toString();  
    }
}