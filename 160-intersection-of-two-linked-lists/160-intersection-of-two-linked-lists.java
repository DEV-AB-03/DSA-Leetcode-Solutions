/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        //2 POINTER APPROACH
        int l1=0;   //LIST 1 LENGTH
        int l2=0;   // LIST2 LENGTH
        ListNode temp=headA;
        while(temp!=null)
        {
            l1++;
            temp=temp.next;
        }
        ListNode temp1=headB;
        while(temp1!=null)
        {
            l2++;
            temp1=temp1.next;
        }
        if(l1>l2)
        {
            int diff=l1-l2;
            ListNode curr1=headA;
            for(int i=0;i<diff;i++)
            {
                curr1=curr1.next;
            }
            ListNode curr2=headB;
            while(curr1!=null && curr2!=null)
            {
                if(curr1==curr2)
                {
                    return curr1;
                }
                else
                {
                    curr1=curr1.next;
                    curr2=curr2.next;
                }
            }
        }
        else
        {
            int diff=l2-l1;
            ListNode curr2=headB;
            for(int i=0;i<diff;i++)
            {
                curr2=curr2.next;
            }
            ListNode curr1=headA;
            while(curr1!=null && curr2!=null)
            {
                if(curr1==curr2)
                {
                    return curr1;
                }
                else
                {
                    curr1=curr1.next;
                    curr2=curr2.next;
                }
            }
        }
        return null;
    }
}