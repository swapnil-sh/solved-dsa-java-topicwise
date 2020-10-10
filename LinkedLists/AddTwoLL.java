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
        ListNode sumList=new ListNode(0);
        ListNode p=sumList;
    
        int sum=0;
        int rem=0;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            int l1_val=(l1!=null) ? l1.val:0;
            int l2_val=(l2!=null) ? l2.val:0;
            
            sum=carry+l1_val+l2_val;
            rem=sum%10;
            carry=sum/10;
            
            ListNode newNode=new ListNode(rem);
            p.next=newNode;
            
            if(l1!=null)
                l1=l1.next;
            
            if(l2!=null)
                l2=l2.next;
            
            p=p.next;
        }
        
        if(carry>0)
        {
            ListNode newNode=new ListNode(carry);
            p.next=newNode;
            p=p.next;
        }
        
        return sumList.next;   
    }
}
