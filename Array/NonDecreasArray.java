/*665. Non-decreasing Array - Leetcode Java Solution*/

/*
TC - O(n)
SC - O(1)
*/

class NonDecreasArray
{
    public boolean checkPossibility(int[] a)
    {
        int i=0,c=0,min=Integer.MAX_VALUE;
        for(i=1;i<a.length;i++)
        {
            if(a[i]<a[i-1])
            {
                if(i<2 || a[i-2]<=a[i])
                    a[i-1]=a[i];
                else
                    a[i]=a[i-1];
                
                c++;
            }
            
            if(c>1)
                return false;
        }
        return true;
    }
}