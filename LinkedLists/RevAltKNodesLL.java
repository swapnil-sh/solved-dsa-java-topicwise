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


/*
------------------------Iterative Solution-----------------------------

TC - O(n)
SC - O(1)
*/

/*
public class Solution 
{
    public ListNode solve(ListNode head, int k) 
    {
        if(k<=1 || head==null || head.next==null)
            return head;
        
        ListNode prev = null; 
        ListNode curr = head; 
        ListNode temp = null; 
        ListNode tail = null; 
        ListNode newHead = null; 
        ListNode join = null; 
        int t = 0; 
      
        // Traverse till the end of the linked list 
        while (curr != null)  
        { 
            t = k; 
            join = curr; 
            prev = null; 
      
            /* Reverse alternative group of k nodes  
            // of the given linked list */
            while (curr != null && t-- >0)  
            { 
                temp = curr.next; 
                curr.next = prev; 
                prev = curr; 
                curr = temp; 
            } 
      
            // Sets the new head of the input list 
            if (newHead == null) 
                newHead = prev; 
      
            /* Tail pointer keeps track of the last node  
            of the k-reversed linked list. The tail pointer  
            is then joined with the first node of the  
            next k-nodes of the linked list */
            if (tail != null) 
                tail.next = prev; 
      
            tail = join; 
            tail.next = curr; 
      
            t = k; 
      
            /* Traverse through the next k nodes  
            which will not be reversed */
            while (curr != null && t-- >0) 
            { 
                prev = curr; 
                curr = curr.next; 
            } 
      
            /* Tail pointer keeps track of the last  
            node of the k nodes traversed above */
            tail = prev; 
        } 
      
        // newHead is new head of the modified list 
        return newHead; 
    }
}

*/