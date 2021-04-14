/*341. Flatten Nested List Iterator - Leetcode Java Solution*/


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> fl=null;
    int curr=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        
        fl=new ArrayList<>();
        for(NestedInteger i: nestedList)
            solve(i);
        
    }

    @Override
    public Integer next() {
        
        return fl.get(curr++);
    }
    

    @Override
    public boolean hasNext() {
        
        return curr<fl.size();
        
    }
    
    private void solve(NestedInteger n){
        
        if(n.isInteger())
            fl.add(n.getInteger());
        else{
            
            for(NestedInteger i: n.getList())
                solve(i);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */