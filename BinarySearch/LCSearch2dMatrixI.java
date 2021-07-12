/*74. Search a 2D Matrix - Leetcode Java Solutions*/

/*
-------------------------Binary Search Optimal Solution------------------------------------
TC - O(log(nXm))
SC - O(1)
*/

class LCSearch2dMatrixI{
    
    public boolean util(int [][]m, int t){
        
        int r,c,st,end;
        r=m.length;
        c=m[0].length;
        st=0;
        end=r*c-1;
        
        while(st<=end){
            
            int mid=st+(end-st)/2;

            int i=mid/c;
            int j=mid%c;
            
            if(m[i][j]==t)
                return true;
            else if(t>m[i][j])
                st=mid+1;
            else
                end=mid-1;
        }
        
        return false;
    }
    public boolean searchMatrix(int[][] m, int t) {
        
       return util(m, t);
    }
}




/*
-------------------------Better Binary Search Solution------------------------------------
TC - O(nlogm)
SC - O(1)
*/

/*
class Solution {
    
    public boolean bsUtil(int [][]m, int t){
        
        
        for(int r=0;r<m.length;r++){
            
            int st=0;
            int end=m[0].length-1;
            
            while(st<=end){
            
            int mid=st+(end-st)/2;
                
            if(m[r][mid]==t)
                return true;
            else if(t>m[r][mid])
                st=mid+1;
            else
                end=mid-1;   
            }
        }
        
        
        return false;
    }
    public boolean searchMatrix(int[][] m, int t) {
        
       return bsUtil(m, t);
    }
}
*/


/*
-------------------------Better Solution------------------------------------
TC - O(n+m)
SC - O(1)

This might not work in this question for some cases, check later.
*/
/*
class Solution {
    
    public boolean util(int [][]m, int t){
        
        int i=0;
        int j=m[0].length-1;
        
        while(i>=0 && i<m.length && j>=0 && j<m[0].length){
            
            if(m[i][j]==t)
                return true;
            else if(t>m[i][j])
                i++;
            else
                j--;   
        }
        
        return false;
    }
    public boolean searchMatrix(int[][] m, int t) {
        
       return Util(m, t);
    }
}
*/



/*
-------------------------Brute Force Solution------------------------------------
TC - O(nXm)
SC - O(1)
*/
/*
class Solution {
    public boolean searchMatrix(int[][] m, int t) {
        
        int i,j,r,c;
        r=m.length;
        c=m[0].length;
        
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                
                if(m[i][j]==t)
                    return true;
            }
        }
        
        return false;
    }
}
*/