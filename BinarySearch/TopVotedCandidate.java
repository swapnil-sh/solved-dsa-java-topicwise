/*911. Online Election - Leetcode Binary Search Java Solution*/


class TopVotedCandidate
{
    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    int[] time;
    public TopVotedCandidate(int[] persons, int[] times)
    {
        int n=persons.length,lead=-1,i;
        Map<Integer, Integer> count=new HashMap<>();
        time = times;
        
        for(i=0;i<persons.length;i++)
        {
            count.put(persons[i],count.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || count.get(persons[i]) >= count.get(lead)) 
                lead = persons[i];
            
            hm.put(times[i], lead);
        }
    }
    
    public int q(int t) 
    {
        int st=0;
        int end=time.length;
        while (st<end)
        {
            int mid=st+(end-st)/2;
            
            if (time[mid] <= t)
            {
                st=mid+1;
            }
            else
            {
                end=mid;
            }
        }
        return hm.get(time[st-1]);
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
