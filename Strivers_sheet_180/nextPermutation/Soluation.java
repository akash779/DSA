package Strivers_sheet_180.nextPermutation;
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        // Step 1: Peeche se pehla chota element (breakpoint) dhoondho
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Agar breakpoint mila (yaani poora array descending nahi hai)
        if (i >= 0) {
            // Peeche se wo element dhoondho jo nums[i] se bada ho
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Un dono ko swap kar do
            swap(nums, i, j);
        }

        // Step 3: Breakpoint ke aage wale part ko reverse kar do
        // Agar poora array descending tha (i = -1), toh poora array reverse hokar ascending ban jayega
        reverse(nums, i + 1, nums.length - 1);
    }

    // Helper method: Do elements ko swap karne ke liye
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method: Array ke ek part ko reverse karne ke liye (O(n) time)
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}