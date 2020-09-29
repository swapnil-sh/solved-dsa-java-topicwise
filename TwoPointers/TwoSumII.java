/*167. Two Sum II - Input array is sorted - Leetcode Two Pointers Java Solution*/

class TwoSumII
{
    public int[] twoSum(int[] n, int t)
    {
        
        int[] res = new int[2];
        int l=n.length;
        int st=0;
        int end = l-1;

        while(st<end)
        {
            if(n[st]+n[end]==t)
            {
                res[0]=st+1;
                res[1]=end+1;
                return res;
            }
            else if(n[st]+n[end]<t)
                st++;
            
            else if(n[st]+n[end]>t)
                end--;
        }
        
        return res;
    }

}
