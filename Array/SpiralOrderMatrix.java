/*Spiral Order Matrix I - InterviewBit Java Solution*/

public class SpiralOrderMatrix
{
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] spiralOrder(final int[][] A)
    {
        int top=0,down=A.length-1,left=0,right=A[0].length-1;
        int a[]=new int[A.length*A[0].length];
        int dir=0;
        int i,k=0;
        
        while(top<=down && left<=right)
        {
            if(dir==0)
            {
                for(i=left;i<=right;i++)
                   a[k++]=A[top][i];
                top+=1;
            }
            else if(dir==1)
            {
                for(i=top;i<=down;i++)
                   a[k++]=A[i][right];
                right-=1;
            }
            else if(dir==2)
            {
                for(i=right;i>=left;i--)
                   a[k++]=A[down][i];
                down-=1;
            }
            else
            {
                for(i=down;i>=top;i--)
                   a[k++]=A[i][left];
                left+=1;
            }
            
            dir=(dir+1)%4;
        }
        
        return a;
    }
}
