/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.

Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/


class Solution {

    public int rob(int[] nums) {


      /*

      If there are n houses numbered 1 to n
      Consider 1st subproblem: Rob houses numbered 1 to n-1 (leaving the nth house).
      Consider 2nd subproblem: Rob houses numbered 2 to n(leaving the 1st house).
      Final answer comes out to be MAXIMUM(1st Subproblem , 2nd Subproblem).
      In the solution we basically used House Robber I problem Solution as a subroutine.

      */

        if(nums.length == 0 )
        {
            return 0 ;
        }

        int nums2[] = new int[nums.length-1];
        int nums1[] = new int[nums.length-1];


        for (int i=1,j=0; i<nums.length; i++,j++)
        {
            nums2[j] = nums[i];
        }


        for(int i=0 ; i<nums.length-1 ; i++)
        {
            nums1[i] = nums[i];
        }

        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];


        if(nums.length == 1)
        {
            return nums[0];
        }
        else if(nums.length == 2)
        {
            return Math.max(nums[0],nums[1]);
        }

        dp1[0] = nums1[0];
        dp2[0] = nums2[0];

        dp1[1] = Math.max(nums1[0],nums1[1]);
        dp2[1] = Math.max(nums2[0],nums2[1]);


        for(int i=2 ; i<nums.length-1 ; i++)
        {
            dp1[i] = Math.max(nums1[i]+dp1[i-2] , dp1[i-1]);
            dp2[i] = Math.max(nums2[i]+dp2[i-2] , dp2[i-1]);
        }


        return Math.max(dp1[nums1.length-1] ,dp2[nums2.length-1] );


    }
}
