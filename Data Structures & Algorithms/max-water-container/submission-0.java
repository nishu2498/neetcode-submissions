class Solution {
    public int maxArea(int[] heights) {
        
        // we are going to use the 2 pointer solution and we will try to see what is the optimal container we can make
        // we can have left and right pointer located at first and last positions, the idea
        // is both pointers are going to come towards each other and we are going to consider the min height of two pillars, for area calculation
        // keep a max area as well
    
        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int area = Math.min(heights[left], heights[right]) * width;
            max = Math.max(max, area);

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
