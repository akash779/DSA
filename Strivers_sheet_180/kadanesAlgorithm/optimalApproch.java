//Time Complexity:O(N)
//Space Complexity:O(1)
//
class OptimalApproch {
    public int maxSubArray(int[] nums) {

        int sum =0;
        int maxSum= Integer.MIN_VALUE;
       for(int i=0 ; i < nums.length ; i++){

            if(sum<0){sum=0;}
            sum +=nums[i];
            if(maxSum<sum){maxSum=sum;}

       }
       return maxSum;
        
    }
}