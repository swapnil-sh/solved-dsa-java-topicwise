import java.io.*;


class Node
{
	int x;
	Node next;
}

class Linked
{
	private Node getNewNode(int x)
	{
		Node temp=new Node();
		temp.x=x;
		temp.next=null;
		return temp;
	}
	public Node insert(int x,Node head)
	{
		if(head==null)
		{
			return getNewNode(x);
		}
		
		Node temp=getNewNode(x);
		Node q=head;
		while(q.next!=null)
			q=q.next;
		
		q.next=temp;
		
		return head;
		
	}
	
	public void display(Node head)
	{
		Node q=head;
		while(q!=null)
		{
			System.out.println(q.x);
			q=q.next;
		}
	}
	
}
public class LinkedList
{
	public static void main(String args[])
	{
		Node head=null;
		Linked a=new Linked();
		
		head=a.insert(1,head);
		head=a.insert(2,head);
		head=a.insert(3,head);
		head=a.insert(4,head);
		head=a.insert(5,head);
		
		a.display(head);
		
	}
}

