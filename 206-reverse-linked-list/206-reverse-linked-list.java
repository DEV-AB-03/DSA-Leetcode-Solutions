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
        //RECURSION SOLUTION
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode newhead=reverseList(head.next);
        ListNode headnext=head.next;
        headnext.next=head;
        head.next=null;
        return newhead;
    }
}