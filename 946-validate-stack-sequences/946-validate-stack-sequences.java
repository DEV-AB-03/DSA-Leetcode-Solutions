class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int n = pushed.length;
        int j = 0;
        
        for(int i = 0; i< n ;i++){
            // push each element in stack
            st.push(pushed[i]);
            // we will check that if peek element of stack matches the pop element in the popped array and if yes then we will pop until the peek element will match with popped elements
                while(!st.isEmpty() && st.peek() == popped[j] ){
                     st.pop();
                    j++;
                }
        }
        
        // now will check the remaining array and stack
        
        while(!st.isEmpty()){
            if(st.peek() != popped[j]){
                return false;
            }
            else{
                st.pop();
                j++;
            }
        }       
        return true;
    }
}