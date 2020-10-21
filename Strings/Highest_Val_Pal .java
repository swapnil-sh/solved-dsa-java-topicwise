//Highest Value Palindrome - Two Pointer Solution Java Hackerrank

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Highest_Val_Pal  
{

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) 
    {
        if(k<0)
            return "-1";
        
        char palin[] = s.toCharArray();
        int i,j;
        i=0;
        j=n-1;
        
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                palin[i] = palin[j] = (char)Math.max(s.charAt(i),s.charAt(j));
                k--;
            }
            i++;
            j--;
        }
        if(k<0)
            return "-1";
        i=0;
        j=n-1;
        
        while(i<=j)
        {
            if(i==j && k>0)
            {
                palin[i] = '9';
                break;
            }

            if(palin[i]<'9')
            {
                if(k>=2 && ((palin[i] == s.charAt(i)) && (palin[j] == s.charAt(j))))
                {
                    palin[i] = palin[j] = '9';
                    k=k-2;
                }
            

                else if(k>=1 && (s.charAt(i)!=palin[i] || s.charAt(j)!=palin[j]))
                {
                    palin[i] = palin[j] = '9';
                    k--;
                }
            }
            i++;
            j--;
        }

        String ans = "";
        for(i = 0;i<palin.length;i++) 
            ans+=palin[i]; 
        return ans; 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

