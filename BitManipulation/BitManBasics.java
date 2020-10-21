/*Basics Of Bit Manipulation - PepCoding Program-1*/

import java.io.*;
import java.util.*;

public class BitManBasics
{

  public static void main(String[] args)
  {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    int onmsk = (1<<i);
    int offmsk = ~(1<<j);
    int tmsk = (1<<k);
    int cmsk = (1<<m);
    
    System.out.println((n|onmsk));
    System.out.println((n&offmsk));
    System.out.println((n^tmsk));
    System.out.println((n&cmsk)==0?false:true);
      
  }

}