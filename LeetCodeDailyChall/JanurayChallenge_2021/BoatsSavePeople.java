/*881. Boats to Save People - Leetcode Java Solution*/


/*
TC - O(nlogn)
SC - O(n)
*/

class BoatsSavePeople
{
    public int numRescueBoats(int[] p, int l)
    {
        Arrays.sort(p);
        int i=0,j=p.length-1,res=0;
        
        while(i<=j)
        {
            if(p[i]+p[j]<=l)
                i++;
            j--;
            res++;
        }
        
        return res;
    }
}