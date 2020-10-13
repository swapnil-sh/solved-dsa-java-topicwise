/*147. Insertion Sort List - Leetcode Java Solution*/

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

class InsertionSortLL 
{
    public ListNode insertionSortList(ListNode head)
    {
        ListNode sorted=new ListNode();
        ListNode curr=head;
        ListNode prev;
        ListNode next;
        
        while(curr!=null)
        {
            prev=sorted;
            next=sorted.next;
            
            while(next!=null)
            { 
                if(curr.val<next.val)
                    break;
                
                prev=next;
                next=next.next;
            }
            
            ListNode x=curr.next;
            curr.next=next;
            prev.next=curr;
            
            curr=x;
        }
        
        return sorted.next;
    }
}

