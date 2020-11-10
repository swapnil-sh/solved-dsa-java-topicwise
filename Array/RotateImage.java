/*48. Rotate Image - Leetcode Java Solution*/


/*
---------------------------Transpose and Reverse Row Apporach-----------------------

TC - O(n)
SC - O(1)

*/

class RotateImage
{
    public void rotate(int[][] a)
    {
        int i,j;
        int n=a.length;
        
        
        for(i=0;i<n;i++)
        {
            for(j=i;j<n;j++)
            {
                int t=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=t;
            }
        }
        
        for(i=0;i<n;i++)
        {
            for(j=0;j<n/2;j++)
            {
                int t=a[i][j];
                a[i][j]=a[i][n-j-1];
                a[i][n-j-1]=t;
            }
        }
        
    }
}