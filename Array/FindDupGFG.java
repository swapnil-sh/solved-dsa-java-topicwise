/* Find duplicates in an array - GeeksforGeeks Java Solution using the concept Hashing*/

/*Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array.*/

class FindDupGFG
{
    public static ArrayList<Integer> duplicates(int a[], int n) 
    {
        // code here
        
        ArrayList<Integer> res=new ArrayList<>();
        int i;
        
        for(i=0;i<n;i++)
        {
            int ind=a[i]%n;
            a[ind]+=n;
        }
        
        for(i=0;i<n;i++)
        {
            if((a[i]/n)>1)
                res.add(i);
        }
        
        if(res.size()==0)
            res.add(-1);
            
      
        return res;
    }
}
