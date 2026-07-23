class Solution {

    public void twoSum2(int[] nums, int i, List<List<Integer>> result) {

        // we initialize two pointers left and right
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            // calculate the sum of i, left and right variables
            int sum = nums[i] + nums[left] + nums[right];

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                // we need to move the value of left pointer till the point adjacent values of left pointer are same or not
                while (left < right && nums[left] == nums[left-1]) {
                    ++left;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        
        // first sort the array
        Arrays.sort(nums);

        // initialize result as list of list
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length && nums[i] <= 0; i++) {

            //  we are going to check for twoSum only in the case that consecutive elements
            // are not equal
            if (i == 0 || nums[i] != nums[i-1]) {
                twoSum2(nums, i, result);
            }
        }

        return result;
    }
}
