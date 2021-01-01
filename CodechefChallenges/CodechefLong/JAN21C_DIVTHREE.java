import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
  
public class JAN21C_DIVTHREE
{ 
    public static void main(String[] args)throws IOException 
    { 
  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
  
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int t=Integer.parseInt(st.nextToken()); 
        while (t-->0) 
        { 
            String[] arr=br.readLine().split("\\s");
	    int n=Integer.parseInt(arr[0]);
	    long k=Long.parseLong(arr[1]);
            long d=Long.parseLong(arr[2]);

            arr=br.readLine().split("\\s");
            long a[]=new long[n];
            int i;
            for(i=0;i<arr.length;i++)
                a[i]=Long.parseLong(arr[i]);

            long sum=0;
            for(i=0;i<a.length;i++)
                sum+=a[i];
            
            if(sum<k)
                System.out.println(0);
            
            else if(sum/k>d)
                System.out.println(d);
            else
            {
                System.out.println(sum/k);
            }

        } 
         
    } 
} 
