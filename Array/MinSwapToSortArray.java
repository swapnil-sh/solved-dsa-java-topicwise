/* Minimum Swaps to Sort  - GeeksforGeeks Java multiple Solutions*/


//--------------------------------Solution using Hashmap with TC-O(nLogn) -----------------------------

class MinSwapToSortArray
{
    
    void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
	public int minSwaps(int[] a, int N)
	{
	    int res=0,i;
        int[] temp = Arrays.copyOfRange(a, 0, N);
 
        HashMap<Integer, Integer> hmap=new HashMap<Integer, Integer>();
 
        Arrays.sort(temp);
        
        for(i=0;i<N;i++) 
            hmap.put(a[i], i);
        
        for(i=0;i<N;i++)
        {
            if(a[i]!=temp[i])
            {
                int init=a[i];
                swap(a,i,hmap.get(temp[i]));
                
                hmap.put(init,hmap.get(temp[i]));
                hmap.put(temp[i],i);
                
                res++;
            }
            
        }
        
        return res;
	}
	
}