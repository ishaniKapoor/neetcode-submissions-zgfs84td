/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> times = new ArrayList<>();
        for (Interval i : intervals){
            times.add(new int[]{i.start, 1});
            times.add(new int[]{i.end, -1});
        }

        times.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int res = 0, count = 0;
        for (int[] t: times){
            count += t[1];
            res = Math.max(res, count);
        }
        
        return res;
    }
}
