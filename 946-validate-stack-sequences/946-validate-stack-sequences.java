class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int m = popped.length;
        
        //initializing a stack for our operations
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        
        while(i < n){
            //we start by pushing an element
            stack.push(pushed[i++]);
            
            //and then we delete as long as stack.peek matches with popped
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        
        return stack.isEmpty();
    }
}