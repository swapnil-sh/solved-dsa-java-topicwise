/*Print Value Of Rsb Mask - PepCoding Program-2*/

/*
Question - 
1. You are given a number n.
2. You have to print the right-most set bit mask.
*/

/*
Approach - 

Let x be the number - 
x = A 1's and 0's  1*  B 0's
(1's compliment of x) 
x' = ~x = A 0's and 1's  0*  B 1's
(2's compliment of x)
x'' = ~x+1 = A 0's and 1's  1*  B 0's

Right Most Set bit - 

rsb = x & x'' or we can also write it as rsb = x & -x (where -x = w's compliment of x)

x = A 1's and 0's  1*  B 0's
x'' = ~x+1 = A 0's and 1's  1*  B 0's
------------------------------------------
rsb = A 0's  1*  B 0's

*/


import java.io.*;
import java.util.*;

public class RightMostSetBit
 {

  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    //write your code here
    
    int rsb = n & -n;
    
    System.out.println(Integer.toBinaryString(rsb));
  }

}


