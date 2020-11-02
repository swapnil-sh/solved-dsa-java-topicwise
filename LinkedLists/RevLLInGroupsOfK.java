/* Reverse a Linked List in groups of given size - GeeksforGeeks Java Solutions*/


//--------------Recursive Approach--------------------

/*

    Time Complexity: O(n).
    Traversal of list is done only once and it has ‘n’ elements.
    Auxiliary Space: O(n/k).
    For each Linked List of size n, n/k or (n/k)+1 calls will be made during the recursion.

*/

class RevLLInGroupsOfK
{
    
    public static Node reverse(Node head, int k)
    {
        //Your code here
        Node prev=null;
        Node curr=head;
        Node next=null;
        
        int c=0;
        while(c<k && curr!=null)
        {
            c++;
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        if(next!=null)
            head.next = reverse(next,k);
            
        return prev;
    }
}


//------------------------------Iterative Approach---------------------------------

/*
class GfG
{
    public static Node reverse(Node head, int k)
    {
        //Your code here
        Node prev=null;
        Node curr=head;
        Node next;
        Node newHead=null;
        Node tail=null;
        Node join=null;
        int c=0;
        
        while(curr!=null)
        {
            c=0;
            join=curr;
            prev=null;
            while(c<k && curr!=null)
            {
                c++;
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            
            if(newHead==null)
                newHead=prev;
            
            if(tail!=null)
                tail.next=prev;
            
            tail=join;
        }
  
            
        return newHead;
    }
}
*/


//-------------------------Iteraitve approach using Stack----------------------------------------
/*
class GfG
{
    public static Node reverse(Node head, int k)
    {
        //Your code here
        Stack<Node> st=new Stack<Node>();  
        Node curr=head;  
        Node prev=null;
        
        int c=0;
        while(curr!=null)
        {
            c=0;
            while(c<k && curr!=null)
            {
                st.push(curr);
                curr=curr.next;
                c++;
            }
            
            while(!st.isEmpty())
            {
                if(prev==null)
                {
                    prev=st.pop();
                    head=prev;
                }
                else
                {
                    prev.next=st.pop();
                    prev=prev.next;

                }
            }
            
        }
        
        prev.next=null;
        return head;
    }
}

*/
