/*PrePostInorder Traversals in One Code*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


/*
---------------------Iterative Using Stack----------------------------

TC - O(3*N)
SC - O(4*N)
*/

class Pair {
    
    TreeNode node;
    int count;
    
    Pair(TreeNode node, int count) {
        this.node = node;
        this.count = count;
    }
}
class PrePostInTrav {
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        if(root == null)
            return post;
        
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while(!st.isEmpty()) {
            
            Pair p = st.pop();
            
            if(p.count == 1) {
                
                pre.add(p.node.val);
                p.count++;
                st.push(p);
                
                if(p.node.left != null) {
                    st.push(new Pair(p.node.left, 1));
                }
            }
            else if(p.count == 2) {
                
                in.add(p.node.val);
                p.count++;
                st.push(p);
                
                if(p.node.right != null) {
                    st.push(new Pair(p.node.right, 1));
                }
            }
            else
                post.add(p.node.val);
        }
        
        return post;
    }
}