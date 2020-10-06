/*148. Sort List - Leetcode Merge Sort Linked List Java Solution*/

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
class MergeSort
{

    public ListNode sortList(ListNode head) 
    {
        if(head == null || head.next == null) 
            return head;
        ListNode slow = head, fast = head, pre = head;
        while(fast != null && fast.next != null) 
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
        
    }
    
    public ListNode merge(ListNode p,ListNode q)
    {
        ListNode temp=new ListNode();
        ListNode res=temp;
        
        while(p!=null && q!=null)
        {
            if(p.val<q.val)
            {
                temp.next=p;
                p=p.next;
                
            }
            else
            {
                temp.next=q;
                q=q.next;
            }
            
            temp=temp.next;
        }
        
        temp.next=(p != null) ? p:q;
        return res.next;
 
    }
}
