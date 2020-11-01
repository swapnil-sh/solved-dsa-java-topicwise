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
