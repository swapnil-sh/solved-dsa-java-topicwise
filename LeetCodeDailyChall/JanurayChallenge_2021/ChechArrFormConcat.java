/*Check Array Formation Through Concatenation - Java Leetcode Solutions*/

/*
-----------------------Using HashMap----------------------------------
TC - O(n)
SC - O(n)
*/

class ChechArrFormConcat
{
    public boolean canFormArray(int[] a, int[][] pieces) 
    {
        
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces)
            map.put(piece[0], piece);
        
        // for(Map.Entry hm : map.entrySet())
        //     System.out.println(hm.getKey()+" "+hm.getValue());

        int i=0;
        while(i<a.length) 
        {
            int curVal = a[i];
            if (map.containsKey(curVal)) 
            {
                int[] piece = map.get(curVal);
                for (int value : piece) 
                {
                    if (a[i] == value) 
                        i++;
                    else 
                        return false;
                }
            }
            
            else
                return false;
        }
        
        return true;
        
    }
}

/*
-----------------------Using Array----------------------------------

TC - O(n)
SC - O(1)
*/

/*
class Solution 
{
    public boolean canFormArray(int[] a, int[][] pieces) 
    {
        
        int index[]=new int[101];
        int i;
        for(i=0;i<a.length;i++)
            index[a[i]]=i+1;
        
        for(int piece[]: pieces)
        {
            if(index[piece[0]]==0)
                return false;
            
            for(i=1;i<piece.length;i++)
            {
                if(index[piece[i]]-index[piece[i-1]]!=1)
                    return false;
            }
        }
        
        return true;
        
    }
}
*/