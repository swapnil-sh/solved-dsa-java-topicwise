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


//-----------------------------------GFG Solution using ArrayList of Pairs with TC = O(nlogn) (For Reference)---------------------------------------
/*

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.*;
 
class GfG
{
    // Function returns the 
    // minimum number of swaps
    // required to sort the array
    public static int minSwaps(int[] arr)
    {
        int n = arr.length;
 
        // Create two arrays and 
        // use as pairs where first
        // array is element and second array
        // is position of first element
        ArrayList <Pair <Integer, Integer> > arrpos =
                  new ArrayList <Pair <Integer, 
                                      Integer> > ();
        for (int i = 0; i < n; i++)
             arrpos.add(new Pair <Integer, 
                               Integer> (arr[i], i));
 
        // Sort the array by array element values to
        // get right position of every element as the
        // elements of second array.
        arrpos.sort(new Comparator<Pair<Integer, 
                                         Integer>>()
        {
            @Override
            public int compare(Pair<Integer, Integer> o1,
                               Pair<Integer, Integer> o2)
            {
                if (o1.getKey() > o2.getKey())
                    return -1;
 
                // We can change this to make 
                // it then look at the
                // words alphabetical order
                else if (o1.getKey().equals(o2.getKey()))
                    return 0;
 
                else
                    return 1;
            }
        });
 
        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);
 
        // Initialize result
        int ans = 0;
 
        // Traverse array elements
        for (int i = 0; i < n; i++)
        {
            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] || arrpos.get(i).getValue() == i)
                continue;
 
            // find out the number of  node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;
 
                // move to next node
                j = arrpos.get(j).getValue();
                cycle_size++;
            }
 
            // Update answer by adding current cycle.
            if(cycle_size > 0)
            {
                ans += (cycle_size - 1);
            }
        }
 
        // Return result
        return ans;
    }
}


*/


//Note - Can also be solved using Selection sort but with TC = O(n*n)