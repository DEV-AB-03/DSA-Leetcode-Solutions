// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;
import java.io.*;

    class Node
    {
        int data;
        Node left,right;
        Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
    }
		
public class GFG2
{
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void inorder(Node root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
     /* Drier program to test above functions */
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    GFG g = new GFG();
			
			    ArrayList<Integer> res = g.zigZagTraversal(root) ;
			    for (int i = 0; i < res.size (); i++)
			        System.out.print (res.get (i) + " ");
			    System. out. println();  
    			
                t--;
            
        }
	}
}// } Driver Code Ends


//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
class Pair
{
    Node node;
    int level;
    Pair(Node node,int level)
    {
        this.node=node;
        this.level=level;
    }
}
class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer>answer=new ArrayList<>();
	    if(root==null)
	    {
	        return answer;
	    }
	    Queue<Pair>q=new LinkedList<>();
	    TreeMap<Integer,List<Integer>>map=new TreeMap<>();
	    q.offer(new Pair(root,0));
	    while(!q.isEmpty())
	    {
	        Pair curr=q.poll();
	        if(map.containsKey(curr.level))
	        {
	            List<Integer>ls=map.get(curr.level);
	            ls.add(curr.node.data);
	            map.put(curr.level,ls);
	        }
	        else
	        {
	            List<Integer>ls=new ArrayList<>();
	            ls.add(curr.node.data);
	            map.put(curr.level,ls);
	        }
	        if(curr.node.left!=null)
	        {
	            q.offer(new Pair(curr.node.left,curr.level+1));
	        }
	        if(curr.node.right!=null)
	        {
	            q.offer(new Pair(curr.node.right,curr.level+1));
	        }
	    }
	    for(int i:map.keySet())
	    {
	        if(i%2!=0)
	        {
	            Collections.reverse(map.get(i));
	        }
	        answer.addAll(map.get(i));
	    }
	    return answer;
	}
}