/*Merge Two Sorted Lists - Leetcode Java Solution*/


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
class Merge2SorLists
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode res=new ListNode();
        ListNode temp=res;
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }
            else
            {
                temp.next=l2;
                l2=l2.next;
            }
            
            temp=temp.next;
        }
        
        temp.next=l1==null?l2:l1;
        return res.next;
        
    }
}