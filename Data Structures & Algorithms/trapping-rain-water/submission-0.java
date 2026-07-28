/**
 * You are given an array of non-negative integers height which represent
 * an elevation map. Each value height[i] represents the height of a bar,
 * which has a width of 1.
 * 
 * Return the maximum area of water that can be trapped between the bars
 * 
 * eg: height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * output: 6
 * 
 * we need to iterate at every single position, we are going to basically
 * calculate that how much water can be stored due to this height
 * difference, so lets take example between 0 and 1, no water can be stored
 * because there exists a height difference between 1 and 2, we rain falls,
 * we have a height of 1 on left side and on right side we have a bar of
 * height 2, we are creating some sort of value over here, means there
 * exists an empty vaccumm where water can fall in and water can be stored
 * 
 * the formula is simple: on left side there exists some height and right
 * side there exists some height
 * 
 * left height of current position = 1, right height of current position =
 * 2, and the current occupied position height = 0, thus we are only able
 * to store 1 unit of water
 * 
 * At any given moment, the amount of water we can store in one unit is
 * actually following this formula that the minimum of whatever the right
 * height is whatever the left height is, so whatever the lower value of
 * both of these minus the height we are currently at
 * 
 * min(Rh, Lh) - H > 0
 * 
 * so for index = 0, lh = 0, current h = 0, and rh = 1, would be
 * min(rh, lh) - h > 0 = 0 - 0 = 0 > 0 false, we cannot store any units of
 * water and same formula can be applied for all these places to calculate
 * that what is the amount of water we can store,
 * for index = 3, lh = 2, and rh = 1, min(1,2)
 * 
 * Bruteforce: at every single position, we iterate over entire left array
 * and entire right array and we find out what is the maximum left height
 * we can find at any given position, we can also find what is the maximum
 * right height we can find at any given position, and we already know at
 * what height we are currently at and once we have both lh and rh, we
 * would use the formula of min(rh, lh) - currentH > 0
 * time complexity of O(n^2)
 * 
 * Better approach: we can iterate over whatever input array from left side
 * and right side
 * input array: [0,1,0,2,1,0,1,3,2,1,2,1]
 * we will iterate over this array from the left side and at every single
 * position we can see that for any single element, what is the leftmost
 * or leftmax value we can store and similarly we are going to iterate over
 * the input array in reverse order and we can find that at any single
 * position what is the right max value we can find, then we can simply
 * apply this formula on the entire input that at any single position we
 * need to find the minimum value of right max and left max - height we are
 * currently at > 0, min(lh, rh) - H > 0, then we will add it to whatever
 * the output we have and that would be our answer.
 * 
 * Lmax = [0,1,1,2,2,2,2,3,3,3,3,3]
 * Rmax = [3,3,3,3,3,3,3,3,2,2,2,1]
 * 
 * output = min(lh,rh)-h > 0
 * [min(0,3)-0,min(1,3)-1,min(1,3)-0,min(2,3)-2,min(2,3)-1,min(2,3)-0,min(3,3)-1,min(3,2)-3,min(3,2)-2,min(3,2)-1,min(3,2)-2,min(3,2)-1]
 * [0,0,1,0,1,2,2,0,0,1,0,1]
 * Time complexity: O(n), space complexity: O(n)
 * 
 * Optimal solution: based on above lmax array and rmax array
 * Lmax = [0,1,1,2,2,2,2,3,3,3,3,3]
 * Rmax = [3,3,3,3,3,3,3,3,2,2,2,1]
 * and with formula: min(lh, rh) - H > 0,
 * till index 7, where lmax, rmax = 3, the value of lmax < rmax
 * at index 7 it is equal to lmax = rmax
 * after index 7, the value of lmax > rmax
 * 
 * we are going to use two pointer solution here, we are going to have
 * 2 pointers left and right initially located at first and last position
 * and at every single time we are going to check that whatever current
 * element we have whatever height at element left or pointer left and
 * whatever the height at pointer R , we are going to compare these two
 * 
 * if H[l] < H[R] ,first we'll check that whether the current left pointer
 * we are at, does it contain the left max height and we are going to
 * initialize the left max variable to 0 at the beginning and at any point
 * we are going to check that whether we need to update the value of left
 * max -> we are going to check if Lmax: max(lmax,H[l]) we are at, this
 * will make sure that we have updated left max value,then
 * we just need 1 equation: Lmax - height we are currently at of pointer l
 * lmax - Height(l) > 0, we can add it to our total, and once that is done,
 * we need to update our left pointer so we would move towards the right
 * pointer and do left++
 * 
 * if at any point we found out that H(r) < H(l), we are going to repeat
 * the same process
 * rmax:max(rmax,H(r)) current r
 * then we are going to do same process
 * Rmax - Height(r) > 0, add that value to our total variable
 * we will break out of the loop when left is greater than right, whatever
 * value we have stored in total, we could return that
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public int trap(int[] height) {
        
        // lets have two pointers left at start of index and right at the end of array
        int left = 0;
        int right = height.length - 1;
        int total = 0;

        // also lets store left and right max values
        int leftmax = height[0];
        int rightmax = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                leftmax = Math.max(leftmax, height[left]);
                if (leftmax - height[left] > 0) {
                    total = total + leftmax - height[left];
                }
                left++;
            } else {
                rightmax = Math.max(rightmax, height[right]);
                if (rightmax - height[right] > 0) {
                    total = total + rightmax - height[right];
                }
                right--;
            }
        }

        // our total will have the final answer after both case calculations
        return total;
    }
}
