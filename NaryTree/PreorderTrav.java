/*589. N-ary Tree Preorder Traversal - Leetcode Java Solution*/

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class PreorderTrav
{
    void solve(Node root, List<Integer> res)
    {
        if(root==null)
            return;
        
        res.add(root.val);
        int i;
        for(i=0;i<root.children.size();i++)
            solve(root.children.get(i), res);
        
    }
    public List<Integer> preorder(Node root) 
    {
        
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        
        
        solve(root, res);
        return res;
    }
}