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
class Solution {
    public ListNode middleNode(ListNode head) {
        // Hare-Tortoise Algorithm
        ListNode hare = head;
        ListNode tortoise = head;

        while (hare != null && tortoise != null && hare.next!=null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return tortoise;
    }
}