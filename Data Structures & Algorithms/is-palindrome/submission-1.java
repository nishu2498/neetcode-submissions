/**
* Earlier solution was incorrect, since it replaced all letters in string with "", that's not right
* Here we use stringbuilder to create new string, where we append characters of original string to
* to form newString and then compare newStr with the reverse of newStr. or 
* we could do it using normal string as well.
* Best approach is using two pointers on character array created from string
*
*/
class Solution {
    public boolean isPalindrome(String s) {
        // StringBuilder newStr = new StringBuilder();
        // for (char c: s.toCharArray()) {
        //     if (Character.isLetterOrDigit(c)) {
        //         newStr.append(Character.toLowerCase(c));
        //     }
        // }
        // return newStr.toString().equals(newStr.reverse().toString());
        String cleanedString = "";

        for (char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleanedString += Character.toLowerCase(c);
            }
        }

        int left = 0;
        int right = cleanedString.length() - 1;

        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
