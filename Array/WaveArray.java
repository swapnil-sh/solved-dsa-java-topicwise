/*Wave Array - InterviewBit Java Solution*/

/*
TC - O(nlogn)
SC - O(1)
*/

public class WaveArray
{
    public int[] wave(int[] a)
    {
        int i, n=a.length, t=0;
        
        Arrays.sort(a);
        i=1;
        while(i<n)
        {
            if(a[i]>a[i-1])
            {
                t=a[i];
                a[i]=a[i-1];
                a[i-1]=t;
            }
            
            if(i<n-2 && a[i]>a[i+1])
            {
                t=a[i];
                a[i]=a[i+1];
                a[i+1]=t;
            }
            
            i+=2;
        }
        
        return a;
    }
}
