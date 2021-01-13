/*Maximum of all subarrays of size k - GeeksforGeeks Java Solutions */


/*
/*
----------------------------Sliding Window and Dequeue-----------------------
TC - O(n)
SC - O(k)
*/

*/
class MaxElesFromSubarrOfK
{
    static ArrayList <Integer> max_of_subarrays(int a[], int n, int k)
    {
        // Your code here
        int i,j,max=Integer.MIN_VALUE;
        ArrayList<Integer> res=new ArrayList<>();
        
       i=0;
       j=0;
       
       Deque<Integer> dq = new LinkedList<Integer>();
       while(j<n)
       {
            while(!dq.isEmpty() && a[dq.peekLast()]<=a[j])
                dq.removeLast();
            
            dq.addLast(j);
            
            if(j-i+1<k)
                j++;
                
            else if(j-i+1==k)
            {
                if(!dq.isEmpty() && dq.peekFirst()<i)
                    dq.removeFirst();
                    
                res.add(a[dq.peekFirst()]);
                    
                j++;
                i++;
            }
        }
    //   while(j<n)
    //   {
    //         while (!dq.isEmpty() && a[j]>=dq.peekLast())
    //             dq.removeLast();
            
    //         dq.addLast(a[j]);
            
    //         if(j-i+1==k)
    //         {
    //             res.add(dq.peekFirst());
    //             if(!dq.isEmpty() && dq.peekFirst()==a[i])
    //                 dq.removeFirst();
                
    //             i++;
    //             j++;
    //         }
    //         else
    //             j++;
    //   }
        
        
        return res;
    }
}
/*
----------------------------Brute Force------------------------
TC - O(n*k)
SC - O(1)
*/
/*
class MaxElesFromSubarrOfK
{
    static ArrayList <Integer> max_of_subarrays(int a[], int n, int k)
    {
        // Your code here
        int i,j,max=Integer.MIN_VALUE;
        ArrayList<Integer> res=new ArrayList<>();
        
        for(i=0;i<=n-k;i++)
        {
            max=Integer.MIN_VALUE;
            for(j=i;j<i+k;j++)
            {
                if(a[j]>max)
                    max=a[j];
            }
            res.add(max);
        }
        
        return res;
    }
}*/