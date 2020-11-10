/*48. Rotate Image - Leetcode Java Solution*/


/*
---------------------------Transpose and Reverse Each Row Apporach-----------------------

TC - O(n*n)
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




/*
---------------------------Transpose and Reverse Row Apporach with Extra Space i.e. temp matrix to store transpose-----------------------

TC - O(n*n)
SC - O(n*n)

*/