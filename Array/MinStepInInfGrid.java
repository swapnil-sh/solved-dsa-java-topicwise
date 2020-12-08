/*Min Steps in Infinite Grid - InterviewBit Java Solution*/

/*
TC - O(n)
SC - O(1)
*/

public class MinStepInInfGrid
{
    public int coverPoints(int[] a, int[] b) 
    {
        int steps=0;
        int i;
        for(i=0;i<a.length-1;i++)
            steps+=Math.max(Math.abs(a[i+1]-a[i]),Math.abs(b[i+1]-b[i]));
        
        return steps;
    }
}
