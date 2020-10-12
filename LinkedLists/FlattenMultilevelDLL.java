/*430. Flatten a Multilevel Doubly Linked List - Leetcode Stack Java Solution*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class FlattenMultilevelDLL 
{
    public Node flatten(Node head)
    {
        Node curr=head;
        Node tail=head;
        Stack<Node> st=new Stack<Node>();
        
        while(curr!=null)
        {
            if(curr.child!=null)
            {
                Node child=curr.child;
                if(curr.next!=null)
                {
                    st.push(curr.next);
                    curr.next.prev=null;
                }
                
                curr.next=child;
                child.prev=curr;
                curr.child=null;
            }
            
            tail=curr;
            curr=curr.next;
        }
        
        while(!st.isEmpty())
        {
            curr=st.pop();
            tail.next=curr;
            curr.prev=tail;
            
            while(curr!=null)
            {
                tail=curr;
                curr=curr.next;
            }
        }
        
        return head;
    }
}
