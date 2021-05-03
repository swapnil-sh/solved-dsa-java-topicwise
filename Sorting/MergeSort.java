/*Merge Sort - GeeksforGeeks Java Solution */

class MergeSort
{
    void merge(int a[], int l, int m, int r)
    {
         // Your code here
         int i=l,j=m+1,k=0;
         int temp[] = new int[r-l+1];
         
         while(i<=m && j<=r)
         {
             if(a[i]<=a[j])
             {
                 temp[k]=a[i];
                 i++;
             }
             else
             {
                 temp[k]=a[j];
                 j++;
             }
             
             k++;
         }
         
        while(i<=m)
            temp[k++]=a[i++];
        
        while(j<=r)
            temp[k++]=a[j++];
        
        k=0;
        for(i=l;i<=r;i++)
            a[i]=temp[i-l];
    }
    
    void mergeSort(int a[], int l, int r)
    {
        //code here
        if(l<r)
        {
            int mid=(l+r)/2;
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);
            merge(a, l, mid, r);
        }
    }
}
