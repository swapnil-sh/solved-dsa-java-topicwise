/*92. Reverse Linked List II - Leetcode Java Solution (Reverse Sublist of a Linked List)*/

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

class ReverseSublistOfLL 
{
    public ListNode reverseBetween(ListNode head, int m, int n) 
    {
        if(head==null || head.next==null)
            return head;

        ListNode curr=head;
        ListNode prev,next,tail=null;
  
        prev=null;
        while(m>1)
        {
            prev=curr;
            curr=curr.next;
            m--;
            n--;
        }
        
        ListNode con=prev;
        tail=curr;
        next=null;
                
        while(n>0)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
                
            n--;
        }
            
        if(con!=null)
            con.next=prev;
        else
            head=prev;

        tail.next=curr;
        return head;
    }
}
