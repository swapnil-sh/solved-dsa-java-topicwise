/*Minimum Platforms - GeeksforGeeks Java Solutions */

/*
--------------------Greedy Method---------------------------

Expected Time Complexity: O(nLogn)
Expected Auxiliary Space: O(1)
*/

class MinPlatforms
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        int i=1,j=0,res=1,pt=1;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        while(i<n && j<n)
        {
            if(arr[i]>dep[j])
            {
                j++;
                pt--;
            }
            else
            {
                i++;
                pt++;
            }
            
            res=Math.max(res, pt);
        }
        
        return res;
        
    }
    
}


/*
----------------------------Brute Force--------------------------------------------

Expected Time Complexity: O(n^2)
Expected Auxiliary Space: O(1)
*/

/*
int findPlatform(int arr[], int dep[], int n) 
{ 
  
    // plat_needed indicates number of platforms 
    // needed at a time 
    int plat_needed = 1, result = 1; 
    int i = 1, j = 0; 
  
    // run a nested  loop to find overlap 
    for (int i = 0; i < n; i++) { 
        // minimum platform 
        plat_needed = 1; 
  
        for (int j = i + 1; j < n; j++) { 
            // check for overlap 
            if ((arr[i] >= arr[j] && arr[i] <= dep[j]) ||  
           (arr[j] >= arr[i] && arr[j] <= dep[i])) 
                plat_needed++; 
        } 
  
        // update result 
        result = max(result, plat_needed); 
    } 
  
    return result; 
} 
*/