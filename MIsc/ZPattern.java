//Print Z In Java - Pep Coding

import java.util.*;

public class ZPattern 
{
    public static void main(String[] args)
    {
        
        for(int i=1;i<=5;i++)
        {
            if(i==1 || i==5)
            {
                System.out.println("*****");
            }
            else
            {
                for(int j=1;j<=5-i-1;j++)
                {
                    System.out.print(" ");
                }
                System.out.println(" *");
                
         }
            
     }
}
