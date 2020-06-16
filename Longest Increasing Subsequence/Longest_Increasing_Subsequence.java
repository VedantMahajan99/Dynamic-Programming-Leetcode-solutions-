/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*/

class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0 )
        {
            return 0;
        }

        // will store results for subproblem in this
        int[] dp = new int[nums.length];

        // base case is one as minimum sequence of anything is 1
        Arrays.fill(dp, 1);

        // there will be two loops . the second one will iterate till the first one and find increasing subsequences up untill that point.
        // if the number is less than the last element in that loop then it is increasing subsequence and max subsequence is 1 + subsequence up untill that point
        for(int i=1 ; i<nums.length ; i++)
        {
            for(int j=0 ; j<i ; j++)
            {
                if(nums[i]>nums[j] && dp[i] < dp[j]+1)
                {
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max=0;

        for (int i = 0; i < nums.length; i++ )
        {
            if ( max < dp[i] )
            {
                max = dp[i];
            }

        }


            return max;

    }
}
