public class firstApproch{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a1 = m - 1;          // nums1 ka last valid element
        int a2 = n - 1;          // nums2 ka last element
        int p1 = m + n - 1;      // nums1 ki total capacity ka last index

        // Jab tak nums2 ke elements bache hain
        while (a2 >= 0) {
            // Agar nums1 ke elements abhi bache hain AND nums1[a1] bada hai
            if (a1 >= 0 && nums1[a1] > nums2[a2]) {
                nums1[p1] = nums1[a1];
                a1--;
            } else {
                // Ya toh nums1 khatam ho gaya, ya nums2 ka element bada hai
                nums1[p1] = nums2[a2];
                a2--;
            }
            p1--;
        }
    }
}