/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 
Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
*/


class Solution {
    public int rob(int[] nums) {

        // this array will hold the sum for subproblems
        int[] dp = new int[nums.length];

        // no house to rob --> no cash
        if(nums.length == 0 )
        {
            return 0 ;
        }
        // only one house to rob --> cash at that house
        else if(nums.length == 1)
        {
            return nums[0];
        }
        // two adjacent houses --> rob the one with higher cash
        else if(nums.length == 2)
        {
            return Math.max(nums[0],nums[1]);
        }

        // first subproblem is that there is only one house to rob
        dp[0] = nums[0];

        // second sub problem is that there are two houses  --> rob the one with higher cash
        dp[1] = Math.max(nums[0],nums[1]);

        // we countinue solving subproblems i.e 3 houses , then 4 until we reach the length of our actual problem.
        for(int i=2 ; i<nums.length ; i++)
        {
            dp[i] = Math.max(nums[i]+dp[i-2] , dp[i-1]);
        }

        // return result of the actual problem.
        return dp[nums.length-1];

    }
}
