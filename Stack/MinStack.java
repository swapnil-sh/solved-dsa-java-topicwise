//Special Stack GeeksforGeeks (MinStack) O(1) Solution

import java.util.Scanner;
import java.util.Stack;
class MinStack
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}


class GfG
{
    	int minElement = 0;
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    
	    if(s.size()==0)
	    {
	        s.push(a);
	        minElement = a;
	        return;
	    }
	    
	    else
	    {
    	   if(a<minElement)
    	   {
    	        s.push(2*a-minElement);
    	        minElement = a;
    	   }
    	   else
    	   {
    	       s.push(a);
    	   }
	    }
	}
	public int pop(Stack<Integer> s)
    {
            //add code here.
            if(s.size()==0)
                return -1;
            else
            {
                if(s.peek()>=minElement)
                {
                    return s.pop();
                }
                else
                {
                    minElement = 2*minElement - s.peek();
                    return s.pop();
                }
                
            }
	}
	public int min(Stack<Integer> s)
    {
           //add code here.
           if(s.size()==0)
                return -1;
            return minElement;
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
           //add code here.
           if(s.size()==n)
                return true;
            return false;
	}
	public boolean isEmpty(Stack<Integer>s)
    {
           //add code here.
           if(s.size()==0)
                return true;
            return false;
	}
}
