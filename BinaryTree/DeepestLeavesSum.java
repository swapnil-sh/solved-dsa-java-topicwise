/*1302. Deepest Leaves Sum - Leetcode Java Solutions DFS and BFS*/


/*
------------------------Solution - I (DFS Traversal)---------------------------------

We can do a simple Depth-First Traversal on the Tree. We can obviously do one dfs traversal and find the depth of the deepest level and in the second dfs pass, we will add only those nodes that are on the deepest level. But we don't actually need two passes. This can be done in just one DFS pass.
We maintain sum which will store sum of values of deepest level nodes till now and deepest which will store the depth or level of the deepest nodes. There will be following cases available to us where current Node is -

Algo - 
    If Not a Leaf Node - Traverse the left and right node of the current node.
    A Leaf Node - This case will have 3 sub-cases possible -
        depth > deepest - If current node is the deepest node observed till now, reset the sum to current node value and set deepest = depth.
        depth == deepest - The current node is part of the deepest nodes observed till now. Add current root value to sum.
        depth < deepest - This node is not the deepest node. Just ignore this node.
    A NULL Node - We can't traverse any further. So just return.

Lastly, we will return the sum accumulated till now. The finaly value stored in sum will contain only the sum of value of the nodes (leaves) at deepest level.


TC - O(n)
SC - O(n)
*/

class DeepestLeavesSum
{
    int deepest=0, sum=0;
    int solve(TreeNode root, int depth)
    {
        if(root==null) 
            return 0;  // current node is NULL - just return.

        if(root.left==null && root.right==null)
        {
            // if current is a leaf node
            if(depth == deepest) 
                sum += root.val;  // if depth is exactly equal to deepest, add to sum
            
            else if(depth > deepest) 
            {
                sum = root.val;
                deepest = depth; // found a more deeper leaf node, reset sum and update deepest
            }
        }
        

        solve(root.left, depth+1);   // recurse for the left, 
        solve(root.right, depth+1);  // and the right node of the current node

	    return sum; // finally return the sum accumulated till now which will be sum of value of deepest leaves
    }
    
    public int deepestLeavesSum(TreeNode root) 
    {
        if(root==null)
            return 0;

        return solve(root, 0);
        
    }
}

/*
------------------------Solution - II (BFS Traversal)---------------------------------

TC - O(n)
SC - O(n)
*/
/*
class Solution 
{   
    public int deepestLeavesSum(TreeNode root) 
    {
        if(root==null)
            return 0;
        
        int i,res=0;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int level=q.size();
            ArrayList<Integer> al=new ArrayList<>();
            res=0;
            for(i=0;i<level;i++)
            {
                TreeNode temp=q.poll();
                
                if(temp.left!=null)
                    q.offer(temp.left);
                
                if(temp.right!=null)
                    q.offer(temp.right);
                
               res+=temp.val;
            }

        }
        
        return res;
    }
}
*/

/*
Q. DFS vs BFS. Which would be more efficient ? When would you prefer one over the other ?
Ans : If you were to get such a problem in interview, it's very likely that the interviewer would proceed to ask a follow-up question such as this one. The DFS vs BFS is a vast topic of discussion. But one thing that's for sure (and helpful to know) is none is always better than the other. You would need to have an idea of probable structure of Tree/Graph that would be given as input (and ofcourse what you need to find depending on the question ) to make a better decision about which approach to prefer.

A DFS is easy to implement and generally has advantage of being space-efficient, especially in a balanced / almost balanced Tree and the space required would be O(h) (where h is the height of the tree) while we would require O(2^h) space complexity for BFS traversal which could consume huge amount of memory when tree is balanced & for h is larger.

On the other hand, BFS would perform well if you don't need to search the entire depth of the tree or if the tree is skewed and there are only few branches going very deep. In worst case, the height of a tree h could be equal to n and if there are huge number of nodes, DFS would consume huge amounts of memory & may lead to stackoverflow.

In this question, the DFS performed marginally better giving better space efficiency than BFS. Again, this depends on the structure of trees used in the test cases.

These points I mentioned may sound very general and common, but I have just mentioned them here. Maybe someone might find it useful someday :)
*/