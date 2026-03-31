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
    public ListNode mergeKLists(ListNode[] lists) {
        // Priority Queue -- Keep Duplicates in heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add initially heads to PQ
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        // Create dummy LL
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            // Poll smallest and then add node if it exists
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            // Add next node of smallest
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }
        return dummy.next;
    }
}