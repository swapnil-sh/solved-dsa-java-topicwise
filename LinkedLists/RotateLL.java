/*61. Rotate List - Leetcode Java Solution*/

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
class RotateLL
{
    public ListNode rotateRight(ListNode head, int k)
    {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        ListNode slow=dummy,fast=dummy;
        
        int len=0;
        while(fast.next!=null)
        {
            len++;
            fast=fast.next;
        }
        
        for(int i=len-k%len;i>0;i--)
           slow=slow.next;
        
        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;
        
        
        return dummy.next;
        
    }
}


/*

public ListNode rotateRight(ListNode head, int k) {
    if(head == null || k == 0) {
        return head;
    }
    ListNode p = head;
    int len = 1;
    while(p.next != null) {
        p = p.next;
        len++;
    }
    p.next = head;
    k %= len;
    for(int i = 0; i < len - k; i++) {
        p = p.next;
    }
    head = p.next;
    p.next = null;
    return head;
}

*/
