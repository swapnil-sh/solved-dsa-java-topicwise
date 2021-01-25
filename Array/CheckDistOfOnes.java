/*1437. Check If All 1's Are at Least Length K Places Away - Leetcode Java Solutions*/

class CheckDistOfOnes
{
    public boolean kLengthApart(int[] a, int k) 
    {
        int i,j,st=-1,end=-1,flag=0;
        
        for(i=0;i<a.length;i++)
        {
            if(a[i]==1)
            {
                if(st==-1)
                    st=i;
                flag++;
            }
            
            if(flag==2)
            {
                end=i;
                if(end-st-1<k)
                    return false;
                else
                {
                    st=i;
                    end=-1;
                    flag=1;
                }
            }
            
            
        }
        
        return true;
    }
}