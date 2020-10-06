/*Swap Nodes in Pairs Leetcode Recursive Java Solution*/

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
class SwapPairsLL 
{
    public ListNode swapPairs(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        
        ListNode rem=head.next.next;
        ListNode newHead=head.next;
        newHead.next=head;
        
        head.next=swapPairs(rem);
        
        return newHead;
    }
}
