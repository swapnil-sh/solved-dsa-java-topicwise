/*113. Path Sum II - Leetcode Java Solution*/

/*
-------------------------Recursive Solution---------------------------
TC - O(n)
SC - O(h)
*/
class PathSumII
{
    int sum=0;
    List<List<Integer>> res=new ArrayList<>();
    private void solve(TreeNode root, int ts, ArrayList<Integer> al)
    {
        if(root==null)
            return;
        
        al.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null)
        {
            System.out.println(sum + " " + ts);
            if(sum==ts)
            {
                res.add(new ArrayList<>(al));
                System.out.println(res);
            }
            
            sum-=root.val;
            al.remove(al.size()-1);
            return;
        }
        
        solve(root.left, ts, al);
        solve(root.right, ts, al);
        al.remove(al.size()-1);
        sum-=root.val;
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int ts) 
    {
        
        if(root==null)
            return res;
        
        solve(root, ts, new ArrayList<>());
        return res;
    }
}