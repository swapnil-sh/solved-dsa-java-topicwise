/*160. Intersection of Two Linked Lists - Leetcode Two Pointer Java Solution*/

/*-------------------------Second Optimal Java Solution-------------------------

1. Start traversing both the lists simultaneously and stop soon as we find the same node.
2. The moment any of the pointers reaches null, shift that pointer to the head of other linked list.
3. Start Traversing again and keep moving till both of the pointers collide.

Time Complexity : O (2M)
Space Complexity : O (1)

*/

public class IntersecOfLL
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode cur1=headA;
        ListNode cur2=headB;
        
        while(cur1!=null&&cur2!=null)
        {
            if(cur1==cur2)
                return cur1;
            
            cur1=cur1.next;
            cur2=cur2.next;
            
            if(cur1==null)
                cur1=headB;
            
            else if(cur2==null)
                cur2=headA;
            
        }
        
        return null;
    }
}



/*-------------------------First Optimal Java Solution-------------------------

1. Calculate length of both lists.
2. The list which have a bigger length, traverse till (l1-l2) steps.
3. Start traversing both the lists simultaneously and stop soon as we find the same node.

Time Complexity : O (2M)
Space Complexity : O (1)

*/

/*
public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        ListNode currA = headA, currB = headB;
        
        if (lenA>lenB)
            currA = moveHead(headA, lenA-lenB);
        else if (lenA<lenB) 
            currB = moveHead(headB, lenB-lenA);
        
        
       return compare(currA, currB);        
    }
    
    private ListNode compare(ListNode a, ListNode b)
    {
        while(a!=b) 
        {
            a = a.next;
            b = b.next;
        }
        
        return a;
    }
    
    private int getLength(ListNode node) 
    {
         int len = 0;
         while(node!=null) 
         {
             len++;
             node = node.next;
         }
        
         return len;
    }
    
    private ListNode moveHead(ListNode node, int k) 
    {
        while(k>0)  
        {
            node = node.next;
            k--;
        }
        
        return node;
    }
}
*/

/*-------------------------HashSet Java Solution-------------------------

Traverse List A and store every node in the HashSet.
Traverse List B and for every node, check if it exists in the HashSet.
Return the first such node. Else return null.

TC - O(n+m)
SC - O(n)

*/

/*
public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while(curr1!=null)
        {
            hs.add(curr1);
            curr1 = curr1.next;
        }
        while(curr2!=null)
        {
            if(hs.contains(curr2))
            {
                return curr2;
            }
            curr2 = curr2.next;
        }
        return null;
    }
}
*/

/*-------------------------Brute Force Java Solution-------------------------

For every node in the List A, traverse the entire List B.
Return the node if the nodes from List A and List B are equal.
Else return null.

Time Complexity : O (M * N)
Space Complexity : O (1)

*/
/*
public class IntersecOfLL
{
    public ListNode getIntersectionNode(ListNode f, ListNode s) 
    {
        for (ListNode a = headA; a != null; a = a.next) 
        {
	    for (ListNode b = headB; b != null; b = b.next) 
            {
		if (a == b) return a;
            }
        }

        return null;
    }
}
*/