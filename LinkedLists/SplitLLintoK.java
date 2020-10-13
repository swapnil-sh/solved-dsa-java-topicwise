/*725. Split Linked List in Parts - Leetcode Java Solution*/

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
    For Example -
    No of items in given linked list = 5
    No of parts that we need to divide the linked list in = 3
    
    No of values that can be there in each box = 5/3
    No of first n boxes that will have 1 extra element = 5%3
    
    n = [1,2,3,4,5] , k=3
    
    
    Initiallly how we can divide - 1,1,1 - Which is not possible as we have 5 elements with 1 element in each box (since 5/3=2)
    
    We will do n%k = 5%3 = 2
    
    So first 2 boxes will have 1 extra element = 2,2,1 -> final distribution --> [[1,2],[3,5],[5]]


*/

class SplitLLintoK 
{
    private int lengthOfLL(ListNode head)
    {
        int n=0;
        while(head!=null)
        {
            n++;
            head=head.next;
        }
        return n;
    }
    
    public ListNode[] splitListToParts(ListNode root, int k) 
    {
        int n;
        n=lengthOfLL(root);
        
        ListNode res[]=new ListNode[k];
        int sizeOfEachBox=n/k;
        int extraSize=n%k;
        
        ListNode curr=root,prev=null;
        int i,j;
        
        for(i=0; curr!=null && i<k; i++)
        {
            res[i]=curr;
            int sizeB=0;
            
            if(extraSize>0)
            {
                extraSize--;
                sizeB=sizeOfEachBox+1;
            }
            else
            {
                extraSize=0;
                sizeB=sizeOfEachBox;
            }
            
            for(j=0;j<sizeB;j++)
            {
                prev=curr;
                curr=curr.next;
            }
            
            prev.next=null;
            
        }
        
        return res;
    }
}
