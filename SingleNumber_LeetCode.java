class Solution {
    public int singleNumber(int[] nums) {
        
        
        int i,a=0;
        for(i=0;i<nums.length;i++)
        {
            a=a^nums[i];
            System.out.println(a);
        }
        return a;
    }
}
