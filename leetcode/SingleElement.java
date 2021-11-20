class SingleElement {
    
    // binary search strategy
    public int singleNonDuplicate(int[] nums) {
        int mid = nums.length / 2;
        int right = nums.length;
        int left = 0;
        
        // check length 1
        if (nums.length == 1) {
            return nums[0];
        }
        
        // check edge cases
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        
        while (left <= right) {
            mid = (right + left) / 2;
            // Found condition
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            
            // Go left
            if ((mid % 2 != 0 && nums[mid] == nums[mid + 1]) || 
                (mid % 2 == 0 && nums[mid] == nums[mid - 1])) {
                right = mid - 1;
            }
            
            // Go right
            if ((mid % 2 != 0 && nums[mid - 1] == nums[mid]) || 
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                left = mid + 1;
            }
        }
        return 0;
    }
}


// [1, 1, 2, 2, 3, 4, 4, 5, 5]
