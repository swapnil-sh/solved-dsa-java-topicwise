/*141. Linked List Cycle - Leetcode Teo Pointer Java Solution*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LLCycle 
{
    public boolean hasCycle(ListNode head) 
    {
        if(head==null)
            return false;
       
        ListNode slow=head;
        ListNode fast=head.next;
        
        while(slow!=fast)
        {
            if(fast==null || fast.next==null)
                return false;
            
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return true;
    }
}


//----------------HashSet Solution--------------------------------

/*public boolean hasCycle(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
        if (nodesSeen.contains(head)) {
            return true;
        } else {
            nodesSeen.add(head);
        }
        head = head.next;
    }
    return false;
}*/
