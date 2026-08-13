/**
 * You are given a string s consisting of only uppercase english characters and
 * an integer k. You can choose up to k charaters of the string and replace them
 * with any other uppercase English character.
 * After performing at most k replacements, return the length of the longest
 * substring which contains only one distinct character.
 * 
 * input: s = "XYYX", k = 2
 * output: 4
 * explanation: either replace the 'X's with 'Y's or replace the 'Y's with 'X's
 * to get a substring of length 4.
 * 
 * input: s = "AAABABB", k =1
 * output: 5
 * explanation: replace the 'B' with 'A' to get a substring of length 5.
 * 
 * s would be uppercase english characters and k would be a non negative
 * integer.
 * 
 * Bruteforce approach:
 * what we need to find is a substring and then we want to replace the
 * characters in that substring and then we want to find the longest length with
 * the same characters.
 * 
 * we take all the substrings that are possible:
 * in String: ABAB, we could find A, AB, ABA, ABAB, B, BA, BAB, A, AB, B
 * then we start the replace operations on all the substrings and eventually we
 * would find the some substring that will look like AAAA or BBBB and in case we
 * would be able to return the length as 4
 * 
 * we are given this string: S = ABCAD and we are told that we can replace
 * any two characters inside this string S with any other characters
 * we need to find a substring where all the characters contains the same
 * value and because they contains the same value we need to return the length
 * of it
 * 
 * we would find out what is no of occurrences of every single character
 * A -> 2, B -> 1, C -> 1 and D -> 1,our conclusion is to create a substring
 * where all the characters are A , if we do create substring with all the other
 * characters, B, C, D, then we fall short of 1 character, because the value of
 * A appears twice
 * the value of max occurrence of character along with value K and the
 * length of the substring defines that whether any substring we can convert it
 * to all the repeating characters or not
 * in the above case, we have 3 characters to replace, even if we replace any 2
 * characters , no matter what happens we are not able to create a substring
 * where all the five values are actually aaaaa
 * we took the length (here 5) - we subtracted the most occurred character
 * L - A : 5 - 2 = 3 > (greater than k), if this value is greater than value k ,
 * then we cannot do anything about it.
 * if S = ABCA only then A appears 2, B appears 1, C appears 1, in this case the
 * length of this string = 4 len - max occurred value(a), 4 - 2 is
 * 2 , this 2 is actually equal to whatever the value of K is. Because this is
 * equal to K and in this case we can define that for this particular substring
 * we can actually convert it to all the characters being same by using this
 * replace function and if we just replace the value B and C, we will get
 * actually a sequence of aaaa
 * 
 * What all things did we require here:
 * 1 ) current length of subsequence which we are following / length of
 * substring we are doing
 * 2) We need to know what is maximum occurrence of any particular character in
 * any given subsequence
 * 3) we also needed that what is value of K
 * 
 * Valid subsequence is subsequence where the length of the subsequence minus
 * the most occurred character , if this one is actually less than or equal to
 * whatever the value of K is if this is true then we can see that this is a
 * valid substring and the length whatever the length of this particular
 * substring is that is also the length of substring with which contains the
 * most repeated characters
 * 
 * Eg: S = PXQXYXA, k = 2
 * Valid subsequence: Length - max occurrence of character in that particular
 * subsequence and we will see that if that value if less than or
 * equal to k we can treat it as our answer and whatever th
 * e maximum answer we
 * find so far, we will conclude it as our solution
 * valid; l - max <= k
 * we are going to use a sliding window plus 2 pointer solution
 * we will have left and right to be initialized at the first position,
 * we are going to update the right value to the next element then we will check
 * that whether the substring is valid or not , if the substring is valid we
 * will calculate that what is the answer, we will update the answer again, we
 * will move the right value and again we will move the right value again until
 * the point the substring is not valid, we conclude we need to shrink our
 * substring
 * 
 * we can find the length by difference between left pointer and right pointer,
 * maximum occurrence at any given moment of any particular element
 * so we can create an array of size 26 for every single character in the
 * english language and whenever we find any value on the right side we will add
 * that value to our array or if we move any character on the left side we will
 * reduce that value from our array.
 */
class Solution {
    public int characterReplacement(String s, int k) {
        
        // create an integer array to store the occurrence
        int[] occurrence = new int[26];

        int left = 0, right = 0;
        int ans = 0;
        int maxOccurrence = 0;

        // run a for loop on the given string
        for (right = 0; right < s.length(); right++) {
            // we will calculate whether we need to update the maximum occurrence or not
            maxOccurrence = Math.max(maxOccurrence, ++occurrence[s.charAt(right) - 'A']);

            if (right - left + 1 - maxOccurrence > k) {
                // current substring is not valid, we will have to update the value of left variable
                // we need to decrement the value of occurrence of that character, before we move towards right
                occurrence[s.charAt(left) - 'A']--;
                left++;
                
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
