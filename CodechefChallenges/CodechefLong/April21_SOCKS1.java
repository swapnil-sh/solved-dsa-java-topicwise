import java.io.*;
import java.util.*;

class April21_SOCKS1
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int a,b,c,i,flag=0;
        String line=br.readLine(); // to read multiple integers line
        String[] strs = line.trim().split("\\s+");
        a=Integer.parseInt(strs[0]);
        b=Integer.parseInt(strs[1]);
        c=Integer.parseInt(strs[2]);

        int x[]=new int[12];

        for(i=1;i<=11;i++)
        {
            if(a==i)
                x[i]++;   
            if(b==i)
                x[i]++;
            if(c==i)
                x[i]++;
        }

        for(i=1;i<=11;i++)
        {
            if(x[i]>1)
            {
                flag=1;
                break;
            }
        }

        if(flag==1)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}