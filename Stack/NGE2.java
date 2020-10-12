/*503. Next Greater Element II - Leetcode Java Solution using Stack*/

class NGE2
{
    public int[] nextGreaterElements(int[] nums) 
    {
        int n=nums.length;
        int res[]=new int[n];
        int i;
        
        for(i=0;i<n;i++)
            res[i]=-1;
        
        Stack<Integer> st=new Stack<Integer>();
        
        for(i=0;i<2*n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n])
                res[st.pop()]=nums[i%n];
            
            if(i<n)
                st.push(i);
        }
        
        return res;
        
    }
}
