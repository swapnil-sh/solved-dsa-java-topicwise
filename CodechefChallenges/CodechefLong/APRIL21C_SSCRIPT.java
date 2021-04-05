import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class APRIL21C_SSCRIPT
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        while(t!=0)
        {
            int n,k;
            String line=br.readLine(); // to read multiple integers line
            String[] strs=line.trim().split("\\s+");
            n=Integer.parseInt(strs[0]);
            k=Integer.parseInt(strs[1]);
            String s=br.readLine();
            int i,j,c=0,flag=0;
            String res="NO";
            i=0;
            j=0;

            while(i<s.length())
            {
                j=i;
                c=0;
                while(j<s.length() && s.charAt(j)=='*')
                {
                    c++;
                    j++;
                    if(c>=k)
                    {
                        flag=1;
                        break;
                    }
                }

                if(flag==1)
                {
                    res="YES";
                    break;
                }

                i=j+1;
            }

            System.out.println(res);
            t--;
        }
    }
}