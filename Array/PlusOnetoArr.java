/*66. Plus One - Leetcode Java Solution*/


/*

TC - O(n)
SC - O(n+1)
*/


class PlusOnetoArr
{
    public int[] plusOne(int[] a)
    {
        int i;
        int sum=0;
        int carry=1;
        int n=a.length;
        
        for(i=n-1;i>=0;i--)
        {
            sum=carry+a[i];
            a[i]=sum%10;
            carry=sum/10;
        }
        
         if(carry==1)
         {
            int[] res = new int[a.length+1];
            System.arraycopy(a, 0, res, 1, a.length);
            res[0]=1;
            return res;
        }
        else
            return a;
        
    }
}