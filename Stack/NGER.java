/*496. Next Greater Element I - Leetcode Java Solution*/


/*
------------------------------Using Stack and HashMap-------------------------------
TC - O(a.length)+O(b.length)
SC - O(a.length)+O(b.length)
*/
class NGER{
    
    int[] NGEUtil(int a[]){
        
        int nge[]=new int[a.length];
        Stack<Integer> st=new Stack<>();
        
        int i;
        nge[a.length-1]=-1;
        st.push(a[a.length-1]);
        
        for(i=a.length-2;i>=0;i--){
            
            while(!st.isEmpty() && st.peek()<=a[i])
                st.pop();
            
            if(!st.isEmpty())
                nge[i]=st.peek();
            else
                nge[i]=-1;
            
            st.push(a[i]);
        }
        
        return nge;
    }
    public int[] nextGreaterElement(int[] a, int[] b){
        
        
        int res[]=new int[a.length];
        int nge[]=NGEUtil(b);
        HashMap<Integer, Integer> hm=new HashMap<>();
        
        int i;
        for(i=0;i<b.length;i++)
                hm.put(b[i], i);
    
        for(i=0;i<a.length;i++)
            res[i]=nge[hm.get(a[i])];
        
        return res;
    }
}


/*

----------------------10 Line Solution Same Logic-----------------------------

public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
*/