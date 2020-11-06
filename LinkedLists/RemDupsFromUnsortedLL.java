/* Remove duplicates from an unsorted linked list - GeeksforGeeks Java Solution*/


/*

Use Hashing

We traverse the link list from head to end. 
For every newly encountered element, we check whether it is in the hash table: if yes, we remove it; otherwise we put it in the hash table.

Time Complexity: O(N)
Auxiliary Space: O(N)

*/
/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class RemDupsFromUnsortedLL
{
    // Function to remove duplicates from the given linked list
    public Node removeDuplicates(Node head) 
    {
        
        if(head==null || head.next==null)
            return head;
        
        HashSet<Integer> hs=new HashSet<>(); 
      
        Node curr=head; 
        Node prev=null; 
        while(curr != null) 
        {
            if(hs.contains(curr.data))
                prev.next=curr.next;
            
            else
            {
                hs.add(curr.data);
                prev=curr;
            }
            
            curr=curr.next;
        }
        
        return head;
    }
}


/*
Other Approaches :

METHOD 1 (Using two loops) 
This is the simple way where two loops are used. Outer loop is used to pick the elements one by one and inner loop compares the picked element with rest of the elements. 
Thanks to Gaurav Saxena for his help in writing this code.

Time Complexity: O(n^2)

METHOD 2 (Use Sorting) 
In general, Merge Sort is the best-suited sorting algorithm for sorting linked lists efficiently. 
1) Sort the elements using Merge Sort.O(nLogn) 
2) Remove duplicates in linear time using the algorithm for removing duplicates in sorted Linked List. O(n) 
Please note that this method doesn’t preserve the original order of elements.

Time Complexity: O(nLogn)

*/
