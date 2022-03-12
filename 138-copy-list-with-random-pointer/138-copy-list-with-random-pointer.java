class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val);
        Node res = newHead;

        while (head != null) {
            map.put(head, newHead);
            
            if (head.next != null ) {
                Node mapNext = map.get(head.next);
                if(mapNext != null) {
                    newHead.next = mapNext;
                } else {
                    Node newNext = new Node(head.next.val);
                    newHead.next = newNext;
                    map.put(head.next, newNext);
                }
            }
            
            if (head.random != null) {
                Node mapRandom = map.get(head.random);
                if(mapRandom != null) {
                    newHead.random = mapRandom;
                } else {
                    Node newRandom = new Node(head.random.val);
                    newHead.random = newRandom;
                    map.put(head.random, newRandom);
                }
                                
            }
            
            head = head.next;
            newHead = newHead.next;
        }
        
        return res;
    }
}