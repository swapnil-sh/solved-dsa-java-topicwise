/*Spiral Order Matrix II - InterviewBit Java Solution*/

/*
    Asked in: Microsoft, JP Morgan, Amazon
*/

/*
TC - O(n^2)
SC - O(n^2) -- (result)
*/

public class SpiralOrderMatrixII
{
    public int[][] generateMatrix(int n) 
    {
        int top=0,down=n-1,left=0,right=n-1;
        int a[][]=new int[n][n];
        int i,c=1,dir=0;
        
        while(top<=down && left<=right)
        {
            if(dir==0)
            {
                for(i=left;i<=right;i++)
                    a[top][i]=c++;
                top+=1;
            }
            else if(dir==1)
            {
                for(i=top;i<=down;i++)
                    a[i][right]=c++;
                right-=1;
            }
            else if(dir==2)
            {
                for(i=right;i>=left;i--)
                    a[down][i]=c++;
                down-=1;
            }
            else
            {
                for(i=down;i>=top;i--)
                    a[i][left]=c++;
                left+=1;
            }
            
            dir=(dir+1)%4;
        }
        
        return a;
    }
}
