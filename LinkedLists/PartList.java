/*86. Partition List - Leetcode Java Two Pointer Solution*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class PartList 
{
    public ListNode partition(ListNode head, int x)
    {
        
        ListNode t=head;
        
        ListNode less=new ListNode(0);
        ListNode p=less;
        
        ListNode grt=new ListNode(0);
        ListNode q=grt;
        
        while(t!=null)
        {
            if(t.val<x)
            {
                
                p.next=t;
                p=p.next;
                
            }
            else
            {
                q.next=t;
                q=q.next;
                
            }
            t=t.next;
        }

        q.next=null;
        p.next=grt.next;
        
        return less.next;
        
    }
}
