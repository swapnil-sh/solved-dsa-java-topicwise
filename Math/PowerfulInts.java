/*970. Powerful Integers - Leetcode Java Solution*/

/*
Time Complexity: Let N be logxbound\text{log}_x \text{bound}logx​bound and MMM be logybound\text{log}_y \text{bound}logy​bound. 
Then the overall time complexity is O(N×M)O(N \times M)O(N×M) because we used a nested loop structure to calculate all of the powerful integers.

Space Complexity: O(N×M)O(N \times M)O(N×M) because we use a set to omit duplicates. 
We could just use our result list to check membership before adding values. However, that would be costly in terms of time complexity because it would require a full scan of the result list to see if the value already exists.

*/
class PowerfulInts
{
    public List<Integer> powerfulIntegers(int x, int y, int bd) 
    {
        int pwx=x,pwy=y;
        List<Integer> px=new ArrayList<>();
        List<Integer> py=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Set<Integer> hs=new HashSet<>();
        
        px.add(1);
        py.add(1);
        
        if(x!=1)
        {
            while(pwx<bd)
            {
                px.add(pwx);
                pwx=pwx*x;
            }
        }
        
        if(y!=1)
        {
            while(pwy<bd)
            {
                py.add(pwy);
                pwy=pwy*y;
            }
        }
        
        for(int i: px)
        {
            for(int j: py)
            {
                if(i+j<=bd)
                    hs.add(i+j);
            }
        }
        
        Iterator<Integer> it=hs.iterator();  
        while(it.hasNext())  
           res.add(it.next());
        
        return res;
    }
}