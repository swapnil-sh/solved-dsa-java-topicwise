/*1641. Count Sorted Vowel Strings - Leetcode Java Solution*/

/*
    ["a",                           =1
    "e",                            =1
    "i",                            =1
    "o",                            =1
    "u"]                            =1
------------------------------------------  
				    =5
    
    ["aa","ae","ai","ao","au",      =5
    "ee","ei","eo","eu",            =4
    "ii","io","iu",                 =3
    "oo","ou",                      =2
    "uu"]                           =1  
------------------------------------------  
				    =15   
    
    ["aaa","aae","aai","aao","aau","aee","aei","aeo","aeu","aii","aio","aiu","aoo","aou","auu",     =15
    "eee","eei","eeo","eeu","eii","eio","eiu","eoo","eou","euu",                                    =10
    "iii","iio","iiu","ioo","iou","iuu",                                                            =6
    "ooo","oou","ouu",                                                                              =3
    "uuu"]                                                                                          =1 
-------------------------------------------------------------------------------------------------------------
				    								    =35
       
*/

class CountSortedVowelStrings
{
    public int countVowelStrings(int n) 
    {
        
        int a[]=new int[5];
        int i, j;
        
        for(i=0;i<5;i++)
            a[i]=1;
        
        for(i=0;i<n;i++)
        {
            for(j=1;j<5;j++)
            {
                a[j]=a[j]+a[j-1];
            }
        }
        
        return a[4];
    }
}

