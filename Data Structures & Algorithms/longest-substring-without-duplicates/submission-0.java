/**
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * A substring is a contiguous sequence of characters within a string.
 * 
 * eg: s = "zxyzxyz"
 * output: 3
 * explanation: The string "xyz" is the longest without duplicate characters.
 * 
 * s = "xxxx"
 * output: 1
 * 
 * Bruteforce approach:
 * suppose S = abatman
 * the most basic idea is we can take this input and take every single
 * substring that is possible and then check on all of those substrings
 * that there are any repeating characters or not and whichever the
 * substring with the longest length that will be our answer.
 * 
 * Lets start from this a,
 * so substrings possible from a are: a, ab, aba, abat, abatm, abatma,
 * abatman , similarly we can take b, then ba, bat, batm, batma, batman and so on.
 * the longest substring without repeating characters is batm of length 4.
 * the time complexity of this approach is O(n^3) as we are taking every
 * substring and checking for repeating characters in that substring.
 * 
 * Better approach:
 * We are going to use the sliding window technique to solve this problem.
 * we are going to have 2 pointers as left and right, we are going to
 * follow a property between those 2 pointers is that the substring
 * between those 2 pointers should not have any repeating characters.
 * At any moment if we find a repeating character, we are going to move 
 * the left pointer to the right until we have a substring without
 * repeating characters.
 * 
 * eg:
 * for S = "abatman"
 * we will start with left and right pointer at 0, we will keep moving
 * the right pointer until we find a repeating character.
 * answer variable will keep track of the maximum length of substring 
 * without repeating characters so far.
 * so left = 0, right = 0, substring = "a", ans = 1 move
 * right pointer, left = 0, right = 1, substring = "ab", ans = 2, move
 * right pointer, left = 0, right = 2, substring = "aba", we found a
 * repeating character
 * 
 * so we are going to have a visited hashset to keep track of the 
 * characters that we have seen so far between the left and right
 * pointer and we are going to keep on adding until the point we find
 * a repeating character
 * 
 * so far the hashset would contain a, b, and when r pointer comes at a
 * we will check if a is present in the hashset, it is present, so we are
 * going to remove a from the hashset and move the left pointer towards
 * right, so left = 1, right = 2, substring = "ba", ans = 2 move right and add a to the hashset and pointer, left = 1, right = 3, substring = "bat", ans = 3 move right and add t to the hashset, left = 1, right = 4,
 * substring = "batm", ans = 4 move right and add m to the hashset, left = 1, right = 5, substring = "batma", we found a repeating character by checking with the hashset, so we are going to remove b from the hashset, and move left pointer to the right, left = 2, right = 5, substring = "atma",ans = 4 we found a repeating character by checking with the hashset, so we are going to remove a from the hashset, and move left pointer to the right, left = 3, right = 5, substring = "tma", ans = 4,
 * now there is no repeating character, so we will add the a character to the hashset and move right pointer ahead, left = 3, right = 6, substring
 * = "tman", ans = 4 we add that n in the hashset and move right pointer ahead,now we have reached the end of string, so we will
 * return the answer variable which is 4.
 * 
 * Time complexity : O(n) as we are traversing the string only once.
 * Space complexity: O(n) as we are using a hashset to keep track of the 
 * characters that we have seen so far.
 * Leetcode_Longest_substring_without_repeating_characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // lets first check some edge cases, if length of string is 0 or 1
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        // lets initialize left and right pointers
        int left = 0;
        int right = 0;
        int answer = 0;

        // Lets initialize a hashset of characters to store it from string
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            // lets check if it exists in hashset
            while(set.contains(c)) {
                // if the character is present, then we are going to remove
                // the character at left pointer from the hashset and move
                // the left pointer towards right
                set.remove(s.charAt(left));
                left++;
            }
            // else if value does not exist in the hashset, then we are
            // going to add that character to the hashset and move the right
            // pointer and also update the answer with max value of right-left
            set.add(c);
            answer = Math.max(answer, right-left+1);
            right++;
        }

        return answer;
    }
}
