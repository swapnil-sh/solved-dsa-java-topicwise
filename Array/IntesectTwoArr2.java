/*350. Intersection of Two Arrays II - Leetcode Java Solutions*/

/*
-----------------------HashMap Solution-----------------


Follow up:

Q1.What if the given array is already sorted? How would you optimize your algorithm?

Ans.The first question is relatively easy, create a hashmap base on number frequency of a(whichever one is longer). 
Then for every element of blook upon the hashmap. If we found an intersection, deduct by 1 to avoid duplicate.

TC - O(N + M) time complexity, O(N) for iterate one of the array to create a hashmap and O(M) to iterate the other array. 
SC - O(N) space to store such hashmap.

*/
class IntesectTwoArr2
{
    public int[] intersect(int[] a, int[] b)
    {
        
        int i=0,j=0;
        ArrayList<Integer> res=new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<a.length;i++)
        {
            if(!hm.containsKey(a[i]))
                hm.put(a[i],1);
            else
                hm.put(a[i],hm.get(a[i])+1);
        }
        
        for(i=0;i<b.length;i++)
        {
            if(hm.containsKey(b[i]) && hm.get(b[i])>0)
            {
                hm.put(b[i],hm.get(b[i])-1);
                res.add(b[i]);
            }
        }
        
        int[] ans=res.stream().mapToInt(x -> x).toArray();  
        
        return ans;
    }
}

/*

-------------------Two Pointer Approach----------------------------
Follow Up:

What if the given array is already sorted? How would you optimize your algorithm?
Classic two pointer iteration, i points to nums1 and j points to nums2. 
Because a sorted array is in ascending order, so if nums1[i] > nums[j], we need to increment j, and vice versa. 
Only when nums1[i] == nums[j], we add it to the result array. Time Complexity O(max(N, M)). Worst case, for example, would be nums1 = {100}, and nums2 = {1, 2, ..., 100 }.
We will always iterate the longest array. The example code is below(I sorted it so it could go through OJ):

TC - O(nlogn)
SC - O(1)
*/

/*
class Solution 
{
    public int[] intersect(int[] a, int[] b)
    {
        
        int i=0,j=0;
        ArrayList<Integer> res=new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        
        while(i<a.length && j<b.length)
        {
            if(a[i]==b[j])
            {
                res.add(a[i]);
                i++;
                j++;
            }
            
            else if(a[i]<b[j])
                i++;
            else
                j++;
        }
        
        int[] ans=res.stream().mapToInt(x -> x).toArray();  
        
        return ans;
    }
}
*/


/*

Follow Up - 

Q1.What if nums1's size is small compared to nums2's size? Which algorithm is better?

Ans.This one is a bit tricky. Let's say nums1 is K size. 
Then we should do binary search for every element in nums1.
Each lookup is O(log N), and if we do K times, we have O(K log N).
If K this is small enough, O(K log N) < O(max(N, M)). Otherwise, we have to use the previous two pointers method.

Q2.What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Ans.This one is open-ended. But Map-Reduce I believe is a good answer.
*/