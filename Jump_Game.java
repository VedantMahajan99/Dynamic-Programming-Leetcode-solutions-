/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 3 * 10^4
0 <= nums[i][j] <= 10^5

*/

class Solution {
    public boolean canJump(int[] nums) {

        // this will hold the value of index from which we will be able to reach the end
        int lastgoodindex = nums.length-1;


        // iterate through the array from last element. if the index+ value at index is greater than lastgoodindex that means we have enough jump length range to get to the end
        for(int i=nums.length-1 ; i>=0 ; i-- )
        {
            if(i+nums[i]>=lastgoodindex)
            {
                lastgoodindex = i;
            }
        }

        // if we reach the first index that means we can get till the end.
        if(lastgoodindex==0)
        {
            return true ;
        }
        else
        {
            return false;
        }


    }
}
