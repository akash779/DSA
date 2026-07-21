 //Time complexity: O(nlogn) + O(n) = O(nlogn)
//Space complexity: O(n) for the list2D

 import java.util.ArrayList;
 import java.util.Arrays;
public class secondApproch {
    public int[][] merge(int[][] intervals) {

        // Agar intervals array ki length sirf 1 hai, toh wahi array return kar do
        if (intervals.length == 1) {
            return intervals;
        }
        
        // Intervals ko unke start times ke basis par ascending order mein sort karo
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Merged intervals ko store karne ke liye dynamic list
        ArrayList<int[]> list2D = new ArrayList<>();
        
        // Pehle interval ke start aur end values ko variables mein store karo
        int starti = intervals[0][0];
        int endi = intervals[0][1];

        // Baaki ke intervals par loop chalao
        for (int i = 1; i < intervals.length; i++) {

            // Agar list khali hai, toh pehla interval list mein add kar do
            if (list2D.isEmpty()) {
                int[] temp = new int[2];
                temp[0] = starti;
                temp[1] = endi;
                list2D.add(temp);
            }
            
            // Check karo ki current interval pichle wale ke sath overlap karta hai ya nahi
            if (intervals[i][0] >= starti && intervals[i][0] <= endi) {
                // Agar current interval ka end time pichle wale ke andar hi hai, toh skip karo
                if (intervals[i][1] <= endi) {
                    continue;
                } else  {
                    // Agar current interval aage tak extend ho raha hai, toh endi ko update karo
                    endi=intervals[i][1];
                }
            }
            else{
                // Agar overlap nahi hota, toh naye interval se start aur end update karo
                starti=intervals[i][0];
                endi=intervals[i][1];
            }
            
            // List ka aakhri element nikal kar check karo
            int lastElement [] =list2D.get(list2D.size() - 1);
            
            // Agar last element ki conditions match hoti hain, toh usko update karo
            if(lastElement[0]>=starti && lastElement[1]<=endi){
                list2D.get(list2D.size() - 1)[0] = starti;
                list2D.get(list2D.size() - 1)[1] = endi;
            }
            else{
                // Warna naye interval ko list mein add kar do
                int[] temp = new int[2];
                temp[0] = starti;
                temp[1] = endi;
                list2D.add(temp);
            }

        }
        
        // 2D ArrayList ko standard 2D primitive array mein convert karo
        int[][] ans = new int[list2D.size()][2];
        for (int i = 0; i < list2D.size(); i++) {
            ans[i][0] = list2D.get(i)[0];
            ans[i][1] = list2D.get(i)[1];
        }
        
        // Final merged 2D array return karo
        return ans;
    }
}