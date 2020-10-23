/*Copy Set Bits In A Range - Pepcoding Program-21 Java Solution*/


/*
1. You are given two numbers A and B.
2. You are given two more numbers left and right, representing a range [left,right].
3. You have to set bits in B which are set in A lying in the above mentioned range.
4. Print the updated number B.
*/



/*
Approach - 

a =                         10101010101
mask =                      00000000001
mask<<(left-right+1) =      00000100000 
mask-- =                    00000011111
mask<<left-1 =              00001111100

mask&a =                    00001111100
                            10101010101
                            -----------
                            00001010100

b=b|mask =                  10010011001
                            00001010100
                            -----------
                            10011011101 --> Ans

*/
import java.io.*;
import java.util.*;

public class CopySetBitsinRange 
{

  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int left = scn.nextInt();
    int right = scn.nextInt();

   //write your code here
   int mask = (1 << (right - left + 1)) - 1;
   mask = (mask << (left - 1));
   mask = (mask & a);
   
   b = (b | mask);
   
   System.out.println(b);
    
  }

}