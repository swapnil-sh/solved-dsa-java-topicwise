/*914. X of a Kind in a Deck of Cards - Leetcode Java Solution*/

/*
------------------Using Hashing tech-----------------------


Time Complexity: O(Nlog^⁡2N), where N is the number of votes. 
If there are CiC_iCi​ cards with number i, then each gcd operation is naively O(log⁡2Ci)O(\log^2 C_i)O(log2Ci​). 
Better bounds exist, but are outside the scope of this article to develop.

Space Complexity: O(N). 
*/

class DeckOfCardsGCD{
    public boolean hasGroupsSizeX(int[] a) {
        
        if(a.length==0 || a.length==1)
            return false;
        
        int[] count = new int[10000];       
        for(int i=0; i<a.length; i++)
        	count[a[i]]++;      	       	
        
        int res=count[0]; 
        for(int i=1;i<count.length;i++)        	
                res=gcd(count[i], res); 
        
        if(res<2)
        	return false;
             
        return true;
    }
    public int gcd(int a, int b){
        
        if(a==0)
            return b;
        
        return gcd(b%a, a);
    }
}