/*73. Set Matrix Zeroes - Leetcode Java Solutions with explainations*/

/*
--------------------------Method 3 - Using In-Place Hashing---------------------------------
    Solution Steps

    1.Initialize frow and fcol to false. These two variables will store the status of the first row and first column.
    2.Now use the first row and first column as your hash which stores the status of that row and column.
    3.Now iterate over the matrix and for every a[i][j] == 0, set a[i][0] = 0 and a[0][j] = 0.
    4.Now update the values of the matrix except first row and first column to 0 if A[i][0] = true or a[0][i] = true for a[i][j].
    5.Now update the values of the first row and first column.


Time Complexity= O(M*N)
Space Complexity: O(1)
*/

class SetMatrixZeroes
{
    public void setZeroes(int[][] a) 
    {
        int m=a.length;
        int n=a[0].length;
        int i,j;
        
        boolean frow=false;
        boolean fcol=false;
        
        for(i=0;i<n;i++)
        {
            if(a[0][i]==0)
                frow=true;
        }
        
        for(i=0;i<m;i++)
        {
            if(a[i][0]==0)
                fcol=true;
        }
        
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i][j]==0)
                {
                    a[i][0]=0;
                    a[0][j]=0;
                }
            }
        }
        
        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                if(a[i][0]==0 || a[0][j]==0)
                    a[i][j]=0;
            }
        }
        
        if(frow==true)
        {
            for(i=0;i<n;i++)
                a[0][i]=0;
        }
        
        if(fcol==true)
        {
            for(i=0;i<m;i++)
                a[i][0]=0;
        }
    }
}

/*
----------------------------------Method 2 - Better Solution---------------------------------

Using seperate arrays for row and coloumn to store the value index of where the zero occurs in original array

TC = O(m*n)+O(m*n)+O(m+n)
SC = O(m+n)

*/

/*
class SetMatrixZeroes
{
    public void setZeroes(int[][] a) 
    {
        int m=a.length;
        int n=a[0].length;
        
        int row[]=new int[m];
        int col[]=new int[n];
        
        int i,j;
                          
        for(i=0;i<m;i++)
            row[i]=1;
        
        for(i=0;i<n;i++)
            col[i]=1;
                         
        for(i=0;i<m;i++){
            
            for(j=0;j<n;j++){
                
                if(a[i][j]==0){
                    
                    row[i]=0;
                    col[j]=0;
                }
                    
            }
        }
                          
        for(i=0;i<m;i++){
            
            if(row[i]==0){
                
                for(j=0;j<n;j++){
                    
                    a[i][j]=0;
                }
            }
                
        }
        
        for(i=0;i<n;i++){
            
            if(col[i]==0){
                
                for(j=0;j<m;j++){
                    
                    a[j][i]=0;
                }
            }
                
        }
                                                    
    }
}

*/

/*
----------------------------Method 1 - Brute Force Solution-------------------------------

One way would be to create an auxiliary matrix of the same size filled with 1’s.
We could make all changes required in this auxiliary matrix and then copy it to the original matrix in the end. 
We search for zeroes in the original matrix and update rows and columns in the auxiliary matrix.

TC - O(N*M*(N+M)) 
SC - O(m*n)

*/

/*
class Solution 
{
    public void setZeroes(int[][] a) 
    {
        int m=a.length;
        int n=a[0].length;
        
        int temp[][]=new int[m][n];
        int i,j,k;
        
	//storing all tll values of originial matrix to res
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                temp[i][j]=a[i][j];
            }
       }
        
	//only modifying the rows and coloumns of temp matrix whenever we find 0 in original matrix
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i][j]==0)
                {
                    for(k=0;k<m;k++)
                        temp[k][j]=0;
                    
                    for(k=0;k<n;k++)
                        temp[i][k]=0;
                    
                }
            }
        }
       
	//copying the values of temp matrix to original matrix         
       for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                a[i][j]=temp[i][j];
            }
       }
    }
}
*/


/*

Summing up

We have discussed three ways to solve this problem:

    Brute Force Approach: Using nested loops and extra space
    Using Hash Table: Storing the status of rows and columns in the Hash Table.
    Using In-Place Hashing: Storing hash in the matrix’s first row and column.
*/