//Time complexity: O(nlogn) + O(n) = O(nlogn)
 //Space complexity: O(n) for the list2D
import java.util.ArrayList;
import java.util.Arrays;

public class optimalApproch {public int[][] merge(int[][] intervals) {
        // Edge case: Agar array khali hai ya sirf 1 interval hai, toh wahi return kar do
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Intervals ko unke start times ke basis par ascending order mein sort karo
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Merged intervals ko store karne ke liye list
        ArrayList<int[]> mergedList = new ArrayList<>();

        // 2. Pehla interval seedha list mein daal do taaki compare karne ke liye ek base mil jaye
        mergedList.add(intervals[0]);

        // 3. Baaki bache hue intervals par single loop chalao
        for (int i = 1; i < intervals.length; i++) {
            
            // List ka aakhri add kiya hua interval nikal lo
            int[] lastMerged = mergedList.get(mergedList.size() - 1);
            
            // Current interval jo abhi check kar rahe hain
            int[] currentInterval = intervals[i];

            // 4. Overlap Check: Agar current ka start pichle ke end se chota ya barabar hai
            if (currentInterval[0] <= lastMerged[1]) {
                // Overlap hai! Pichle interval ka end time update kar do
                // Math.max isliye taaki [1,4] aur [2,3] jaise cases mein end time 4 hi rahe
                lastMerged[1] = Math.max(lastMerged[1], currentInterval[1]);
            } else {
                // Overlap nahi hai! Naye interval ko seedha list mein daal do
                mergedList.add(currentInterval);
            }
        }

        // 5. ArrayList ko wapas 2D array (int[][]) mein convert karke return kar do
        return mergedList.toArray(new int[mergedList.size()][]);
    }}