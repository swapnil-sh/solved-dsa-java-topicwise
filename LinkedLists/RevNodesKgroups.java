/*25. Reverse Nodes in k-Group - Leetcode Java Solution*/

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
class RevNodesKgroups 
{
    private ListNode reverse(ListNode pre,ListNode next)
    {
        ListNode last=pre.next;
        ListNode curr=last.next;
        
        while(curr!=next)
        {
            last.next=curr.next;
            curr.next=pre.next;
            pre.next=curr;
            curr=last.next;
        }
        
        return last;
    }
    public ListNode reverseKGroup(ListNode head, int k)
    {
        if(k<=1 || head==null || head.next==null)
                return head;
        
        ListNode dummy=new ListNode(0);
        ListNode curr=head;
        dummy.next=head;
        
        ListNode pre=dummy;
        int i=0;
        while(curr!=null)
        {
            i++;
            if(i%k==0)
            {
                pre=reverse(pre,curr.next);
                curr=pre.next;
            }
            else
                curr=curr.next;
        }
        
        return dummy.next;
    }
}
