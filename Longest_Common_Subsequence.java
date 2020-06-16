/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.

*/


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // converting both the string to arrays for the ease of use

        int[] t1 = new int[text1.length() + 1];

        for(int i=0 , j=1 ; i<text1.length() ; i++,j++)
        {
            t1[j] = Character.getNumericValue(text1.charAt(i));
        }

        int[] t2 = new int[text2.length() + 1];

        for(int i=0 , j=1 ; i<text2.length() ; i++,j++)
        {
            t2[j] = Character.getNumericValue(text2.charAt(i));
        }

        // we will save results of subproblems in the 2d array.
        // if we are on a certain character and it matches that means the length will be 1 + length of subsequence until previous characters.
        // if the characters dont math then we have go one character behind and check for longest subsequence until that point

        int temp[][] = new int[text1.length() + 1][text2.length() + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){

                if(t1[i] == t2[j]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];  // will store sequence of max length
                }
            }
        }
        return max;


    }
}
