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
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public int getDecimalValue(ListNode head) 
    {
        //Reverse the LL and find decimal value
        ListNode temp=reverse(head);
        int decimal=0;
        int p=0;
        while(temp!=null)
        {
            decimal+=(int)(temp.val * Math.pow(2,p));
            p++;
            temp=temp.next;
        }
        return decimal;
    }
}