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
        // Min Heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while (!pq.isEmpty()) {
            ListNode pop = pq.poll();
            dummy.next = pop;
            dummy = dummy.next;
            if (pop.next != null) {
                pq.offer(pop.next);
            }
        }
        return head.next;
    }
}