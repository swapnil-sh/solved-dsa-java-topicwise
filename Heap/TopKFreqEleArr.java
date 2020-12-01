/*347. Top K Frequent Elements - Leetcode Java Solutions*/

class TopKFreqEleArr
{
    public int[] topKFrequent(int[] a, int k) 
    {
        
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer,Integer> hmap=new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        (n1, n2) -> n1.getValue() - n2.getValue());
        
        int i;
        for(i=0;i<a.length;i++)
        {
            if(hmap.containsKey(a[i]))
                hmap.put(a[i],hmap.get(a[i])+1);
            else
                hmap.put(a[i],1);
        }
        
        for(Map.Entry mapElement : hmap.entrySet())
        {
            minHeap.add(mapElement);
            
            if(minHeap.size()>k)
                minHeap.poll();
        }
        
        while(k--!=0)
            res.add(minHeap.poll().getKey());
        
        return res.stream().mapToInt(j -> j).toArray();
    }
}