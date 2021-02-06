class RightSideView
{
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int levelSize=0;
        int i;
        TreeNode temp;
        
        while(!q.isEmpty())
        {
            levelSize=q.size();
            List<TreeNode> tl=new ArrayList<>(); 
            for(i=0;i<levelSize;i++)
            {
                temp=q.poll();
                
                if(temp.left!=null)
                    q.offer(temp.left);
                
                if(temp.right!=null)
                    q.offer(temp.right);
                
                
                tl.add(temp);
            }
            
            res.add(tl.get(tl.size()-1).val);
        }
        
        return res;   
    }
}