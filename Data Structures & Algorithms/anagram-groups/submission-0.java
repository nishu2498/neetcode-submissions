/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Input: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [["bat"], ["nat","tan"], ["ate", "eat", "tea"]]
 * Leetcode_group_anagrams
 * 
 * One better way to solve this problem is by sorting, we are going to create
 * another array of strings, and for each string in the input array, we will
 * sort the characters in that string and add it to the new array.
 * 
 * S = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * After sorting each string, we will get
 * S' = ["aet", "aet", "ant", "aet", "ant", "abt"]
 * Then we pickup any string from the new array, and compare with the rest of
 * the strings and find that which strings contain the same value, whichever
 * string contains the same value, we will take those values from original
 * string, since we know their index values and then group them together.
 * Time complexity will be O(nlogn) * k , where k is the length of biggest
 * string in the input array that we need to compare with the rest of the
 * strings. Space complexity will be O(n) because we are using another array to
 * store the sorted strings.
 * 
 * Optimal Solution: we will use hashing, hashmap.
 * 
 * Suppose we have an array of 26 characters
 * [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y,
 * z]
 * []
 * initially all the values will be 0, and for each string, in the input array
 * we iterate through the characters and we increment the value to 1
 * 
 * eg: abc, we will increment the value of a, b and c to 1, so the array will
 * look like
 * [1, 1, 1, 0, 0, 0, .....] -> string = 111000000000000000000000
 * similar for value cba, we will increment the values of c, b and a to 1, so
 * the array will look like
 * [1, 1, 1, 0, 0, 0, .....] -> string = 111000000000000000000000
 * 
 * Now we store the string in hashmap, as a key part we will keep our whatever
 * string that we are building from the array of 26 characters, and as a value
 * part of list we will keep the original string from the input array
 * 
 * S = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * hashmap = {
 * "111000000000000000000000" : ["eat", "tea", "ate"],
 * "110100000000000000000000" : ["tan", "nat"],
 * "100010000000000000000000" : ["bat"]}
 * 
 * in the end we will return the values of hashmap as a list of lists.
 * Time complexity will be O(nk) where n is the number of strings in the input
 * array and k is the length of the biggest string in the input array. Space
 * complexity will be O(nk) because we are using a hashmap to store the values
 * and their corresponding original strings.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // If the string is empty, return empty list of list
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Initialize the hashmap to store the anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Initialize an array of 26 characters to store the count of each character
        int[] count = new int[26];

        // Iterate through the strings array
        for (String s: strs) {
            // fill the count array with 0s
            Arrays.fill(count, 0);

            // Iterate through the characters of the string and increment the count
            for (char c: s.toCharArray()) {
                count[c-'a']++;
            }

            // initialize a stringbuilder to build the key for the hashmap
            StringBuilder sb = new StringBuilder("");

            // Iterate through the count array and build the key for hashmap, use the language trick of appending "#"
            // for distinguishing different keys
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString(); // this is key for our hashmap

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s); // add the original string to the list of anagrams for this key
        }

        return new ArrayList<>(map.values()); // return the values of the hashmap as a list of lists
    }
}
