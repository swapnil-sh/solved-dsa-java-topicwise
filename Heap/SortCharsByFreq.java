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