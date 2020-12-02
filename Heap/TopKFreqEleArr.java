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

/*
-----------------------Using Quick Select-------------------------------
*/

/*
class Solution 
{
    HashMap<Integer,Integer> freq;
    public int[] topKFrequent(int[] nums, int k)
    {
        freq = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++)
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        
        
        int[] elems = new int[freq.size()];
        int index = 0;
        
        for(int num : freq.keySet())
            elems[index++] = num;
        
        quickSelect(elems, 0, elems.length-1, k);
        int res[]=new int[k];
        
        for(int i=0; i<k; i++)
            res[i]=elems[i];
        
        return res;
    }
    
    public void quickSelect(int[] elems, int lo, int hi, int k)
    {
        if(lo<hi)
        {
            int mid = partition(elems, lo, hi);
            if(mid==k)
                return;
            
            if(mid<k)
                quickSelect(elems, mid+1, hi, k);
            
            else
                quickSelect(elems, lo, mid-1, k);
        }
    }
    
    public int partition(int[] elems, int lo, int hi)
    {
        int pivotIndex = lo + (int)((hi-lo+1)*Math.random());
        swap(elems, pivotIndex, hi);
        
        int pivotFreq = freq.get(elems[hi]);
        int j = 0;
        
        for(int i=0; i<hi; i++)
        {
            if(freq.get(elems[i])>=pivotFreq)
                swap(elems, i, j++);
            
        }
        swap(elems, j, hi);
        return j;
    }
    
    public void swap(int[] elems, int i, int j)
    {
        int temp = elems[i];
        elems[i] = elems[j];
        elems[j] = temp;
    }
    
    
}
*/