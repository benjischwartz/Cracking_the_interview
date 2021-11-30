class InsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            
            mid = (left + right)/2;
            
            // Found condition
            if (nums[mid] == target) {
                return mid;
            }
            
            // Look left
            if (nums[mid] > target) {
                right = mid - 1;
            }
            
            // Look right
            else {
                left = mid + 1;
            }
        }
        if (target > nums[mid]) {
            return mid + 1;
        }
        else {
            return mid;
        }
    }
}
