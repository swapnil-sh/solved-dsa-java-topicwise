/*Maximum and minimum of an array using minimum number of comparisons - GeeksforGeeks Java Solutions*/



/*
Time Complexity: O(n)

Total number of comparisons: Different for even and odd n, see below: 

       If n is odd:    3*(n-1)/2  
       If n is even:   1 Initial comparison for initializing min and max, 
                           and 3(n-2)/2 comparisons for rest of the elements  
                      =  1 + 3*(n-2)/2 = 3n/2 -2
*/
class MaxMinArr
{
    static void getMinMax(int arr[], int n) 
    {
        int i;
 	int min;
	int max;

        if(n==1) 
	{
            max=arr[0];
            min= rr[0];
            return;
        }
	
	if(n%2==0) 
	{
            if(arr[0]>arr[1]) 
	    {
                max=arr[0];
                min=arr[1];
            } 
	    else 
	    {
                min=arr[0];
                max=arr[1];
            }

            i=2;
            		/* set the starting index for loop */
        } 		/* If array has odd number of elements then  
    					initialize the first element as minimum and  maximum */ 
    	else
	{
            min=arr[0];
            max=arr[0];
            i=1;
	}
     
 
        while(i<n-1) 
	{
	    if(arr[i]>arr[i+1])
	    {
            	if(arr[i]>max) 
                    max=arr[i];
		if(arr[i+1]<min)
		    min=arr[i+1];
            }

            else if(arr[i+1]>arr[i])
	    {
            	if(arr[i+1]>max) 
                    max=arr[i+1];
		if(arr[i]<min)
		    min=arr[i];
            }
	    
	    i=i+2;
        }

        return;
    }
}



/*
Time Complexity: O(n)

In this method, the total number of comparisons is 1 + 2(n-2) in the worst case and 1 + n – 2 in the best case. 
*/

/*
static void getMinMax(int arr[], int n) 
{
        int i;
 	int min;
	int max;

        if(n==1) 
	{
            max=arr[0];
            min= rr[0];
            return;
        }
 
        /* If there are more than one elements, then initialize min 
    and max*/
        if (arr[0]>arr[1]) 
	{
            max=arr[0];
            min=arr[1];
        } 
	else 
	{
            max=arr[1];
            min=arr[0];
        }
 
        for(i=2;i<n;i++) 
	{
            if(arr[i]>max) 
                max=arr[i];

            else if(arr[i]<min) 
                min=arr[i];   
        }
        return;
}
*/