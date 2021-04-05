import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class April21C_BOLT
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        while(t!=0)
        {
            double k1,k2,k3,i,v=0;
            String line=br.readLine(); // to read multiple integers line
            String[] strs = line.trim().split("\\s+");
            k1=Double.parseDouble(strs[0]);
            k2=Double.parseDouble(strs[1]);
            k3=Double.parseDouble(strs[2]);
            v=Double.parseDouble(strs[3]);

            double res=k1*k2*k3*v;
            res=100/res;
            //res = Math.ceil(res * 100) / 100;
            DecimalFormat df = new DecimalFormat("##.##");
            //System.out.println("Rounded double (DecimalFormat) : " + df.format(res));
            res=Double.parseDouble(df.format(res));
            if(res<9.58)
                System.out.println("Yes");
            else
                System.out.println("No");
            //System.out.println(res);

            t--;
        }
    }
}