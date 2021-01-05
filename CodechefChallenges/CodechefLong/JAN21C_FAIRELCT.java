import java.util.*;
import java.io.*;

public class JAN21C_FAIRELCT
{
	public static void main (String[] args)throws Exception
	{
	   Scanner sc=new Scanner(System.in);

	   int t=sc.nextInt();
	   while(t--!=0)
       	   {
	    int n=sc.nextInt();
            int m=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[m];

            int i,j,sum1=0,sum2=0;

            for(i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                sum1+=a[i];
            }

            for(i=0;i<m;i++)
            {
                b[i]=sc.nextInt();
                sum2+=b[i];
            }

            if(sum1>sum2)
            {
                System.out.println(0);
                continue;
            }
            
            Arrays.sort(a);
            Arrays.sort(b);

            i=0;
            j=m-1;

            int res=0;
            while(i<n && j>=0)
            {
                sum1=sum1-a[i]+b[j];
                sum2=sum2-b[j]+a[i];
                res++;

                if(sum1>sum2)
                    break;
                
                i++;
                j--;
            }

            if(sum1>sum2)
	    	System.out.println(res);
	    else
	        System.out.println(-1);
       }
    }
}
