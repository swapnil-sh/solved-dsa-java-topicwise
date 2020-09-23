//1351. Count Negative Numbers in a Sorted Matrix - Binary Search Java Solution

class CountNeginMatrix 
{
    public int findFirstOccur(int a[],int st,int end)
    {
        int pos=-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]<0)
            {
                pos=mid;
                end=mid-1;
            }
            else if(a[mid]>=0)
                st=mid+1;
     
        }
        
        return pos;
    }
    
    public static int findLastOccur(int a[],int st,int end)
    {
        int pos=-1;
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(a[mid]<0)
            {
                pos=mid;
                st=mid+1;
            }
            else if(a[mid]>=0)
                st=mid+1;
      
        }
        
        return pos;  
        
    } 
    
    public int countNegatives(int[][] grid)
    {
        int i,j,pos1=0,pos2=0,ans=0;
        int a[]=new int[grid[0].length];
        
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[i].length;j++)
            {
                a[j]=grid[i][j];
            }
            
            pos1=findFirstOccur(a,0,grid[i].length-1);
            pos2=findLastOccur(a,0,grid[i].length-1);
            System.out.println(pos1+" "+pos2);
            if(pos1==-1 && pos2==-1)
                ans+=0;
            else
                ans=ans+Math.abs(pos1-pos2)+1;
        }
        
        return ans;

        
    }
}
