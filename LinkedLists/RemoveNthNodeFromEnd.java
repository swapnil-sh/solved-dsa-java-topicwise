/*19. Remove Nth Node From End of List - Leetcode Java Solutions(Interview Prep)*/

/*
---------------------Two Pointer Single Pass Solution-----------------------

Idea is to keep two pointers n distance apart.
To avoid NPE/Edge case when a head could be deleted, use a dummy head to make life simpler.
Since we are using dummy head, we need to keep two pointers n+1 distance apart.

    Move forward cur pointer to n+1 th position
    Now move forward cur as well as newHeadPtr till cur becomes null.
    newHeadPtr will be at a node which is pointing to the node to be deleted.
    Simply point newHeadPtr's next to its next's next.
    Return next of dummyNode

TC - O(n)
S - O(1)

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
class RemoveNthNodeFromEnd
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        
        if(head.next==null && n==1)
            return null;
       
        int i;
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        
        ListNode curr=dummyNode;
        for(i=0;i<=n && curr!=null;i++)
            curr=curr.next;
        
        ListNode newHeadPtr=dummyNode;
        while(curr!=null)
        {
            newHeadPtr=newHeadPtr.next;
            curr=curr.next;
        }
        
        newHeadPtr.next=newHeadPtr.next.next;
        
        return dummyNode.next;
        
    }
}


/*
-----------------Two Pass Solution--------------------

TC - O(n)+O(n)
SC - O(1)

*/
/*
class Solution
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        
        if(head.next==null && n==1)
            return null;
        
        ListNode p=head;
        int len=0;
        while(p!=null)
        {
            len++;
            p=p.next;
        }
        
        if(len==n)
        {
            head=head.next;
            return head;
        }
        
        int i=0;
        p=head;
        while(p!=null && i<(len-n)-1)
        {
            p=p.next;
            i++;
        }
        
        p.next=p.next.next;
        
        return head;
        
    }
}

*/