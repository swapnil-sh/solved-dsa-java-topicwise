/*1019. Next Greater Node In Linked List - Leetcode Stack Java Solution*/

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
class NxtGrtEelLL 
{
    public int[] nextLargerNodes(ListNode head) 
    {
        Stack<Integer> st=new Stack();
        ArrayList<Integer> a=new ArrayList<Integer>();
      
        for(ListNode node = head; node != null; node = node.next)
            a.add(node.val);
        
        int[] res = new int[a.size()];
        
        for(int i=a.size()-1;i>=0;i--)
        {
            while(!st.isEmpty() && a.get(i)>=st.peek())
                st.pop();
            
            if(!st.isEmpty())
            {
                res[i]=st.peek();
            }
          
            st.push(a.get(i));
        }
        return res;
    }
}
