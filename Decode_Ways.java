/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/


class Solution {
    public int numDecodings(String s) {


        //if the length is 0  or if the first character is 0 then there is no way to decode
        if(s.length() == 0 || Character.getNumericValue(s.charAt(0)) == 0)
        {
            return 0;
        }
        // if there is only one element then there is only one way to decode
        else if(s.length() == 1)
        {
            return 1;
        }

        // converting string into array of integers for ease

        int strings[] = new int[s.length()];

        for(int i=0 ; i<s.length() ; i++)
        {
            strings[i] = Character.getNumericValue(s.charAt(i));
        }

        // this array will keep results for sub-problems
        int dp[] = new int[s.length()];

        // first subproblem is if the only one element is given..there is only way to decode it if its not zero
        dp[0] = strings[0] == 0 ? 0:1;

        // second problem is if two elements are given
        if((strings[0]*10 + strings[1]) <=26 && strings[1] != 0)
        {
           dp[1] =  2; // e.g 23 --> (2 , 3) (23)
        }
        else if ((strings[0]*10 + strings[1])>26 && strings[1] == 0)
        {
            dp[1] = 0; // e.g 30
        }
        else
        {
            dp[1] = 1; //e,g 10 --> (10)
        }

        // iterates through dp array and computes results for subproblems
        // its like fibbonaci but with condition dp[i] = condition dp[i-1] + condition dp[i-2]
        for(int i=2 ; i<dp.length ; i++)
        {
            // if the current element is greater than 0
            if(strings[i] >=1)
            {
                dp[i] += dp[i-1];
            }

            // if last two digits are less than 26 and greater than 9..because we cant include 03
            if((strings[i-1]*10 + strings[i]) <=26 && (strings[i-1]*10 + strings[i])>9 )
            {
                    dp[i] += dp[i-2] ;
            }

        }

        return dp[dp.length-1];

    }
}
