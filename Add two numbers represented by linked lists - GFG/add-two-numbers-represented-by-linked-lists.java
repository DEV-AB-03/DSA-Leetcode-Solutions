// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
   //Function to add two numbers represented by linked list.
   static Node addTwoLists(Node first, Node second){
       // code here
       // return head of sum list
       int data,carry=0;
       Node rev_first = reverseList(first);
       Node rev_last = reverseList(second);
       data = (rev_first.data + rev_last.data + carry)%10;
       carry = (rev_first.data + rev_last.data + carry)/10;
       Node head = new Node(data);
       Node tail = head;
       
       
       while(rev_first.next!=null && rev_last.next!=null){ 
           data = (rev_first.next.data + rev_last.next.data + carry)%10;
           Node temp = new Node(data);
           tail.next = temp;
           tail=temp;
           carry = (rev_first.next.data + rev_last.next.data + carry)/10;
           
           rev_first=rev_first.next;
           rev_last=rev_last.next;
       }
       while(rev_first.next!=null){
           data = (rev_first.next.data + carry)%10;
           Node temp = new Node(data);
           carry = (rev_first.next.data+carry)/10;
           tail.next = temp;
           tail=temp;
           rev_first=rev_first.next;
       }
       while(rev_last.next!=null){
           data = (rev_last.next.data + carry)%10;
           Node temp = new Node(data);
           carry = (rev_last.next.data+carry)/10;
           tail.next = temp;
           tail=temp;
           rev_last=rev_last.next;
       }
       if(carry>0){
           Node temp = new Node(carry);
           tail.next=temp;
           tail=temp;
       }
       return reverseList(head);
   }
   
   static Node reverseList(Node head){
       Node prev=null,curr=head,temp;
       while(curr!=null){
           temp=prev;
           prev=curr;
           curr=curr.next;
           prev.next=temp;
       }
       return prev;
       
   }
}