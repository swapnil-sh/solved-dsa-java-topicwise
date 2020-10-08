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
