/*82. Remove Duplicates from Sorted List II - Leetcode Java Solutions*/

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
class RemDupFromLLTwo
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head==null)
            return null;
        
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        
        ListNode pre=dummyNode;
        ListNode cur=head;
        
        while(cur!=null)
        {
            while(cur.next!=null && cur.val==cur.next.val)
                cur=cur.next;
            
            if(pre.next==cur)
                pre=pre.next;
            else
                pre.next=cur.next;
            
            cur=cur.next;
        }
        
        return dummyNode.next;
    
    }
}


/*
class Solution
{
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        
        ListNode p=head,q=head.next,prev=head;
        int flag=0;
        
        while(q!=null)
        {
            while(q!=null && p.val==q.val)
            {
                flag=1;
                q=q.next;
            }
            
            if(p==head && flag==1)
            {
                if(q==null)
                    return null;
                head=q;
                prev=head;
                flag=0;
            }
            
            else if(flag==1)
            {
                prev.next=q;
                flag=0;
            }
            else
                prev=p;
           
             if(q==null)
                break;
            p=q;
            q=q.next;
        }
        
        return head;
    }
}
*/