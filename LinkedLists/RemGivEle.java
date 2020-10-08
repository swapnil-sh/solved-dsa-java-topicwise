/*203. Remove Linked List Elements - Leetcode Two PointerJava Solution */

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
class RemGivEle
{
    public ListNode removeElements(ListNode head, int val) 
    {
        if(head==null)
            return null;
        
        if(head.next==null && head.val==val)
            return null;
        while(head!=null && head.val==val)
        {
            head=head.next;
        }
      
        ListNode prev=null;
        ListNode curr=head;
       
        while(curr!=null)
        {  
            while(curr!=null && curr.val==val)
            {
                prev.next=curr.next;
                curr=curr.next;  
            }
            
            prev=curr;
            if(curr==null)
                break;
            curr=curr.next;
        }
        
        return head;
    }
}



/*203. Remove Linked List Elements - Leetcode Recursive Java Solution */


/*
public ListNode removeElements(ListNode head, int val) {
    if(head == null) return null;
    ListNode next = removeElements(head.next, val);
    if(head.val == val) return next;
    head.next = next;
    return head;
}
*/
