/*160. Intersection of Two Linked Lists - Leetcode Two Pointer Java Solution*/

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
public class IntersecOfLL
{
    public ListNode getIntersectionNode(ListNode f, ListNode s) 
    {
        if(f==null && s==null)
            return null;
        ListNode f_pointer=f;
        ListNode s_pointer=s;
        
        while(f_pointer!=s_pointer)
        {
            if(f_pointer==null)
                f_pointer=s;
            else
                f_pointer=f_pointer.next;
            
            if(s_pointer==null)
                s_pointer=f;
            else
                s_pointer=s_pointer.next;
        }
        
        return f_pointer;
    }
}


/*Intersection of Two Linked Lists - GeeksforGeeks HashSet Java Solution*/

/*public static Node findIntersection(Node head1, Node head2)
{
HashSet<integer> set = new HashSet<>();

while(head2!=null)
{
set.add(head2.data);
head2=head2.next;
}
Node finalHead = new Node(-1);
Node temp=finalHead;
while(head1!=null)
{
if(set.contains(head1.data))
{
temp.next = new Node(head1.data);
temp=temp.next;
}
head1=head1.next;
}
return finalHead.next;
}
*/
