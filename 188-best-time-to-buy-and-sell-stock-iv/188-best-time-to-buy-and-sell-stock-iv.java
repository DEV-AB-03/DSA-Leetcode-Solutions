class Solution {
public int maxProfit(int x, int[] a) {
int i,j,k,n=a.length;
int dp[][][] = new int[n][2][x+1]; //3d dp array
for(i=0;i<n;i++)
{
for(j=0;j<2;j++)
{
for(k=0;k<x+1;k++)
{
dp[i][j][k]=-1;
}
}
}

	int ans = func(0, 1, x, a, dp);
    return ans;
}
public static int func(int index, int buy, int cap, int a[], int dp[][][])
{
//base case 1
if(cap==0)//if we have performed atmost 2 transactions, then return 0 bcoz we won't be able to perform any more transactions
return 0;
//base case 2
if(index==a.length)
return 0; //because at index==a.length there is no stock, so no profit, so return 0

    //memoization
    if(dp[index][buy][cap]!=-1)
    return dp[index][buy][cap];
    
    //pick-notPick concept 
    int profit=0;
    if(buy==1) //this means we can pick/buy the current index element
    {
        profit = Math.max( /*pick*/-a[index] + func(index+1, 0, cap, a, dp),/*notPick*/ 0 + func(index+1, 1, cap, a, dp) );
    }
    
    else  //sell case 
    {
        profit = Math.max( a[index] + func(index+1, 1, cap-1, a, dp)/*sell*/ , 0 + func(index+1, 0, cap, a, dp) /*notSell */);
    }
    
    return dp[index][buy][cap] = profit;
}
}