/*1171. Remove Zero Sum Consecutive Nodes from Linked List - Leetcode Multiple Solutions using HashMap*/



/*---------------------------------Two Pass and Efficient Solution-------------------------------------------*/

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

class RemZeroConsNodesfromLL
{
    public ListNode removeZeroSumSublists(ListNode head)
    {
        
        HashMap<Integer,ListNode> hm=new HashMap<Integer,ListNode>();
        ListNode dummy=new ListNode();
        dummy.next=head;

        int prefixsum=0;
        for(ListNode i=dummy;i!=null;i=i.next)
        {
            prefixsum=prefixsum+i.val;
            hm.put(prefixsum,i);
        } 
        
        prefixsum=0;
        for(ListNode i=dummy;i!=null;i=i.next)
        {
            prefixsum=prefixsum+i.val;
            i.next=hm.get(prefixsum).next;
        }
            
        return dummy.next;
    }
}




/*---------------------------------Single pass while removing nodes-------------------------------------------*/




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

/*
class Solution
{
    public ListNode removeZeroSumSublists(ListNode head)
    {
        
        HashMap<Integer,ListNode> hm=new HashMap<Integer,ListNode>();
        ListNode dummy=new ListNode();
        
        dummy.next=head;
        ListNode curr=dummy;

        int prefixsum=0;
        while(curr!=null)
        {
            prefixsum=prefixsum+curr.val;
            
            if(!hm.containsKey(prefixsum))
                hm.put(prefixsum,curr);
            
            else
            {
                curr=hm.get(prefixsum).next;
                int p=prefixsum+curr.val;
                while(p!=prefixsum)
                {
                    hm.remove(p);
                    curr=curr.next;
                    p=p+curr.val;
                }
                
                hm.get(prefixsum).next=curr.next;
            
            }
            
            curr=curr.next;
        }
        
        return dummy.next;
    }
}



*/


/*----------------------Single pass while removing nodes and clearing complete hashmap------------------------------*/





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

/*
class Solution
{
    public ListNode removeZeroSumSublists(ListNode head)
    {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode curr=dummy;
        ListNode next=null;
        HashMap<Integer,ListNode> hm=new HashMap<Integer,ListNode>();
        
        int prefixsum=0;
       
        hm.put(0,dummy);
        
        while(curr!=null)
        {
            prefixsum=prefixsum+curr.val;
            next=curr.next;
            
            if(!hm.containsKey(prefixsum))
            {
                hm.put(prefixsum,curr);
                curr=curr.next;
            }
            else
            {
                hm.get(prefixsum).next=curr.next;
                hm.clear();
                prefixsum=0;
                curr=dummy;
            
            }
            
        }
        
        return dummy.next;
    }
}



*/


