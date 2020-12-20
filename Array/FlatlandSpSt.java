/*Flatland Space Stations - Hackerrank Java Solution*/

public class FlatlandSpSt
{

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) 
    {
        int i,j,k,p,q;
        int a[]=new int[n];
        int left[]=new int[n];
        int right[]=new int[n];
        
        for(i=0;i<n;i++)
        {
            a[i]=-1;
            right[i]=0;
            left[i]=0;
        }
        
        for(i=0;i<c.length;i++)
            a[c[i]]=c[i];
        
            
        for(i=0;i<n;i++)
        {
            p=0;
            q=0;
            for(j=i,k=i; j<n || k>=0; j++,k--)
            {

                if(j<n)
                {
                    if(a[j]==-1)
                        p++;
                    else
                    {
                        right[i]=p;
                        break;
                    }
                }
                if(k>=0)
                {
                    if(a[k]==-1)
                        q++;
                    else
                    {
                        left[i]=q;
                        break;
                    }
                }
            }
        }
            
        int max1=right[0];
        int max2=left[0];
        
        for(i=0;i<n;i++)
        {
            if(right[i]>max1)
                max1=right[i];
                
            if(left[i]>max2)
                max2=left[i];
        }
        
        
        return Math.max(max1, max2);

    }
}