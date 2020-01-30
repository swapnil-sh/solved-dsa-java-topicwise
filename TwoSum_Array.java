import java.io.*;
import java.util.*;
class Main 
{

    public static int[] twoSumOptimized(int[] nums, int target)
    {
        Map<Integer, Integer> m = new HashMap<>();

        int i,d=0;
        int n = nums.length;
        int a[] = new int[2];
        for(i=0;i<n;i++)
            m.put(nums[i],i);

        for(i=0;i<n;i++)
        {
            d = target - nums[i];

            if(m.containsKey(d) && m.get(d) != i) 
            {
                 
                  a[0] = i;
                  a[1] = m.get(d);

            }
        }

        return a;
    }
    public static int[] twoSum(int[] nums, int target) 
    {
        int n = nums.length;
        int i=0,j=n-1;
        int a[] = new int[2];

         for(i=0; i<n;i++) 
         {
            for(j=i+1;j<n;j++) 
            {
                if (nums[j] == target - nums[i])
                {
                    a[0] = i;
    	            a[1] = j;
    	            break;
                }
            }
         }
        return a;
    }


    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t;
        t = Integer.parseInt(br.readLine());

        while(t!=0)
        {
            int n;
            n = Integer.parseInt(br.readLine());
            int a[] = new int[n];

            for(int i=0;i<n;i++)
                a[i] = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int  b[] = new int[2];
            b = twoSum(a,target);

            System.out.println("Normal Output");
            for(int i=0;i<2;i++)
                System.out.print(b[i] + " ");

            System.out.println();

            b = twoSumOptimized(a,target);
            System.out.println("Optimized Output");
            for(int i=0;i<2;i++)
                System.out.print(b[i]+" ");

            t=t-1;
        }
        
    }
}
