/*21. Merge Two Sorted Lists - Leetcode Java Solutions*/



/*
----------------------------Inplace Solution without using Dummmy Node-----------------------

TC - O(n+m)
SC - O(1)

*/

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
        if(l1==null && l2==null)
            return null;
        
        if(l1==null && l2!=null)
            return l2;
        
        if(l1!=null && l2==null)
            return l1;
        
        if(l1.val>l2.val)
        {
            ListNode t=l1;
            l1=l2;
            l2=t;
        }
        ListNode res=l1;
        
        while(l1!=null && l2!=null)
        {
            ListNode t1=null;
            while(l1!=null && l1.val<=l2.val)
            {
                t1=l1;
                l1=l1.next;
            }
            
            t1.next=l2;
            
            ListNode t2=l1;
            l1=l2;
            l2=t2;
        }
        
        return res;
    }
}

/*--------------------------------Using DymmyNode--------------------------------*/

/*
class Merge2SorLists 
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1==null && l2==null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        
        ListNode temp=new ListNode();
        ListNode res=temp;
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
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
        
        
        temp.next=(l1!=null) ? l1:l2;
        
        return res.next;
        
    }
}
*/