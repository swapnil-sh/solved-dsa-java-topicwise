/* Middle of Three - GeeksforGeeks Java Solutions*/


class MiddleOf3
{
    int middle(int A, int B, int C)
    {
        //code here
        if((A-B)*(A-C)<0) 
            return A;
        else if((B-A)*(B-C)<0) 
            return B;
        else 
            return C;
    }
}

/*
class Solution
{
    int middle(int A, int B, int C)
    {
        //code here
        int a = Math.max(A,B);
        int b = Math.min(A,B);
        a = Math.max(a, C);
        b = Math.min(b , C);
        
        return (A+B+C) - a - b;
    }
}
*/