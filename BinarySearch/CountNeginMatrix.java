class CountNeginMatrix 
{
    public int countNegatives(int[][] grid)
    {
        int i,j,ans=0,pos1=-1,pos2=-1;
        int l=0;
        int r=grid[0].length;
        
        
        for(i=0;i<grid.length;i++)
        {
            l=0;
            r=grid[0].length-1;
            pos1=-1;
            while(l<=r)
            {
                int mid = l + (r-l)/2;
                if(grid[i][mid]<0) 
                {
                    pos1 = mid;
                    r=mid-1;
                }
                else 
                {
                    l=mid+1;
                }
            }
                
            
            pos2=grid[i].length-1;
            //System.out.println(pos1+" "+pos2);
            if(pos1==-1)
                ans+=0;
            else
                ans=ans+Math.abs(pos1-pos2)+1;
            
        }
        
        return ans;

        
    }
}
