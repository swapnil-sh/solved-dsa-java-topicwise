/*Print string of odd length in ‘X’ format - GeeksforGeeks Java Solution*/


import java.io.*;
import java.util.*;

public class XPatternStr
{
    public static void main(String[] args)throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int t=Integer.parseInt(st.nextToken());
        while(t-->0)
        {
            String s=br.readLine();
            int n=s.length();
            int i,j,k;

            if(n%2==0)
                continue;

            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    if(i==j)
                        System.out.print(s.charAt(i));
                    else if((i+j)==(n-1))
                        System.out.print(s.charAt(i));
                    else
                        System.out.print(" ");
                }

                System.out.println();
            }
        }
    }
}