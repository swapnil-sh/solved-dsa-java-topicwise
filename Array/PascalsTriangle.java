/*118. Pascal's Triangle - Leetcode Java Solutions*/


/*
------------------------------Iterative Solution------------------------------

Time complexity : O(n^2)
Space Complexity : O(n^2) (for storing res)

*/

class PascalsTriangle
{
    public List<List<Integer>> generate(int n)
    {
    
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> f = new ArrayList<Integer>();
        ArrayList<Integer> s = new ArrayList<Integer>();
        
        f.add(1);
        s.add(1);
        s.add(1);
        
        if(n == 0)
            return res;
        
        if(n==1)
        {
            res.add(f);
            return res;
        }
        if(n==2)
        {
            res.add(f);
            res.add(s);
            return res;
        }

        res.add(f);
        res.add(s);
        
        int i;
        for(i=2;i<n;i++)
        {
            res.add(getithRow(res.get(i-1)));
        }
        
        return res;
    }
    
    public List<Integer> getithRow(List<Integer> prev)
    {
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        
        int i;
        for(i=1; i<prev.size(); i++)
            curr.add(prev.get(i-1)+prev.get(i));
        
        curr.add(1);
        return curr;
    }
}


/*
------------------------------Recursive Solution------------------------------

Time complexity : O(n^2)
Space Complexity : O(n^2) (for storing res)

*/


/*

class Solution 
{
    public List<List<Integer>> generate(int n)
    {
    
        if(n==0) 
            return new ArrayList();
        
        if(n==1)
        {
            List<List<Integer>> list = new ArrayList();
            list.add(Arrays.asList(1));
            return list;
        }
        
        int prevRowNum = n-1;
        
        List<List<Integer>> list = generate(prevRowNum);
        List<Integer> prev = list.get(prevRowNum - 1);
        List<Integer> curr = new ArrayList();
        
        for(int i=0;i<n;i++)
        {
            if(i==0 || i==prevRowNum) 
                curr.add(1);
            else 
                curr.add(prev.get(i-1) + prev.get(i));
        }
        
        list.add(curr);
        return list;
    }
}
*/