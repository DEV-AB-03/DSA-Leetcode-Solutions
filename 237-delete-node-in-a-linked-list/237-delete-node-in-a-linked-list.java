/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution 
{
    public void deleteNode(ListNode node) 
    {
        //COPY THE NEXT NODES VALUE TO THE CURRENT NODE AND DELETE THE NEXT NODE AS IT IS DUPLICATE BY POINTING CURRENT NODE NEXT TO NEXT NEXT NODE
        node.val=node.next.val;
        node.next=node.next.next;
    }
}