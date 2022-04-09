// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    
    public static Node reverse(Node head){
        Node current = head, prev = null, next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public static Node addOne(Node head) 
    { 
        //code here.
        Node new_head = reverse(head);
        Node current = new_head, current1 = new_head, prev = null;
        int carry = 0;
        
        while(current != null){
            int sum = 0;
            if(prev == null){
                sum = current.data + 1;
            }else{
                sum = current.data + carry;
            }
            carry = sum/10;
            current.data = sum%10;
            prev = current;
            current = current.next;
            
        }
        if(carry == 1){
            Node new_node = new Node(1);
            prev.next = new_node;
        }
        return reverse(current1);
        
        
    }
}
