//time complexity: O(nlogn) + O(n^2) = O(n^2)
//space complexity: O(n) for the list2D
import java.util.ArrayList;
import java.util.Arrays;

public class firstApproch {
    public int[][] merge(int[][] intervals) {

        // Dynamic list to store the final merged intervals
        ArrayList<int[]> list2D = new ArrayList<>();
        
        // Sort the intervals based on their start times in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Loop through each interval in the sorted array
        for (int i = 0; i < intervals.length; i++) {

            // Extract the start and end values of the current interval
            int starti = intervals[i][0];
            int endi = intervals[i][1];

            // Inner loop to check and merge subsequent overlapping intervals
            for (int j = i + 1; j < intervals.length; j++) {

                // Check if the next interval's start time falls within the current interval
                if (intervals[j][0] >= starti && intervals[j][0] <= endi) {
                    
                    // Case 1: Next interval is completely inside the current interval
                    if (intervals[j][1] <= endi) {
                        // Mark it as processed/deleted by setting values to -1
                        intervals[j][0] = -1;
                        intervals[j][1] = -1;
                    } 
                    // Case 2: Next interval extends beyond the current end time (partial overlap)
                    else if (intervals[j][1] > endi) {
                        // Expand the current interval's end time in the array and local variable
                        intervals[i][1] = intervals[j][1];
                        endi = intervals[j][1];
                        
                        // Mark the absorbed interval as processed/deleted
                        intervals[j][0] = -1;
                        intervals[j][1] = -1;
                        
                        // Reset local bounds to the updated values
                        starti = intervals[i][0];
                        endi = intervals[i][1];
                    }
                }
            }
            
            // If the interval was not marked as deleted, add it to the tracking list
            if (starti != -1 && endi != -1) {
                int[] temp = new int[2];
                temp[0] = starti;
                temp[1] = endi;
                list2D.add(temp);
            }
        }
        
        // Initialize a 2D primitive array with the exact size of the merged list
        int[][] ans = new int[list2D.size()][2];

        // Convert the 2D ArrayList back into a standard 2D integer array
        for (int i = 0; i < list2D.size(); i++) {
            ans[i][0] = list2D.get(i)[0];
            ans[i][1] = list2D.get(i)[1];
        }
        
        // Return the final merged 2D array
        return ans;
    }
}