/* Count total set bits  - GeeksforGeeks and Pepcoding Java Solution*/

//Formula - 2^(x - 1)*x + (n - 2^x + 1) + solve(n - 2^x)

import java.io.*;
import java.util.*;


public class CntTotSetBits
{

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    while(t--!=0)
    {
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
  }

  public static int solution(int n)
  {
    //write your code here
    if(n==0)
        return 0;
        
    if(n==1)
        return 1;
        
    int x = powerOfTwo(n);
    
    int bitstill2x = (1 << (x-1)) * x;
    int msb = n - (1 << x) + 1;
    int rest = n - (1 << x);
    
    int res = bitstill2x+msb+solution(rest);
    
    return res;
  }
  
  public static int powerOfTwo(int n)
  {
    int x=0;
    while((1<<x)<=n)
        x++;
        
    return x-1;
  }
  

}