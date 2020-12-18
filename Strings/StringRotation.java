/*A Program to check if strings are rotations of each other or not - GeeksforGeeks Java Solution*/

import java.io.*;

class StringRotation 
{ 
    
    static boolean isRotation(String str1, String str2) 
    { 
        // There lengths must be same and str2 must be  
        // a substring of str1 concatenated with str1.   
        return (str1.length() == str2.length()) && 
               ((str1 + str1).indexOf(str2) != -1); 
    } 
    
    public static void main (String[] args)throws IOException 
    { 
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine(); 
        String s2=br.readLine(); 
  
        if (isRotation(s1, s2)) 
            System.out.println("Strings are rotations of each other"); 
        else
            System.out.printf("Strings are not rotations of each other"); 
    } 
} 