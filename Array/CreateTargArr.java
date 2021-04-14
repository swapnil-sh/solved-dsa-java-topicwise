/*1389. Create Target Array in the Given Order - Leetcode Java Solution*/

class CreateTargArr
{
    public int[] createTargetArray(int[] nums, int[] index)
    {
        int[] res = new int[nums.length];
        int i,j;
        
        for(i=0;i<nums.length;i++)
        {
            for(j=nums.length-1;j>index[i];j--)
                res[j]=res[j-1];
        
            res[index[i]]=nums[i];
        }
    
        return res;
    }
}

/*
class Solution 
{
    public int[] createTargetArray(int[] nums, int[] index)
    {
        int [] output = new int[nums.length];
        // create a list to store nums to corresponding index
        List<Integer> store = new ArrayList<>();
        
        for (int i=0; i<nums.length; i++)
            store.add(index[i], nums[i]);   // O(n^2) as adding to list take O(n) * we are doing it n times. So O(n * n)
        // now for the respective index, store the corresponding value from the list
        for (int i=0; i<nums.length; i++) 
            output[i] = store.get(i);
        
        return output;
    }
}
*/