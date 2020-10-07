/*83. Remove Duplicates from Sorted List - Leetcode Java Iterative Solution*/

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
class RemDupSorList
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        
        ListNode p=head;
        ListNode q;
        int flag;
        
        while(p!=null && p.next!=null)
        {
            q=p.next;
            flag=0;
            while(q!=null && p.val==q.val)
            {
                q=q.next;
                flag=1;
            }
            if(flag==1 && q!=null)
                p.next=q;
            
            if(q==null)
            {
                p.next=null;
                break;
            }
            p=p.next;
            
        }
        
        return head;
    }
}
