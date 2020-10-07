/*454. 4Sum II - Leetcode HashMap Java Solution*/

class 4SumII
{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) 
    {
        int i,j,sum=0;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        
        for(i=0;i<A.length;i++)
        {
           for(j=0;j<B.length;j++)
           {
              sum=A[i]+B[j];
              if(hm.containsKey(sum))
                hm.put(sum,hm.get(sum)+1);
              else
                hm.put(sum,1);
           }
        }
        
        int ans=0;
        for(i=0;i<C.length;i++)
        {
           for(j=0;j<D.length;j++)
           {
              sum=-(C[i]+D[j]);
             
              if(hm.containsKey(sum))
                ans+=hm.get(sum);

           }
        }
        
     return ans;   
    }
}
