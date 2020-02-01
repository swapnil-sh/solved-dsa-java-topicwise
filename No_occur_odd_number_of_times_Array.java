import java.io.*;
import java.util.*;
public class Main
 {

     /*
            XOR operation of a number with itself results in 0.
            Example:
            Consider 5 XOR 5
            Binary representation for 5 is 101. Hence applying bitwise XOR on 5 following rules given in the above truth table -
            101 XOR 101 = 000 = 0
            Now, if XOR is applied on the above result with 5, we get 5 XOR 5 XOR 5 as -
            000 XOR 101 = 101 = 5

            XOR operation on a number with itself even number of times will result in 0.
            XOR operation on a number with itself odd number of times will result in the number itself.
     */

    public static void printNumberOccuringOddNumberOfTimesXOR(int[] a)
    {
        if(a == null || a.length == 0)
        {
            System.out.println("Empty input array.");
            return;
        }
        int r = a[0];
        for (int i = 1; i < a.length; i++) {
            r = r ^ a[i];
        }
        System.out.println("Number occurring odd number of times is using XOR operation " + r);
    }

    public static void printNumberOccuringOddNumberOfTimesHash(int[] a)
    {
        if(a == null || a.length == 0) 
        {
            System.out.println("Empty input array.");
            return;
        }

        int i;
 
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(i=0;i<a.length;i++)
        {
            int key = a[i];
            if(map.containsKey(key))
            {
                int value = map.get(key);
                map.put(key, value + 1);
            }
            else 
            {
                map.put(key,1);
            }
         
        }

        for (Map.Entry mapElement : map.entrySet())
        { 
            int value = (int)(mapElement.getValue());
            if(value%2!=0)
            {
                System.out.println("Number occurring odd number of times is using HashMAp = " + mapElement.getKey());
                break;
            }
        }
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i,n;
        n = Integer.parseInt(br.readLine());
        int a[] = new int[n];

        for(i=0;i<n;i++)
            a[i] = Integer.parseInt(br.readLine());


        printNumberOccuringOddNumberOfTimesXOR(a);
        printNumberOccuringOddNumberOfTimesHash(a);

    }
}
