/*Check Array Formation Through Concatenation - Java Leetcode Solutions*/

/*
TC - O(n^2)
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