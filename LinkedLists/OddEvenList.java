/*328. Odd Even Linked List - Leetcode Java Solution*/

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
class OddEvenList 
{
    public ListNode oddEvenList(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode odd=head;
        ListNode eve=head.next;
        ListNode eveHead=eve;
        
        while(eve!=null && eve.next!=null)
        {
            odd.next=eve.next;
            odd=odd.next;
            eve.next=odd.next;
            eve=eve.next;
        }
            
        odd.next=eveHead;
        
        return head;
        
    }
}
