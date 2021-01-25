/*1313. Decompress Run-Length Encoded List - Leetcode Java Solutions*/


class DecompressArr
{
    public int[] decompressRLElist(int[] a) 
    {
        
        int i,n=0,j,k=0;
        for(i=0;i<a.length-1;i+=2)
            n=n+a[i];
        
        int res[]=new int[n];
        
        for(i=0;i<a.length-1;i+=2)
        {
            for(j=0;j<a[i];j++)
                res[k++]=a[i+1];
        }
        
        return res;
    }
}