/*Maximum Unsorted Subarray - InterviewBit Java Solution*/

/*
TC - O(n)
SC - O(1)
*/

public class MaxUnsortedSubArr
{
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A)
    {
        ArrayList<Integer> res=new ArrayList<>();
        int i,s=-1,e=-1;
        
        for(i=0;i<A.size()-1;i++)
        {
            if(A.get(i)>A.get(i+1))
            {
                s=i;
                break;
            }
        }
        
        if(s==-1)
        {
            res.add(-1);
            return res;
        }
        
        for(i=A.size()-1;i>0;i--)
        {
            if(A.get(i)<A.get(i-1))
            {
                e=i;
                break;
            }
        }
        
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(i=s;i<=e;i++)
        {
            min=Math.min(min, A.get(i));
            max=Math.max(max, A.get(i));
        }
        
        
        for(i=0;i<=s;i++)
        {
            if(min<A.get(i))
            {
                s=i;
                break;
            }
        }
        
        for(i=A.size()-1;i>=e+1;i--)
        {
            if(max>A.get(i))
            {
                e=i;
                break;
            }
        }
        
        res.add(s);
        res.add(e);
        
        
        return res;
    }
}
