/*698. Partition to K Equal Sum Subsets - Java Solutions
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
*/

/*
------------Recursive Solution Choice Algorithm (Imp)-------------------

Calculate target sum and check for subsets summing to the target sum

TC - O(2^k*n)
SC - O(k*n)
*/

class PartitionKEualSumSubsets {
    
    public boolean canPartitionKSubsets(int[] a, int k) {
        
        int vis[] = new int[a.length];
        int index = 0;
        int targetSum = 0;
        
        for(int i = 0; i < a.length; i++)
            targetSum += a[i];
        
        if(targetSum % k != 0)
            return false;
        
        targetSum /= k;
        
        return util(a, index, 0, targetSum, 0, vis, k);
        
    }
    
    private boolean util(int a[], int index, int currSum, int targetSum, int subsetCount, int vis[], int k) {
        
        if(subsetCount == k + 1) {
            return true;
        }

        
        if(currSum == targetSum) {
            return util(a, 0, 0, targetSum, subsetCount + 1, vis, k);
        }
         
        if(currSum > targetSum) {
            return false;
        }
        
        if(index >= a.length)
            return false;
            
        if(vis[index] == 1) {
            return util(a, index + 1, currSum, targetSum, subsetCount, vis, k);  
        } 
        else {
            
            currSum += a[index];
            vis[index] = 1;
            boolean op1 = util(a, index + 1, currSum, subsetCount, targetSum, vis, k);
                
            currSum -= a[index];
            vis[index] = 0;
            boolean op2 = util(a, index + 1, currSum, subsetCount, targetSum, vis, k);
            
            return op1 || op2;
            
        }
            
    }
    
}