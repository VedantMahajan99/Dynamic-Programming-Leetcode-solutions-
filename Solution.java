class Solution {
    public int coinChange(int[] coins, int amount) {

        // we will break it into subproblems and store how many coins need to make an amount starting from zero..those results are stored              in this array below..

        int[] dp = new int[amount+1];

        // fill array with a number greatr than amount i.e. an unreachable condition

        Arrays.fill(dp, amount+1);

        // amount zero is our first subprob and we need 0 coins for that

        dp[0] = 0;

        // first loop will iterate through the dp array
        // the second loop will iterate through coins
        // it will check for number of coins if the coin towards which the index is pointed is less than the amount for which we are checking.
        // e.g. --> at the beginning  dp will find number of coins for amount 1.
        // suppose coins = [1,2,5] and amount = 11
        // coin to be checked is 1 and amount is 1. so it will go in the if condition. here a comparison is made. current dp[i] is 12 and the second one is computed as 1 coin of that denomination  +                coins used for amount (i.e amount - value of that coin). this              compuation is dependent on another subproblem whose result is              previously stored in array thus maintaing the essence of dynamic            programming.

        for(int i=1 ; i<=amount ;i++)
        {
            for(int j=0 ; j<coins.length ; j++)
            {
                if(coins[j]<=i)
                {
                    dp[i] = Math.min(dp[i] , 1 + dp[i-coins[j]]);
                }
            }
        }

        if(dp[dp.length-1] > amount)
        {
            return -1;
        }
        else
        {
            return dp[dp.length-1];
        }
    }
}
