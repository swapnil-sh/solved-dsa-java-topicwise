//162. Find Peak Element - Leetcode and GeeksforGeeks Binary Search on Answer Java Solution



// { Driver Code Starts
import java.util.*;
class PeakElement
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
		
			int A=new Peak().peakElement(a,n);
			int f=0;
			if(n==1)
			f=1;
			else
			if(A==0 && a[0]>=a[1])
			f=1;
			else if(A==n-1 && a[n-1]>=a[n-2])
			f=1;
			else if(a[A] >=a[A+1] && a[A]>= a[A-1])
			f=1;
			else
			f=0;
			System.out.println(f);
		}
	}
}// } Driver Code Ends


/*Complete the function below*/

class Peak
{
	// Function to find the peak element
	// a[]: input array
	// n: size of array a[]
	public int peakElement(int[] a,int n)
    {
       //add code here.
       
        if(n==1)
            return 0;
        int st=0,end=n-1;
        
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(mid>0 && mid<n-1)
            {
                if(a[mid]>=a[mid+1] && a[mid]>=a[mid-1])
                {
                    return mid;
                }
                
                else if(a[mid-1]>a[mid])
                    end=mid-1;
                else
                    st=mid+1;
            }
            
            else if(mid==0)
            {
                if(a[0]>a[1])
                    return 0;
                else
                    return 1;
            }
            
            else if(mid==n-1)
            {
                if(a[n-1]>a[n-2])
                    return n-1;
                else
                    return n-2;
            }
        }
        
        return -1;
    }
}
