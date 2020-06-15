/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
*/

class Solution {
    public int uniquePaths(int m, int n) {

        // we take a 2d array for a grid representation and then we can compute how many step does it need to take to move from one block to another.
        int[][] dp = new int[m+1][n+1];

        // if we go completely side ways (move right only)..then there is only one way to move tp blocks thus we mark it one and it becomes our base case
        for(int i=0 ; i<m ; i++)
        {
            dp[i][0] = 1;
        }

        // if we go completely downwards (move down only)..then there is only one way to move to blocks thus we mark it one and it becomes our base case
        for(int i=0 ; i<n ; i++)
        {
            dp[0][i] = 1;
        }

        // to get to a new block we can go either right or down. so there are two cases. so if you are at a block you might have come from above or from the left. so sum of those two possibilities are our total ways to reach the new block
        for(int i=1 ; i<m ; i++)
        {
            for(int j=1 ; j<n ; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        // return the bottom right corner
        return dp[m-1][n-1];

    }
}
