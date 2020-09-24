/*Rotation - Given an ascending sorted rotated array of distinct integers of size N. The array is right rotated K times. Find the value of K - GeeksforGeeks Binary Search Java Soltuion*/

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class FindNoOfRotat {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    int findKRotation(int a[], int n) 
    {
        // code here
        int st=0,end=n-1;
	    while(st<=end)
	    {
	        if(a[st]<=a[end])
	            return st;
	       
	       int mid=st+(end-st)/2;
	       int next=(mid+1)%n;
	       int prev=(mid+n-1)%n;
	       
	       if(a[mid]<=a[next] && a[mid]<=a[prev])
	            return mid;
	       
	       else if(a[mid]<=a[end])
	            end=mid-1;
	       
	       else if(a[mid]>=a[st])
	            st=mid+1;
	    }
	    
	    return 0;
    }
}
