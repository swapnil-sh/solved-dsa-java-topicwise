/*451. Sort Characters By Frequency - Leetcode Java Solutions*/

/*
-------------------Using MaxHeap-----------------------

TC - O(nlogn)
SC - O(n)
*/

class SortCharsByFreq
{
    public String frequencySort(String s)
    {
        String res="";
        if(s.length()==0)
            return res;
        
        
        HashMap<Character,Integer> hm=new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
        (n1, n2) -> n2.getValue() - n1.getValue());
        
        int i;
        for(i=0;i<s.length();i++)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)+1);
        
        maxHeap.addAll(hm.entrySet());
        
        while(!maxHeap.isEmpty())
        {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(i=0;i<entry.getValue();i++)
                res=res+entry.getKey();
        }
        
        return res;
    }
}


/*
---------Efficient Solution--------------------------
*/
/*
class Solution 
{
    public String frequencySort(String s)
    {
        List<Character>[] freq = new List[s.length()+1];
        for(int i=0;i<=s.length();i++)
            freq[i] = new ArrayList<Character>();
        
        int[] fmap = new int[256];
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            fmap[ch]++;
        }
        
        
        
        for(int i=0;i<256;i++)
        {
            if(fmap[i]>0){
                freq[fmap[i]].add((char)(i));
            }
        }
        
         //System.out.println(Arrays.toString(freq));
        StringBuilder sb = new StringBuilder();
        
        for(int i=freq.length-1;i>=1;i--)
        {
            if(freq[i].size()>0)
            {
                for(char ch:freq[i])
                {
                    for(int j=0;j<i;j++)
                        sb.append(ch);
                }
            }
        }
       // System.out.println(Arrays.toString(fmap)+"|| "+ Arrays.toString(freq));
        return sb.toString();
    
    }
}
*/