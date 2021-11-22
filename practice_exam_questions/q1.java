import java.util.*;

public class q1 {

    // Given an array of n distinct positive integers and some integer S, find the 
    // number of undordered pairs of indices {i, j} such that i != j and A[i] + A[j] > S. 
    public static int getPairs (int[] nums, int target) {
        int total = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                int smallestIdx = getSmallestIdx(nums, nums[i], target);
                total += nums.length - smallestIdx;
            }
        }
        return total;
    }

    // search right to find the smallest j > i s.t. nums[i] + nums[j] > S.
    public static int getSmallestIdx (int[] nums, int i, int target) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] > target) {
                return j;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] testArr = {2, 4, 1, 3};
        System.out.println(getPairs(testArr, 4));
    }
}





