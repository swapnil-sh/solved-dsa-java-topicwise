/*234. Palindrome Linked List - Leetcode Two Pointer Reverse Java O(1) Space Solution (Can also be solved using stack O(N/2) Space) */

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
class CheckPalinLL
{
    public boolean isPalindrome(ListNode head)
    {
        if(head==null || head.next==null)
            return true;
        
        ListNode slow=head;
        ListNode fast=head;
        
        ListNode pre=null;
        ListNode nx = null;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            
            nx=slow.next;
            slow.next=pre;
            pre=slow;
            slow=nx;
        }
        
        if(fast!=null)
        {
            slow=slow.next;
        }
        
        while(pre!=null && slow!=null)
        {
            if(pre.val != slow.val)
                 return false;
            
            pre = pre.next;
            slow = slow.next;
        }
        
        return true;
  
    }
}
