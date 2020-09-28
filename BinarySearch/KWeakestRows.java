/*1337. The K Weakest Rows in a Matrix - Leetcode Binary Search Java Solution*/

import java.util.*;
 
class KWeakestRows
{
    public int getLastOccurance(int[] arr,int n,int key)
    {
         
        int start=0;
        int end=n-1;
        int result=-1;
        
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            
            if(arr[mid]==key)
            {
                result=mid;
                start=mid+1;
            }
            
            else if(arr[mid]<key) 
                end=mid-1;
            
            else 
                start=mid+1;
        }
        
        return result;
    }
    
    public int[] kWeakestRows(int[][] a, int k) 
    {
        
        int i;
        int n=a.length;
        HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
        
        for(i=0;i<n;i++)
        {
            int lastOcc=getLastOccurance(a[i],a[i].length,1);
           
            hmap.put(i,lastOcc+1);
        }
        
        
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hmap.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap 
        
        int res[]=new int[k];
        i=0;
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) 
        { 
            res[i++]=aa.getKey();
            System.out.println(aa.getKey()+" - "+aa.getValue());
            if(i==k)
                break;
        } 

        return res;
    }
}
