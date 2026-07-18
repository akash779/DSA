// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(1)
//Description: This code implements a brute force approach to find the maximum subarray sum in an integer array. It iterates through all possible subarrays, calculates their sums, and keeps track of the maximum sum found. The time complexity is O(n^2) due to the nested loops, and the space complexity is O(1) as it uses a constant amount of extra space.
public class firstApproch {
    
    public int maxSubArray(int[] nums) {

        
        int maxSum = Integer.MIN_VALUE;;
        for(int i=0;i<nums.length;i++){
             int sum=0;
            for(int j=i;j<nums.length;j++){
                
               
                sum+=nums[j];
                if(sum>maxSum){maxSum=sum;}



            }
        }

        return maxSum;
        
    }
}
