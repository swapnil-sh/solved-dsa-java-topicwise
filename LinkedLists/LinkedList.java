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
	
	public Node insert(int x,int pos,Node head)
	{
		if(pos==1)
		{
			if(head==null)
			{
				return getNewNode(x);
			}
			Node temp=getNewNode(x);
			temp.next=head;
			head=temp;		
			
			return head;
		}
		
		Node temp=getNewNode(x);
		Node q=head;
		for(int i=1;i<pos-1 && q.next!=null;i++)
		{
			q=q.next;
		}
		
		temp.next=q.next;
		q.next=temp;

		return head;
	}
	
	public Node delete(Node head,int pos)
	{
		if(head==null || head.next==null)
		{
			return null;
		}
		
		if(pos==1)
		{
			head=head.next;
			return head;
		}
		
		Node q=head;
		for(int i=1;i<pos-1 && q!=null;i++)
		{
			q=q.next;
		}
	
		q.next=q.next.next;
		return head;
		
	}
	
	public int sizeOfList(Node head)
	{
		if(head==null)
			return 0;
		
		return sizeOfList(head.next)+1;
	}
	
	public boolean searchNode(Node head,int x)
	{
		if(head==null)
			return false;
		
		if(head.x==x)
			return true;
		
		return searchNode(head.next,x);
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
		
		head=a.insert(1,1,head);
		head=a.insert(2,2,head);
		head=a.insert(3,3,head);
		head=a.insert(5,4,head);
		head=a.insert(4,4,head);
		head=a.insert(0,1,head);
		//head=a.insert(05,2,head);
		//head=a.insert(6,9,head);
		
		head=a.delete(head,1);
		head=a.delete(head,5);
		
		a.display(head);
		
		System.out.println("Size of Linked List = "+a.sizeOfList(head));
		System.out.println("Search = "+a.searchNode(head,2));
		
	
		
	}
}

