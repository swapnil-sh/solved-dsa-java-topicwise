/* Root to Leaf Paths - GeeksforGeeks Java Solution*/

/*
-------------------------Recursive Solution---------------------------
TC - O(n)
SC - O(h)
*/

class RootToLeafPaths
{
    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public void solve(Node root, ArrayList<Integer> al)
    {
        if(root==null)
            return;
        
        al.add(root.data);
        if(root.left==null && root.right==null)
        {
            //System.out.println(al);
            res.add(new ArrayList<>(al));
            //System.out.println(res);
            al.remove(al.size()-1);
            return;
        }
        
        solve(root.left, al);
        solve(root.right, al); 
        al.remove(al.size()-1);
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root)
    {
        // Code here
        if(root==null)
            return res;
        
        solve(root, new ArrayList<>());
        return res;
        
    }
    
}