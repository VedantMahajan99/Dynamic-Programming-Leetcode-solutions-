/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // boolean array which will mark the index true when a match is found in dictionary
        boolean[] marked = new boolean[s.length()+1];

        // base case
        marked[0] = true;

        // first loop iterates through array marked
        // second loop picks up substrings and checks for it match in dictionary. if match is found , the index at which the word ends (which was found in dict) is marked true
        // conditions --> marked[j] && wordDict.contains(s.substring(j, i)) --> e.g : "catand" dict = [cat,and]...suppose cat is found and third index is marked true..now to find and iteration again starts from beginning and if condition will become true when marked[3] is true and substring 3 onwards (i.e. is present in dictionary...after both cond are satisfied marked[6] will be marked true and true will be returned as the answer)
        for(int i=1 ; i <= s.length() ; i++ )
        {
            for(int j=0 ; j<i ; j++)
            {
                if(marked[j] && wordDict.contains(s.substring(j, i)))
                {
                    marked[i] = true;
                    break;
                }
            }
        }

        //returns true if everything was found
        return marked[s.length()];
    }
}
