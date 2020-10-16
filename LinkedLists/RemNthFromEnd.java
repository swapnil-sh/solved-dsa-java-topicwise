/*19. Remove Nth Node From End of List - Leetcode Java Solution*/

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
class RemNthFromEnd
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head==null)
            return null;
        
        if(head.next==null && n==1)
            return null;
        
        int len=0,pos;
        
        ListNode curr=head;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        
        pos=len-n;
        
        if(pos==0)
            return head.next;
        
        curr=head;
        for(int i=0;i<pos-1;i++)
        {
            if(curr.next==null)
            {
                return head;
            }
                
            curr=curr.next;
        }
        
        curr.next=curr.next.next;
        return head;   
    }
}
