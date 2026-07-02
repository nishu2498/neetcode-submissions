class Solution {
    public boolean isAnagram(String s, String t) {

        // If the length of both strings don't match, they are not anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create an int array for 26 english alphabets
        int[] countChar = new int[26];

        // we iterate through the both the strings, with
        // s we increment our int array and with t we decrement
        // our int array as we see each character
        for(int i = 0; i<s.length(); i++) {
            countChar[s.charAt(i)-'a']++;
            countChar[t.charAt(i)-'a']--;
        }

        // Post this we just check if we found at any place value other than 0
        // we return false
        for (int c: countChar) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
