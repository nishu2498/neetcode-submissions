/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * e.g nums = [1,1,1,2,2,3], k = 2
 * output: [1,2]
 * 
 * here we see 1 -> 3 times, 2 -> 2 times, 3 -> 1 time
 * so the top 2 frequent elements are 1 and 2
 * 
 * Optimal approach: we can use a hashmap + heap (priority queue) approach
 * 
 * consider nums = [1,3,4,3,4,2,3,4,2,5,4,5,5] k = 3
 * first of we will iterate over this array and we need to find out how many
 * times each character is occuring and depending on that answer we will have to
 * iterate over the list that we create , we have the number of occurrences for
 * each character and then we can conclude this answer. We need to store
 * somewhere how many times each character is occuring, for which we are using
 * hashmap.
 * 
 * based on the above input,this is the hashmap that we can create:
 * value -> occurs
 * 1 -> 1
 * 2 -> 2
 * 3 -> 3
 * 4 -> 4
 * 5 -> 3
 * 
 * now we need to provide top 3 elements, all the distinct values that we have
 * in this hashmap, if we just simply create a sorted array and in the sorted
 * array we sort the array based on the descending values which means the most
 * occuring value to be the first and then we put down all the remaining values
 * sorted array would look like this
 * 4, 3, 5, 2, 1
 * from this sorted array we can return the elements 4, 3, 5 easily.
 * 
 * Time complexity of this approach
 * first we need to iterate over the entire given array input which takes O(n)
 * time to generate this hashmap, after that we will have to create the sorted
 * array that takes nlogn time to generate that answer, thus
 * O(nlogn) will be ultimate time complexity.
 * 
 * The concept of priority queue is we add the values from one end and we remove
 * the value from other end, FIFO
 * 
 * now instead of sorted array that we created, we create a priority queue of
 * whatever size of given k value, we are only going to enter value based on
 * number of occurrences they have and we only keep the higher number of
 * occurrences.
 * 
 * Priority queue = [1,2,3] initially
 * next we have 4, which has greater number of occurrences,
 * we would be replacing the smallest value
 * [4, 2, 3], but we will also maintain the ascending value in terms of
 * occurences
 * [2, 3, 4]
 * next we see 5, which occurs 3 times, which is greater than 2 occurring 2
 * times
 * [5, 3, 4], since 5 and 3 both occur 3 times
 * later convert this result into an array in any manner.
 * Time complexity would be better than other sorted array approach, which is
 * O(nlogk) which is good.
 * Space complexity = O(n) because we are using hashmap and priority queue.
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // first check there is just single element in array, then frequent would be the same element
        if (nums.length == k) {
            return nums;
        }

        // Create a hashmap count
        HashMap<Integer, Integer> count = new HashMap<>();

        // Iterate the array and store the elements in hashmap
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Create a priority queue with storing or method of insertion based on count of hashmap
        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> count.get(a) - count.get(b)
        );

        // iterate over the keys inside the count hashmap that we created and for every
        // single key we are going to add that value to our heap priority queue, and whenever the 
        // priority queue gets full to the size of k, we are going to pop the element, and the element
        // that is going to get popper is the least value

        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // initialize an answer
        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}
