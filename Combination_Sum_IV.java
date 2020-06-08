/*
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
*/

class Solution {
    public int combinationSum4(int[] nums, int target) {


        // this pronlem requires a dp solution so we create anew problem where we will store results for sub problems and then do backtracking

        int[] array = new int[target+1];

        // the target is a positive number so we are setting first sub-problem to 1 as need of the algo

        array[0] = 1;

        // first loop iterates through the array storing result for each sub problem until we reach the target
        // second loop will iterate through the given numbers
        // if the target for which we are computing results (i.e. i) is greater than the number in nums array then we then we compute sum of possible combinations for that target by adding to itself its subproblem (e.g --> in the discussed e.g when we calculate combinations for target 4 we break it into subproblem of target 3 and target 1 and then add it as 3 and 1 were in nums array and we had to use those numbers to sum upto 4).
        // **Note --> when a java array is un-initialised its default values are zero

        for(int i=1 ; i<=target ; i++)
        {
            for(int j=0 ; j<nums.length ; j++)
            {
                if(i-nums[j] >= 0)
                {
                    array[i] = array[i] + array[i-nums[j]];
                }

            }
        }

       return array[target];
    }
}
