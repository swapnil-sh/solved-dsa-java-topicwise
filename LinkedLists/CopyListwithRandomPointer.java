/*138. Copy List with Random Pointer - Leetcode Java multiple Solutions*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class CopyListwithRandomPointer 
{
    public Node copyRandomList(Node head)
    {
        Node curr=head;
        
        Map<Node,Node> hm=new HashMap<>();
        
        while(curr!=null)
        {
            hm.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        
        curr=head;
        while(curr!=null)
        {
            hm.get(curr).next=hm.get(curr.next);
            hm.get(curr).random=hm.get(curr.random);
            curr=curr.next;
        }
        
        return hm.get(head);
    }
}
