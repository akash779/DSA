public class optimalApproch {
    public void sortColors(int[] nums) {

        int low=0;
        int mid =0;
        int high = nums.length-1;
        

        while(mid<=high){
            if(nums[mid]==0){
                nums[mid] = nums[low];
                nums[low]=0;
                if(low==mid){mid++;low++;}
                else{low++;}
                


            }
            else if(nums[mid]==2){
                nums[mid]=nums[high];
                nums[high]=2;
                high--;

            }
            else{mid++;}

        }
    }
}
