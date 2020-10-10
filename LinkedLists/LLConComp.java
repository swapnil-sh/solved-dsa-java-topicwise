/*817. Linked List Components - Leetcode Hashet Java Solution*/

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
class LLConComp 
{
    public int numComponents(ListNode head, int[] G) 
    {
     
        HashSet<Integer> hs=new HashSet<Integer>();
        
        for(int g: G)
            hs.add(g);
        
        ListNode par=null;
        ListNode curr=head;
        int res=0;
        
        while(curr!=null)
        {
            if(par==null)
            {
                if(hs.contains(curr.val))
                    res++;
            }
            else
            {
                if(!hs.contains(par.val) && hs.contains(curr.val))
                    res++;
            }
            
            par=curr;
            curr=curr.next;
        }
        
        return res;
    }
}



/*
Absolute garbage explanation and test cases from leetcode. Let me help, here are some sample inputs:

List =>  0->1->2->3->4->5->6->7->NULL
G    =>  [0,2,3,5,7]

Every element of the linked list that is in G is a component. So these are all components (marked with a 'c'):

         c     c  c     c     c
List =>  0->1->2->3->4->5->6->7->NULL

If you were to group together all of the components (c), then you would have the following groups:

0->
2->3->
5->
7->

Thus, 4 components... you're welcome.

*/
