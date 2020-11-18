/*Reverse Alternate K Nodes - InterviewBit Java Solutions*/

/*
------------------------Recursive Solution-----------------------------

TC - O(n)
SC - O(n)
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class RevAltKNodesLL
{
    public ListNode solve(ListNode head, int k) 
    {
        if(k<=1 || head==null || head.next==null)
            return head;
        
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        
        int i=0;
        
        while(curr!=null && i<k)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            i++;
        }
        
        if(curr!=null)
            head.next=curr;
        i=0;
        while(curr!=null && i<k-1)
        {
            curr=curr.next;
            i++;
        }
        
        if(curr!=null)
            curr.next=solve(curr.next,k);
            
        return prev;
    }
}
