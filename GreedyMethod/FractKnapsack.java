/* Fractional Knapsack - GeeksforGeeks Java Solution*/

/*
--------------------Using Greedy Method--------------

TC - O(nlogn)
SC - O(1)
*/


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class MySort implements Comparator<Item>
{
    public int compare(Item a,Item b)
    {
        if((double)b.value/b.weight>(double)a.value/a.weight)
            return 1;
        else if((double)b.value/b.weight==(double)a.value/a.weight)
            return 0;
        else 
            return -1;
    }
}
class FractKnapsack
{
    double fractionalKnapsack(int W, Item a[], int n) 
    {
        // Your code here
        double res=0.0;
        Arrays.sort(a,new MySort());
        int i,curr_max_cap=W;
        
        
        // for(i=0;i<n;i++)
        // {
        //     System.out.println(a[i].value + " " + a[i].weight);
        // }
        for(i=0;i<n;i++)
        {
            if(a[i].weight<curr_max_cap)
            {
                curr_max_cap=curr_max_cap-a[i].weight;
                res=res+a[i].value;
            }
            else
            {
                res=res+(double)curr_max_cap*a[i].value/a[i].weight;
                break;
            }
            
        }
        return res;
    }
}