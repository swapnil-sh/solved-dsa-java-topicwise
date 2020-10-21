/*Kernighans Algorithm - Pepcoding Program - 3 or Set Bits - GeeksforGeeks*/

/*
Question - 
1. You are given a number n.
2. You have to count the number of set bits in the given number.
*/


import java.io.*;
import java.util.*;

public class CountNoOfSetBits
{

  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //write your code here
    int counter=0;
    int rsb;
    
    while(n != 0)
    {
        rsb = n & -n;
        n = n - rsb;
        counter++;
    }
    
    System.out.println(counter);
  }

}