/*Rat in a Maze Problem - I: GeeksforGeeks Java Solution using Backtracking*/


/*
Time Complexity: O((N2)4).
Auxiliary Space: O(L*X), L = length of the path, X = number of paths.

*/
class RatInMaze
{
    private static void findPathInMaze(int m[][], int n, ArrayList<String> res, int i, int j, String path)
    {
        if(i<0 || i>=n || j<0 || j>=n || m[i][j]==0)
            return;
        
        if(i==n-1 && j==n-1)
        {
            res.add(path);
            return;
        }
        
        m[i][j]=0;
        
        findPathInMaze(m,n,res,i+1,j,path+"D");
        findPathInMaze(m,n,res,i,j-1,path+"L");
        findPathInMaze(m,n,res,i,j+1,path+"R");
        findPathInMaze(m,n,res,i-1,j,path+"U");
        
        m[i][j]=1;
        
    }
    public static ArrayList<String> printPath(int[][] m, int n) 
    {
        ArrayList<String> res=new ArrayList<>();
        String path="";
        
        findPathInMaze(m,n,res,0,0,path);
        return res;
    }
}