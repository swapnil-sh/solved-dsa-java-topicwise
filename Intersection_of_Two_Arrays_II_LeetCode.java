class Solution {
    public int[] intersect(int[] a, int[] b) 
    {
        
        HashMap<Integer,Integer> hmap1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> hmap2 = new HashMap<Integer,Integer>();
        
        int i;
        
        for(i=0;i<a.length;i++)
        {
            if(hmap1.containsKey(a[i]))
                hmap1.put(a[i],hmap1.get(a[i])+1);
            else
                hmap1.put(a[i],1);
        }
        
        for(i=0;i<b.length;i++)
        {
            if(hmap2.containsKey(b[i]))
                hmap2.put(b[i],hmap2.get(b[i])+1);
            else
                hmap2.put(b[i],1);
        }
        
         // for(Map.Entry m : hmap1.entrySet())
         //    System.out.println(m.getKey() + " " + m.getValue());
        
        int res[] = hmap1.size()>hmap2.size()?CompareMaps(hmap2,hmap1): CompareMaps(hmap1,hmap2); 
        
        return res;
    }
    
    public int[] CompareMaps(HashMap<Integer,Integer> hmap1,HashMap<Integer,Integer> hmap2)
    {
        List<Integer> res = new ArrayList<Integer>();     
        int i;
        for(Map.Entry m : hmap1.entrySet())
        {
            int x = (int)m.getKey();
            
            if(hmap2.containsKey(x))
            {
                int n = Math.min(hmap1.get(x),hmap2.get(x));
                for(i=0;i<n;i++)
                    res.add(x);
                
            }
        }
        
        int arr[] = new int[res.size()]; 
  
        // ArrayList to Array Conversion 
        for (i =0; i < res.size(); i++) 
            arr[i] = (int)res.get(i);
            
        return arr;
    }
}
