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



/*
----------------------Using Reverse Function------------------------s
*/

/*
class Solution
{
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        head=prev;
        
        return head;
    }
    public boolean isPalindrome(ListNode head) 
    {
        
        if(head==null || head.next==null)
            return true;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow.next=reverse(slow.next);
        
        slow=slow.next;
        
        while(slow!=null)
        {
            if(head.val!=slow.val)
                return false;
            head=head.next;
            slow=slow.next;
        }
        
        return true;
        
    }
}
*/
