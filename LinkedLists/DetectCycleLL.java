/*142. Linked List Cycle II - Leetcode Java Solution(Starting index of Linked List Loop)*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class DetectCycleLL 
{
    public ListNode detectCycle(ListNode head)
    {
        ListNode p=head;
        ListNode q=head;
        
        while(p!=null && q!=null && q.next!=null)
        {
            p=p.next;
            q=q.next.next;
            
            if(p==q)
                break;
        }
        
        if(q==null || q.next==null)
            return null;
        
        q=head;
        while(p!=q)
        {
            p=p.next;
            q=q.next;
        }
        
        return p;
    }
}
