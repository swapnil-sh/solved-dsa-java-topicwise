/*941. Valid Mountain Array - Leetcode Java Solution*/

/*
----------------Two Pointer--------------------
TC - O(n)
SC - O(1)
*/

class ValidMountainArr{
    public boolean validMountainArray(int[] a) {
    
        if(a.length<3)
            return false;
        
        int i=0,j=a.length-1;
    
        while(i<j){
            
            if(a[i]<a[i+1])
                i++;
            
            else if(a[j]<a[j-1])
                j--;
                        
            else
                return false;
        }
        
        if(j-i==0 && j!=a.length-1 && i!=0)
            return true;
        
        return false;
    }
}