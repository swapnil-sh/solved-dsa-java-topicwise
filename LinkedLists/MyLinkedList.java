/*707. Design Linked List - Leetcode Java Solution*/


class MyLinkedList 
{

    /** Initialize your data structure here. */
    class Node
    {
        int val;
        Node next;
        public Node(int val) 
        {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList()
    {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) 
    {
        if(index<0 || index>=size)
            return -1;
        
        if(size==1)
            return head.val;
        
        Node curr=head;
        int i;
        for(i=0;i<index;i++)
            curr = curr.next;
        
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val)
    {
        if(head==null) 
            head = new Node(val); 
        else
        {
            Node temp=new Node(val);
            temp.next=head;
            head=temp;
        }
        
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val)
    {
        Node temp=new Node(val);
        size++;
        
        if(head==null)
            head=temp;
        
        Node curr=head;
        while(curr.next!=null)
            curr=curr.next;
        
        
        curr.next=temp;

    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val)
    {
        if(index>size) 
        {
            return;
        }

        if(index<=0)
        {
            addAtHead(val);
        }
        else if(index==size)
        {
            addAtTail(val);
        } 
        
        else
        {
        
            Node temp=new Node(val);
            Node curr=head;
            int i;
            for(i=0;i<index-1;i++)
            {
                curr=curr.next;
            }

            temp.next=curr.next;
            curr.next=temp;

            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index)
    {
        if (index < 0 || index >= size)
            return;
        
        size--;
        if (index==0) 
        {
            head = head.next;
            return;
        }
        
        Node curr=head;
        int i;
        for(i=0;i<index-1;i++)
            curr=curr.next;
        
        curr.next=curr.next.next;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
