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
