import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
  
public class JAN21C_BILLRD
{ 
    public static void main(String[] args)throws IOException 
    { 
  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); 
        while(t--!=0) 
        { 
            String[] ipArr=br.readLine().split("\\s");
            long n=Long.parseLong(ipArr[0]);
            long k=Long.parseLong(ipArr[1]);
            long x=Long.parseLong(ipArr[2]);
            long y=Long.parseLong(ipArr[3]);
            long a[][]=new long[4][2];

            if(x==y)
            {
                System.out.println(n + " " + n);
                continue;
            }

            else if(x>y)
            {
                
                a[0][0]=n;
                a[0][1]=y+n-x;
                a[1][0]=y+n-x;
                a[1][1]=n;
                a[2][0]=0;
                a[2][1]=x-y;
                a[3][0]=x-y;
                a[3][1]=0;
            }

            else
            {
                a[0][0]=x+n-y;
                a[0][1]=n;
                a[1][0]=n;
                a[1][1]=x+n-y;
                a[2][0]=y-x;
                a[2][1]=0;
                a[3][0]=0;
                a[3][1]=y-x;
            }

            System.out.print(a[(int)(k-1)%4][0] + " " + a[(int)(k-1)%4][1]); 
            System.out.println(); 
        } 
    } 
} 
