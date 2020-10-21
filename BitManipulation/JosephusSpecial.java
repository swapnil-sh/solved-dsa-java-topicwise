/*Josephus Special  - PepCoding Program - 4*/


/*
Question - 

1. You are given an integer N which represents the total number of soldiers standing in a circle 
    having position marked from 1 to N.
2. A cruel king wants to execute them but in a different way.
3. He starts executing soldiers from 1st position and proceeds around the circle in clockwise 
    direction.
4. In each step, every second soldier is executed.
5. The elimination proceeds around the circle (which is becoming smaller and smaller as the 
    executed soldiers are removed), until only the last soldier remains, who is given freedom.
6. You have to find the position of that lucky soldier.

*/

/*
Approach-

Represent n in the form of 2^x+l, where (2^x<=n)

n=2^x+l
ans = 2*l+1

Ex - n=6

n = 2^2+2 = 6
l = 2
ans = 2*l+1 = 2*2+1 = 5

*/



import java.io.*;
import java.util.*;

public class JosephusSpecial 
{
    
    public static int powerOf2(int n)
    {
        int i=1;
        while(i*2<=n)
            i=i*2;
        
        return i;
    }
    public static int solution(int n)
    {
        //write your code here
        int p=powerOf2(n);
        int l=n-p;
        
        return 2*l+1;
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
}