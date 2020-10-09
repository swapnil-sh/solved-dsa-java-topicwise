/*1290. Convert Binary Number in a Linked List to Integer - Leetcode Bin Rep App 1 Java Solution*/


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

class BinToDecLL 
{
    public int getDecimalValue(ListNode head)
    {
        if(head.next==null && head.val==1)
            return 1;
        if(head.next==null && head.val==0)
            return 0;
        
        int sum=head.val;
        while(head.next!=null)
        {
            sum=sum*2+head.next.val;
            head=head.next;
        }
        return sum;
    }
}




/*1290. Convert Binary Number in a Linked List to Integer - Leetcode Reverse Java Solution*/

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


class BinToDecLL 
{
    public ListNode rev(ListNode head)
    {
        if(head==null || head.next==null)
            return head;

        ListNode temp=rev(head.next);
        head.next.next=head;
        head.next=null;

        return temp;
    }
    public int getDecimalValue(ListNode head)
    {
        if(head.next==null && head.val==1)
            return 1;
        if(head.next==null && head.val==0)
            return 0;
        
        head=rev(head);
        
        ListNode p=head;
        int sum=0,i=0;
        while(p!=null)
        {
            sum+=Math.pow(2,i)*(p.val);
            p=p.next;
            i++;
        }
        
        return sum;
    }
}



