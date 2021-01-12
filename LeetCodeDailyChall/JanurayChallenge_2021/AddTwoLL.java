/*2. Add Two Numbers - Leetcode Java Solution*/


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
class AddTwoLL
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        if(l1==null && l2!=null)
            return l2;
        if(l2==null && l1!=null)
            return l1;
        
        ListNode res=new ListNode();
        ListNode p=res;
        int sum=0,carr=0;
        
        while(l1!=null && l2!=null)
        {
            sum=carr+l1.val+l2.val;
            carr=sum/10;
            ListNode temp=new ListNode(sum%10);
            p.next=temp;
            l1=l1.next;
            l2=l2.next;
            p=p.next;
        }
        
        ListNode x=l2==null?l1:l2;
        while(x!=null)
        {
            sum=carr+x.val;
            carr=sum/10;
            ListNode temp=new ListNode(sum%10);
            p.next=temp;
            p=p.next;
            x=x.next;
        }
        
        if(carr>0)
        {
            ListNode temp=new ListNode(carr);
            p.next=temp;
            p=p.next;
        }
            
        return res.next;
        
    }
}