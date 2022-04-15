/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {
        //STACK
        ListNode curr=head;
        Stack<Integer>st=new Stack<>();
        while(curr!=null)
        {
            st.push(curr.val);
            curr=curr.next;
        }
        ListNode chkr=head;
        while(chkr!=null)
        {
            if(chkr.val!=st.peek())
            {
                return false;
            }
            st.pop();
            chkr=chkr.next;
        }
        return true;
    }
}