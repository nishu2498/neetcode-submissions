class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for(int start = 0, end = s.length() - 1; start<end; start++, end--) {
            if (s.charAt(start) == s.charAt(end)) {
                continue;
            }
            return false;   
        }
            return true;
    }
}
