/*109. Convert Sorted List to Binary Search Tree - LeetCode Java Solution*/

/*
----------------------Using Middle Element---------------------------
TC - O(nlogn)
SC - O(n)
*/
class SortedLLToBST
{
    TreeNode solve(ListNode st, ListNode end)
    {
        if(st==end)
            return null;
        
        ListNode s=st;
        ListNode f=st;
        while(f!=end && f.next!=end)
        {
            s=s.next;
            f=f.next.next;
        }
        
        TreeNode root=new TreeNode(s.val);
        root.left=solve(st, s);
        root.right=solve(s.next, end);
        
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) 
    {
        if(head==null)
            return null;
        
        return solve(head, null);
        
    }
}