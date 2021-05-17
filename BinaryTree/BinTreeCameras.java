/*968. Binary Tree Cameras*/

class BinTreeCameras
{
    int cam = 0;
    public int dfs(TreeNode node) 
    {
        if(node == null) return 1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left == 0 || right == 0) 
        {
            cam++;
            return 2;
        }
        else if(left == 2 || right == 2) 
            return 1;
        else 
            return 0;
    }
    
    public int minCameraCover(TreeNode root) 
    {
        return dfs(root)==0 ? cam+1 : cam;
    }
}