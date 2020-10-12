/*445. Add Two Numbers II - Leetcode Stack Java Solution*/

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
class AddTwoLL2
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) 
        {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null)
        {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode res=new ListNode(0);
        int sum=0;
        int carr=0;
        int last_dig=0;
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            int d1=(s1.isEmpty()==true)? 0:s1.pop();
            int d2=(s2.isEmpty()==true)? 0:s2.pop();
           
            sum=carr+d1+d2;
            last_dig=sum%10;
            carr=sum/10;
            
            res.val=last_dig;
            ListNode before=new ListNode(carr);
    		before.next=res;
            
            res=before;
            
        }
        
        return res.val==0 ? res.next:res;
        
    }
}
