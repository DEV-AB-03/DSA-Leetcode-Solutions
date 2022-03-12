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
    public ListNode reverseList(ListNode head) 
    {
        ListNode temp=head;
        if(head==null)
        {
            return head;
        }
        Stack<ListNode>st=new Stack<>();
        while(temp.next!=null)
        {
            st.push(temp);
            temp=temp.next;
        }
        head=temp;
        while(!st.empty())
        {
            ListNode node=st.peek();
            temp.next=node;
            st.pop();
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
}