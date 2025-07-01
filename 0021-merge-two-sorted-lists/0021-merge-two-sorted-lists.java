class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode x = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                x.next = l1;
                l1 = l1.next;
            } else {
                x.next = l2;
                l2 = l2.next;
            }
            x = x.next;
        }

        if (l1 != null)
            x.next = l1;

        else
            x.next = l2;

        return head.next;
    }
}