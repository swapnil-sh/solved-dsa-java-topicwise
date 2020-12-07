/* Merge two BST 's  - GeeksforGeeks Java Solution*/


/*
_-----------Recursion Inorder Traversal----------------

Time Complexity: O(n1+n2)
Space Complexity: O(n1+n2)
*/

class MergeTwoBST
{
    // Return a integer of integers having all the nodes in both the BSTs in a sorted order.
    
    public void inorderTrav(Node root, List<Integer> res)
    {
        if(root==null)
            return;
            
        inorderTrav(root.left, res);
        res.add(root.data);
        inorderTrav(root.right, res);
        
        return;
    }
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> t1=new ArrayList<>();
        List<Integer> t2=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        
        if(root1==null && root2==null)
            return res;

        inorderTrav(root1, t1);
        inorderTrav(root2, t2);
        
        int i=0,j=0;
        while(i<t1.size() && j<t2.size())
        {
            if(t1.get(i)<t2.get(j))
            {
                res.add(t1.get(i));
                i++;
            }
            else
            {
                res.add(t2.get(j));
                j++;
            }
        }
        
        while(i<t1.size())
        {
            res.add(t1.get(i));
            i++;
        }
        
        while(j<t2.size())
        {
            res.add(t2.get(j));
            j++;
        }
        
        return res;
    }
}
