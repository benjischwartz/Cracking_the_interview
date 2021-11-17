// Given an array of integers nums sorted in non-decreasing order, 
// find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

class FirstLastPos {
    public int[] searchRange(int[] nums, int target) {
        
        // search for target
        int right = nums.length - 1;
        int left = 0;
        int mid = 0;
        int[] positions = new int[] {-1, -1};
        
        // Check for empty array
        if (nums.length == 0) {
            return positions;
        }
        
        while (left <= right) {
            mid = Math.floorDiv((left + right), 2);
            System.out.print("mid is: ");
            System.out.println(mid);
            // Found condition
            if (nums[mid] == target) {
                
                // explore!!
                int lo = mid;
                int hi = mid;
                while (lo >= 0 && nums[lo] == target) {
                    lo--;
                }
                while (hi < nums.length && nums[hi] == target) {
                    hi++;
                }
                positions[0] = lo + 1;
                positions[1] = hi - 1;
                return positions;                
            }
            
            // Go left
            if (nums[mid] > target) {
                right = mid - 1;
            }
            
            // Go right
            else {
                left = mid + 1;
            }
        }
        
        // Not found
        return positions;
    }
}
